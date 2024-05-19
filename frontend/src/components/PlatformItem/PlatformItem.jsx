import React from 'react';
import './PlatformItem.css';
import Legimi from '../../img/legimi.svg';
import Ebook from '../../img/ebook.svg';
import Headphones from '../../img/headphones.svg';
function PlatformItem({ platformImg, formatImg }) {
    return (
        <div className="platform-item">
            <img  className="platform-image" src={platformImg} alt="Platform Logo" />
            <div className="options">
                <img src={formatImg} alt="Format Icon" />
            </div>
        </div>
    );
}

export default PlatformItem;