import React from 'react';
import './BookInfoToRead.css'
const BookInfoPremieres = ({ title, author, imageSrc }) => {
  return (
    <div className="news-container-toread">
      <img className="news-image-toread" src={imageSrc} alt="News Image 1" />
      <div className="news-description-toread">
        <h3>{title}</h3>
        <p>by {author}</p>
      </div>
      <div className="remove-button">
        <form className="form-toread" >
          <button type="submit" id="remove-button" name="remove_button">- Remove</button>
        </form>
      </div>
    </div>
  );
}

export default BookInfoPremieres;