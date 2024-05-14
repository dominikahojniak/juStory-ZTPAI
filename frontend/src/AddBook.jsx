import React, { useState } from 'react';
import './AddBook.css';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import Subscription from "./components/Subscription/Subscription.jsx";
import axios from '../axiosConfig.js'; // Import Axios
    const AddBook = () => {
        const [title, setTitle] = useState('');
        const [author, setAuthor] = useState('');
        const [ISBN, setISBN] = useState('');
        const [date, setDate] = useState('');
        const [language, setLanguage] = useState('');
        const [description, setDescription] = useState('');
        const [file, setFile] = useState(null);

        const handleChange = (e) => {
            const { name, value } = e.target;
            if (name === 'file') {
                setFile(e.target.files[0]);
            } else if (name === 'title') {
                setTitle(value);
            } else if (name === 'author') {
                setAuthor(value);
            } else if (name === 'ISBN') {
                setISBN(value);
            } else if (name === 'date') {
                setDate(value);
            } else if (name === 'language') {
                setLanguage(value);
            } else if (name === 'description') {
                setDescription(value);
            }
        };

        const handleSubmit = async (e) => {
            e.preventDefault();
            if (!title  || !author || !ISBN || !date || !language || !description || !file) {
                alert('Please fill in all fields.');
                return;
            }
            try {
                const formData = new FormData();
                formData.append('title', title);
                formData.append('author', author);
                formData.append('ISBN', ISBN);
                formData.append('date', date);
                formData.append('language', language);
                formData.append('description', description);
                formData.append('file', file);

                const response = await axios.post('/api/books/add', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });

                console.log('Book added successfully:', response.data);
                alert('Book added successfully');
            } catch (error) {
                console.error('Error adding book:', error);
                // Tutaj możesz dodać kod obsługujący błąd, np. wyświetlenie komunikatu o błędzie
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
                    <form className="form-addbook" onSubmit={handleSubmit} >
                        <input name="title" type="text" placeholder="title" id="title" value={title} onChange={handleChange} />
                        <input name="author" type="text" placeholder="author" id="author" value={author} onChange={handleChange} />
                        <input name="ISBN" type="text" placeholder="ISBN" id="ISBN" value={ISBN} onChange={handleChange} />
                        <input name="date" type="text" placeholder="date" id="date" value={date} onChange={handleChange} />
                        <input name="language" type="text" placeholder="language" id="language" value={language} onChange={handleChange} />
                        <input name="description" type="text" placeholder="description" id="description" value={description} onChange={handleChange} />
                        <input name="file" type="file" onChange={handleChange} /> {/* Dodajemy pole input typu file */}
                        <Subscription/>
                        <button type="submit" id="add-button">ADD BOOK</button>
                    </form>
                </div>
            </main>
            <Footer/>
        </div>
    );
}

export default AddBook;