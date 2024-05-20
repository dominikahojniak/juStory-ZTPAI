import React from 'react';
import './BookInfoToRead.css'
const BookInfoToRead = ({ id, title, author, imageSrc, removeBook }) => {
    const handleRemove = (e) => {
        e.preventDefault();
        removeBook(id);  // Wywołanie funkcji removeBook przekazanej z komponentu nadrzędnego
    };

  return (
    <div className="news-container-toread">
      <img className="news-image-toread" src={imageSrc} alt="News Image 1" />
      <div className="news-description-toread">
        <h3>{id}, {title}</h3>
        <p>by {author}</p>
      </div>
        <div className="remove-button">
            <form className="form-toread" onSubmit={handleRemove}>
                <button type="submit" id="remove-button" name="remove_button">- Remove</button>
            </form>
        </div>
    </div>
  );
}

export default BookInfoToRead;