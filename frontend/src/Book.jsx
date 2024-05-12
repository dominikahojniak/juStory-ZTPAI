import React from 'react';
import './Book.css';
import okladka from './img/okladka.jpg';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import PlatformItem from './components/PlatformItem/PlatformItem.jsx';
import X from './img/goingBack.svg';
const Book = () => {
    return (
        <div className='book-container'>
           <Header activePage="book" />
            <main className='main-book'>
                <div className="left">
                    <div className="x">
                        <a href="home"><img src={X} alt="Go Back Icon" /></a>
                    </div>
                </div>
                <div className="middle">
                    <div className="image">
                        <img className="news-image-book" src={okladka} alt="Book Cover" />
                    </div>
                    <form className="form-book">
                        <button id="add-button">+ To Read</button>
                    </form>
                </div>
                <div className="right">
                    <div className="news-description-book">
                        <h3>Title</h3>
                        <p>by Author</p>
                        <p>date: 00.00.0000</p>
                    </div>
                    <div className="subscription">
                        <div className="news-title-container-book">
                            <div className="news-title-book">
                                <h3>Subscription</h3>
                            </div>
                        </div>
                        <div className="items">
                           <PlatformItem/>
                           <PlatformItem/>
                           <PlatformItem/>
                           <PlatformItem/>
                           <PlatformItem/>
                        </div>
                    </div>
                    <div className="buy">
                        <div className="news-title-container-book">
                            <div className="news-title-book">
                                <h3>Buy</h3>
                            </div>
                        </div>
                        <div className="items">
                            <PlatformItem/>
                            <PlatformItem/>
                            <PlatformItem/>
                            <PlatformItem/>
                            <PlatformItem/>
                        </div>
                    </div>
                    <div className="news-description-book">
                        <p>Description</p>
                    </div>
                </div>
            </main>
          <Footer/>
        </div>
    );
}

export default Book;