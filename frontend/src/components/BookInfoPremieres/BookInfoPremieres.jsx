import React from 'react';
import './BookInfoPremieres.css';
const BookInfoPremieres = ({ date, title, imageSrc }) => {
    return (
        <div className="news-container-premieres">
            <div className="date"> <h3>{date}</h3> </div>
            <div className="right-premieres">
                <div className="news-description-premieres">
                    <p>{title}</p>
                </div>
                <img className="news-image-premieres" src={imageSrc} alt="News Image 1" />
            </div>
        </div>
    );
}

export default BookInfoPremieres;