import React from 'react';
import './PlatformItem.css';
import Legimi from '../../img/legimi.svg';
import Ebook from '../../img/ebook.svg';
import Headphones from '../../img/headphones.svg';
function PlatformItem() {
    return (
        <div className="platform-item">
            <img src={Legimi} className="platform-image" alt="Legimi Logo" />
            <div className="options">
                <img src={Ebook} alt="Ebook Icon" />
                <img src={Headphones} alt="Headphones Icon" />
            </div>
        </div>
    );
}

export default PlatformItem;