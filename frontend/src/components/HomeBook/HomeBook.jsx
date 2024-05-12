import React from 'react';
import './homeBook.css'; 
const HomeBook = ({ imageSrc, title }) => {
  return (
    <div className="news-container">
      <img className="news-image" src={imageSrc} alt="Book Cover" />
      <div className="news-description">
        <h3>{title}</h3>
      </div>
    </div>
  );
}
export default HomeBook;