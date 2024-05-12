import React from 'react';
import okladka from './img/okladka.jpg';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import BookInfoPremieres from './components/BookInfoPremieres/BookInfoPremieres.jsx';
import './premieres.css'; 
const Premieres = () => {
    return (
        <div className="premieres-container">
            <Header activePage="premieres" />
            <main className='main-premieres'>
                <div className="premieres">
                    Premieres
                </div>
                <div className="news-premieres">
                <BookInfoPremieres date="Date 1" title="Title 1" imageSrc={okladka} />
                <BookInfoPremieres date="Date 1" title="Title 1" imageSrc={okladka} />
                <BookInfoPremieres date="Date 1" title="Title 1" imageSrc={okladka} />
                <BookInfoPremieres date="Date 1" title="Title 1" imageSrc={okladka} />
                <BookInfoPremieres date="Date 1" title="Title 1" imageSrc={okladka} />
                <BookInfoPremieres date="Date 1" title="Title 1" imageSrc={okladka} />
                </div>
            </main>
            <Footer showProfileAndHello={false}/>
        </div>
    );
}

export default Premieres;