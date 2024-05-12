import React from 'react';
import './footer.css';
import maleprofil from '../../img/maleprofil.svg';
import linkedin from '../../img/linkedin.svg';
import facebook from '../../img/fb.svg';
import ig from '../../img/ig.svg';
const Footer = ({ showProfileAndHello , username}) => {
    return (
        <footer className={`footer-id ${showProfileAndHello ? 'home-footer-visible' : 'no'}`}>
            <ul className="footer-list">
                <li><a href="help.html">Help</a></li>
                <li><a href="aboutUs.html">About Us</a></li>
                <li><a href="contact.html">Contact</a></li>
                {showProfileAndHello && <li>Hello {username}</li>}
            </ul>
            <div className="media-footer">
                <a href="https://www.linkedin.com/notifications/?filter=all" target="_blank"><img src={linkedin} alt="linkedin" /></a>
                <a href="https://www.facebook.com/?locale=pl_PL" target="_blank"><img src={facebook} alt="facebook" /></a>
                <a href="https://www.instagram.com" target="_blank"><img src={ig} alt="instagram" /></a>
                {showProfileAndHello && <a href="profile"><img src={maleprofil} alt="Male Profile" /></a>}
            </div>
        </footer>
    );
}

export default Footer;