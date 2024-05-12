import React, { useState, useEffect } from 'react';
import './Profile.css';
import Header from './components/Header/Header.jsx';
import Footer from './components/Footer/Footer.jsx';
import profileImage from './img/duzeprofil.svg';
import axios from '../axiosConfig.js';

const Profile = () => {
    const [userProfile, setUserProfile] = useState(null);

    useEffect(() => {
        const fetchUserProfile = async () => {
            try {
                const response = await axios.get('/api/users/profile', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
                });
                const { email, name } = response.data;
                setUserProfile({ email, name });
            } catch (error) {
                console.error('Error fetching user profile:', error);
            }
        };

        fetchUserProfile();
    }, []);

    return (
        <div className='profile-container'>
            <Header activePage="profile" />
            <main className='main-profile'>
                <div className="profile">
                    Profile
                </div>
                <div className="profilepic">
                    <img className="profile-image" src={profileImage} alt="Profile Image"/>
                </div>
                {userProfile && (
                <div className="news-profile">
                    <div className="name-profile">{userProfile.name}</div>
                    <div className="email-profile">{userProfile.email}</div>
                    <a href="/login" className="logout-profile">Log out</a>
                </div>
                )}
            </main>
            <Footer showProfileAndHello={false}/>
        </div>
    );
}

export default Profile;