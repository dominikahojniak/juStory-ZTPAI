import React from 'react';
import './Search.css';
import Footer from './components/Footer/Footer.jsx';
import Header from './components/Header/Header.jsx';
import Searching from './components/Searching/Searching.jsx';
const Search = () => {
  return (
    <div className="search-container">
       <Header activePage="search" />
      <main className='main-search'>
        <div className="search">Search</div>
       <Searching/>
      </main>
      <Footer />
    </div>
  );
}

export default Search;