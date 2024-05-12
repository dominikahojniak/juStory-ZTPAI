import React from 'react';
import './ToRead.css'; 
import okladka from './img/okladka.jpg';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import BookInfoToRead from './components/BookInfoToRead/BookInfoToRead.jsx';
function ToRead() {
  return (
    <div className='toread-container'>
    <Header activePage="toRead" />
      <main className='main-toread'>
        <div className="toRead">ToRead</div>
        <div className="news-toread">
            <BookInfoToRead title="Title 1" author="Author 1" imageSrc={okladka} />
            <BookInfoToRead title="Title 1" author="Author 1" imageSrc={okladka} />
            <BookInfoToRead title="Title 1" author="Author 1" imageSrc={okladka} />
            <BookInfoToRead title="Title 1" author="Author 1" imageSrc={okladka} />
            <BookInfoToRead title="Title 1" author="Author 1" imageSrc={okladka} />
            <BookInfoToRead title="Title 1" author="Author 1" imageSrc={okladka} />
        </div>
      </main>
      <Footer showProfileAndHello={false}/>
    </div>
  );
}

export default ToRead;