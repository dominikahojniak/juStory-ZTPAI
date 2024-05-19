import React from 'react';
import './homeBook.css';
import { Link } from 'react-router-dom';
const HomeBook = ({ id, imageSrc, title }) => {
  return (
    <div className="news-container">
        <Link to={`/book/${id}`}>
      <img className="news-image" src={imageSrc} alt="Book Cover" />
      <div className="news-description">
        <h3>{title}</h3>
      </div>
        </Link>
    </div>
  );
}
export default HomeBook;