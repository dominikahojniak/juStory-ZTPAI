import React, { useState, useEffect } from 'react';
import './header.css';
import malelogo from '../../img/malelogo.png';
import greenHome from '../../img/green-home.svg';
import greenPremieres from '../../img/green-premieres.svg';
import greenSearch from '../../img/green-search.svg';
import greenToRead from '../../img/green-toRead.svg';
import greenProfile from '../../img/green-profile.svg';
import home from '../../img/home.svg';
import premieres from '../../img/premieres.svg';
import toRead from '../../img/toRead.svg';
import search from '../../img/search.svg';
import profile from '../../img/profile.svg';
import axios from '../../../axiosConfig.js';
const Header = ({ activePage }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await axios.get('/api/users/profile', {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        });
        setIsLoggedIn(true);
      } catch (error) {
        setIsLoggedIn(false);
      }
    };

    // Wywołanie funkcji pobierającej dane użytkownika
    fetchUserData();
  }, []);
const isLogSignPage = activePage === 'logsign';
const headerClass = isLogSignPage ? 'header-nav logsign-page' : 'header-nav';
const isHomePage = activePage === 'home';
const homeImage = isHomePage ? greenHome : home;
const isPremieresPage = activePage === 'premieres';
const premieresImage = isPremieresPage ? greenPremieres : premieres;
const isSearchPage = activePage === 'search';
const searchImage = isSearchPage ? greenSearch : search;
const isToReadPage = activePage === 'toRead';
const ToReadImage = isToReadPage ? greenToRead : toRead;
const isProfilePage = activePage === 'profile';
const ProfileImage = isProfilePage ? greenProfile : profile;
  return (
    <nav className={headerClass}>
      <ul>
        <li>
          <div className="images-container">
            <img src={malelogo} alt="logo" />
          </div>
        </li>
        <li><a href="home" className={activePage === 'home' ? 'active' : ''}><img src={homeImage} alt="Home" />Home</a></li>
        <li><a href="premieres" className={activePage === 'premieres' ? 'active' : ''}><img src={premieresImage} alt="Premieres" />Premieres</a></li>
        <li><a href="toRead" className={activePage === 'toRead' ? 'active' : ''}><img src={ToReadImage} alt="To Read" />To Read</a></li>
        <li><a href="search" className={activePage === 'search' ? 'active' : ''}><img src={searchImage} alt="Search" />Search</a></li>
        {isLoggedIn && (
        <li><a href="profile" className={activePage === 'profile' ? 'active' : ''}><img src={ProfileImage} alt="Profile" />Profile</a></li>
        )}
        {!isLoggedIn && (
        <div className="loginsignup">
          <a href="login">Log In</a>
          <a href="signup" id="signup-link">Sign Up</a>
        </div>
            )}
      </ul>
    </nav>
  );
};

export default Header;