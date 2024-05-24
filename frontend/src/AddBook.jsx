import React, { useState, useEffect } from 'react';
import './AddBook.css';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import Subscription from "./components/Subscription/Subscription.jsx";
import Purchase from "./components/Purchase/Purchase.jsx";
import axios from '../axiosConfig.js';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';

import dayjs from 'dayjs';

const AddBook = () => {
    const [platforms, setPlatforms] = useState([]);
    const [formats, setFormats] = useState([]);
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [ISBN, setISBN] = useState('');
    const [date, setDate] = useState(dayjs());
    const [language, setLanguage] = useState('');
    const [description, setDescription] = useState('');
    const [file, setFile] = useState(null);
    const [selectedPlatforms, setSelectedPlatforms] = useState([]);
    const [selectedFormats, setSelectedFormats] = useState([]);
    const [subscriptionRequired, setSubscriptionRequired] = useState({});
    const [purchaseOption, setPurchaseOption] = useState({});
    const [errors, setErrors] = useState({
        title: false,
        author: false,
        language: false,
        description: false,
        ISBN: false,
        file: false,
    });
    useEffect(() => {
        const fetchPlatforms = async () => {
            try {
                const response = await axios.get('/api/platforms');
                setPlatforms(response.data);
            } catch (error) {
                console.error('Error fetching platforms:', error);
            }
        };

        const fetchFormats = async () => {
            try {
                const response = await axios.get('/api/formats');
                setFormats(response.data);
            } catch (error) {
                console.error('Error fetching formats:', error);
            }
        };

        fetchPlatforms();
        fetchFormats();
    }, []);
    useEffect(() => {
        const initialSubscriptionRequired = {};
        const initialPurchaseOption = {};

        platforms.forEach(platform => {
            initialSubscriptionRequired[platform.id] = false;
            initialPurchaseOption[platform.id] = false;
        });

        setSubscriptionRequired(initialSubscriptionRequired);
        setPurchaseOption(initialPurchaseOption);
    }, [platforms]);
    const validateISBN = (value) => {
        const isbnRegex = /^[0-9]{13}$/;
        return isbnRegex.test(value);
    };
    const validateFile = (file) => {
        const allowedExtensions = ['.png', '.jpg'];
        const extension = file && file.name.toLowerCase().slice(-4);
        return file && allowedExtensions.includes(extension);
    };
    const handleChange = (e) => {
        const { name, value } = e.target;
        let maxLength = 255;
        if (name === 'description') {
            maxLength = 2000;
        }
        if (value.length > maxLength) {
            setErrors(prevErrors => ({ ...prevErrors, [name]: true }));
        } else {
            setErrors(prevErrors => ({ ...prevErrors, [name]: false }));
        }
        if (name === 'file') {
            setFile(e.target.files[0]);
            setErrors(prevErrors => ({ ...prevErrors, file: !validateFile(e.target.files[0]) }));
        } else {
            eval(`set${name.charAt(0).toUpperCase() + name.slice(1)}`)(value);
            if (name === 'ISBN') {
                setErrors(prevErrors => ({ ...prevErrors, ISBN: !validateISBN(value) }));
            }
        }

    };

    const handleFormatChange = (platformId, formatId, isChecked, type) => {
        setSelectedPlatforms(prev => isChecked ? [...new Set([...prev, platformId])] : prev.filter(id => id !== platformId));
        setSelectedFormats(prev => isChecked ? [...new Set([...prev, formatId])] : prev.filter(id => id !== formatId));

        setSubscriptionRequired(prev => ({
            ...prev,
            [platformId]: type === 'subscription' ? isChecked : prev[platformId] || false
        }));

        setPurchaseOption(prev => ({
            ...prev,
            [platformId]: type === 'purchase' ? isChecked : prev[platformId] || false
        }));
    };
    const handleSubmit = async (e) => {
        e.preventDefault();
        if (errors.ISBN || errors.file || errors.title || errors.author || errors.language || errors.description) {
            alert('Please fix validation errors.');
            return;
        }
        if (!title || !author || !ISBN || !date || !language || !description || !file || selectedPlatforms.length === 0 || selectedFormats.length === 0) {
            alert('Please fill in all fields.');
            return;
        }
        try {
            const formData = new FormData();
            formData.append('file', file);
            formData.append('bookDTO.title', title);
            formData.append('bookDTO.author', author);
            formData.append('bookDTO.ISBN', ISBN);
            formData.append('bookDTO.date', date.format('YYYY-MM-DD'));
            formData.append('bookDTO.language', language);
            formData.append('bookDTO.description', description);
            selectedPlatforms.forEach((platformId, index) => {
                formData.append(`platforms[${index}].id`, platformId);
                formData.append(`platforms[${index}].subscriptionRequired`, subscriptionRequired[platformId]);
                formData.append(`platforms[${index}].purchaseOption`, purchaseOption[platformId]);
            });
            selectedFormats.forEach((formatId, index) => {
                formData.append(`formats[${index}].id`, formatId);
            });
            const token = localStorage.getItem('token');

            const response = await axios.post('/api/books/addWithAvailability', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                    'Authorization': `Bearer ${token}`
                }
            });

            console.log('Book added successfully:', response.data);
            alert('Book added successfully');
        } catch (error) {
            console.error('Error adding book:', error);
        }
    };

    return (
        <div className="addbook-container">
            <Header activePage="addbook" />
            <main className='main-addbook'>
                <div className="add">
                    Add Book
                </div>
                <div className="addbook">
                    <form className="form-addbook" onSubmit={handleSubmit}>
                        <input name="title" type="text" placeholder="title" id="title" value={title} onChange={handleChange} className={errors.title ? 'error' : ''} />
                        <input name="author" type="text" placeholder="author" id="author" value={author} onChange={handleChange} className={errors.author ? 'error' : ''}/>
                        <input name="ISBN" type="text" placeholder="ISBN" id="ISBN" value={ISBN} onChange={handleChange} className={errors.ISBN ? 'error' : ''}/>
                        <DatePicker
                            label="Select date"
                            value={date}
                            onChange={(newValue) => setDate(newValue)}
                            renderInput={(params) => <input {...params} />}
                            className="custom-date-picker"
                        />
                        <input name="language" type="text" placeholder="language" id="language" value={language} onChange={handleChange} className={errors.language ? 'error' : ''}/>
                        <input name="description" type="text" placeholder="description" id="description" value={description} onChange={handleChange} className={errors.description ? 'error' : ''}/>
                        <input name="file" type="file" onChange={handleChange} className={errors.file ? 'error' : ''}/>
                        <Subscription platforms={platforms} formats={formats} onFormatChange={(platformId, formatId, isChecked) => handleFormatChange(platformId, formatId, isChecked, 'subscription')} />
                        <Purchase platforms={platforms} formats={formats} onFormatChange={(platformId, formatId, isChecked) => handleFormatChange(platformId, formatId, isChecked, 'purchase')} />
                        <button type="submit" id="add-button">ADD BOOK</button>
                    </form>
                </div>
            </main>
            <Footer />
        </div>
    );
}

export default AddBook;