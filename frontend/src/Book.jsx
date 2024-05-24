import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './Book.css';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import PlatformItem from './components/PlatformItem/PlatformItem.jsx';
import X from './img/goingBack.svg';
import axios from '../axiosConfig.js';
const Book = () => {
    const { id } = useParams();
    const [book, setBook] = useState(null);
    const [availability, setAvailability] = useState([]);
    const [isAdded, setIsAdded] = useState(false);
    const [addError, setAddError] = useState("");
    useEffect(() => {
        const fetchBookData = async () => {
            try {
                const response = await axios.get(`/api/books/${id}`);
                setBook(response.data);
                const availabilityResponse = await axios.get(`/api/availability/${id}`);
                setAvailability(availabilityResponse.data);
                console.log("Availability data:", availabilityResponse.data);
            } catch (error) {
                console.error('Error fetching book data:', error);
            }
        };

        fetchBookData();
    }, [id]);
    const handleAddToReadList = async (e) => {
        e.preventDefault();
        try {
            await axios.post(`/api/toread/addbook/${id}`, {}, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });
            setIsAdded(true);
            setAddError("");
        } catch (error) {
            if (error.response && error.response.status === 409) {
                setAddError("Book is already in the to-read list.");
            } else {
                setAddError("Error adding book to read list.");
            }
            console.error('Error adding book to read list:', error);
        }
    };
    if (!book) {
        return <div>Loading...</div>;
    }
    return (
        <div className='book-container'>
           <Header activePage="book" />
            <main className='main-book'>
                <div className="left">
                    <div className="x">
                        <a href="/"><img src={X} alt="Go Back Icon" /></a>
                    </div>
                </div>
                <div className="middle">
                    <div className="image">
                        <img className="news-image-book" src={`data:image/jpeg;base64,${book.img}`} alt="Book Cover"/>
                    </div>
                    <form className="form-book">
                        {!isAdded && <button id="add-button" onClick={handleAddToReadList}>+ To Read</button>}
                        {isAdded && <div className="good-result">Book added to read list!</div>}
                        {addError && <div className="bad-result">{addError}</div>}
                    </form>
                </div>
                <div className="right">
                    <div className="news-description-book">
                        <h3>{book.title}</h3>
                        <p>by {book.author}</p>
                        <p>date: {new Date(book.date).toLocaleDateString()}</p>
                        <p>ISBN: {book.isbn}</p>

                    </div>
                    <div className="subscription">
                    <div className="news-title-container-book">
                            <div className="news-title-book">
                                <h3>Subscription</h3>
                            </div>
                        </div>
                        <div className="items">
                            {availability.map(item => (
                                item.subscriptionRequired && (
                                    <PlatformItem
                                        key={item.id}
                                        platformImg={`data:image/jpeg;base64, ${item.platform.img}`}
                                        formatImg={`data:image/jpeg;base64, ${item.format.img}`}
                                    />
                                )
                            ))}
                        </div>
                    </div>
                    <div className="buy">
                        <div className="news-title-container-book">
                            <div className="news-title-book">
                                <h3>Buy</h3>
                            </div>
                        </div>
                        <div className="items">
                            {availability.map(item => (
                                item.purchaseOption && (
                                    <PlatformItem
                                        key={item.id}
                                        platformImg={`data:image/jpeg;base64, ${item.platform.img}`}
                                        formatImg={`data:image/jpeg;base64, ${item.format.img}`}
                                    />
                                )
                            ))}
                        </div>
                    </div>
                    <div className="news-description-book">
                        <p>{book.description}</p>
                    </div>
                </div>
            </main>
          <Footer/>
        </div>
    );
}

export default Book;