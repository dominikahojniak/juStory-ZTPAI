import React, { useState } from 'react';
import './Search.css';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import Searching from './components/Searching/Searching.jsx';
const Search = () => {
    const [searchResults, setSearchResults] = useState([]);

    // Funkcja do przekazywania wyników wyszukiwania z komponentu Searching do komponentu Search
    const handleSearchResults = (results) => {
        setSearchResults(results);
    };
  return (
    <div className="search-container">
       <Header activePage="search" />
        <main className='main-search'>
            <div className="search">Search</div>
            <Searching onSearchResults={handleSearchResults}/>
                {searchResults.map((book) => (
                    <div key={book.id} className="search-items">{book.title} by {book.author}
                        <div className="cover-search">
                            <img src={`data:image/jpeg;base64, ${book.img}`} alt="Book cover" className="book-cover"/>
                        </div>
                    </div>
                ))}
        </main>
        <Footer/>
    </div>
  );
}

export default Search;