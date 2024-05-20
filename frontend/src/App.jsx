import React, { useState, useEffect } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Home from './Home.jsx';
import Login from './Login.jsx';
import SignUp from './Signup.jsx';
import Premieres from './Premieres.jsx';
import Search from './Search.jsx';
import ToRead from './ToRead.jsx';
import Profile from './Profile.jsx';
import Book from './Book.jsx';
import AddBook from "./AddBook.jsx";
import axios from '../axiosConfig.js';
const App = () => {
    const isLoggedIn = localStorage.getItem('token');
    const [userRole, setUserRole] = useState('');

    useEffect(() => {
        const fetchUserProfile = async () => {
            try {
                const response = await axios.get('/api/users/profile', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
                });
                setUserRole(response.data.role);
            } catch (error) {
                console.error('Error fetching user profile:', error);
            }
        };

        fetchUserProfile();
    }, []);
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Home/>} />
                <Route exact path="/home" element={<Home/>} />
                <Route exact path="/login" element={<Login/>}/>
                <Route exact path="/signup" element={<SignUp/>} />
                <Route exact path="/premieres" element={<Premieres/>} />
                <Route exact path="/search" element={<Search/>} />
                {isLoggedIn ? (
                    <Route exact path="/toRead" element={<ToRead/>} />

                ) : (
                    <Route exact path="/toRead" element={<Navigate to="/login" />} />
                )}
                <Route exact path="/profile" element={<Profile/>} />
                <Route path="/book/:id" element={<Book />} />
                {userRole === 'admin' ? (
                    <Route exact path="/addbook" element={<AddBook/>} />
                ) : (
                    <Route exact path="/addbook" element={<Navigate to="/home" />} />
                )}
                <Route exact path="/addbook" element={<AddBook/>} />
            </Routes>
        </Router>
    );
}

export default App;