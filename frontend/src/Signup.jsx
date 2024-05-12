import React, { useState } from 'react';
import './signup.css';
import { useNavigate } from 'react-router-dom';
import Footer from './components/Footer/Footer.jsx';
import mobilelogo from './img/malelogo.png';
import Header from './components/Header/Header.jsx';
import axios from '../axiosConfig.js'; // Import Axios
const SignUp = () => {
    const [email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState(null);
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleRegister = async (event) => {
        event.preventDefault();
        if (!email || !name || !phone || !password) {
            alert('Please fill in all fields.');
            return;
        }
        try {
            const response = await axios.post('/api/auth/register', {
                email: email,
                name: name,
                phone: phone,
                password: password,
            });
            localStorage.setItem('token', response.data.token);
            navigate('/login');
        } catch (error) {
            console.error('Registration failed:', error.response.data);
            alert('Registration failed');
        }
    };


    return (

        <div className="signup-container">
            <Header activePage="logsign" />
            <main className="signup-main">
                <div className="signup">
                    <form className="form-signup" onSubmit={handleRegister} >
                        <div className="form-login">
                            <p id="changeToLogin"><a href="login">Login</a></p>
                        </div>
                        <h1 id="signup-title">Sign Up</h1>
                        <div className="logoPhoto">
                            <img src={mobilelogo} alt="logo"/>
                        </div>
                        <input name="name" type="text" placeholder="name" id="name" value={name} onChange={e => setName(e.target.value)}/>
                        <input name="email" type="text" placeholder="email" id="email" value={email} onChange={e => setEmail(e.target.value)}/>
                        <input name="phone" type="text" placeholder="phone" id="phone" value={phone} onChange={e => setPhone(e.target.value)}/>
                        <input name="password" type="password" placeholder="password" id="password" value={password} onChange={e => setPassword(e.target.value)}/>
                        <button type="submit" id="signup-button"> SIGN UP</button>
                    </form>
                </div>
            </main>
            <Footer/>
        </div>
    );
}

export default SignUp;