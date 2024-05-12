import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './Home.jsx';
import Login from './Login.jsx';
import SignUp from './Signup.jsx';
import Premieres from './Premieres.jsx';
import Search from './Search.jsx';
import ToRead from './ToRead.jsx';
import Profile from './Profile.jsx';
import Book from './Book.jsx';
const App = () => {
    return (
        <Router>
           <Routes>
                <Route exact path="/" element={<Home/>} />
                <Route exact path="/home" element={<Home/>} />
                <Route exact path="/login" element={<Login/>}/>
                <Route exact path="/signup" element={<SignUp/>} />
                <Route exact path="/premieres" element={<Premieres/>} />
                <Route exact path="/search" element={<Search/>} />
                <Route exact path="/toRead" element={<ToRead/>} />
                <Route exact path="/profile" element={<Profile/>} />
                <Route exact path="/book" element={<Book/>} />
            </Routes>
        </Router>
    );
}
export default App;