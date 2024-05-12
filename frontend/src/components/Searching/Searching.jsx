import React from 'react';
import './Searching.css';

const Searching = () => {
  return (
    <div className="searching-container">
      <form className="form">
        <input type="text" placeholder="Search for title or author..." id="searching" />
      </form>
    </div>
  );
}

export default Searching;