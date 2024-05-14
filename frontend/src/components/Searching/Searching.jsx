import React, { useState } from 'react';
import './Searching.css';
import axios from '../../../axiosConfig.js';
import GreenSearch from '../../img/green-search.svg';
const Searching = ({ onSearchResults }) => {
    const [searchQuery, setSearchQuery] = useState('');
    const [searchResults, setSearchResults] = useState([]);

    const handleSearch = async (e) => {
        e.preventDefault(); // Zapobieganie domyślnemu zachowaniu formularza
        try {
            const response = await axios.get(`/api/search?query=${searchQuery}`);
            setSearchResults(response.data);
            // Przekazanie wyników wyszukiwania do komponentu Search
            onSearchResults(response.data);
        } catch (error) {
            console.error('Error searching books:', error);
        }
    };

    return (
        <div className="searching-container">
            <form className="form-searching" onSubmit={handleSearch}>
                <input
                    type="text"
                    placeholder="Search for title or author..."
                    id="searching"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
                <button type="submit" className="search-button">
                    <img src={GreenSearch} alt="Search" className="search-icon"/>
                </button>
            </form>
        </div>
    );
};

export default Searching;