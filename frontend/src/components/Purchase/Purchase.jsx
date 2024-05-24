import React from "react";
import "./Purchase.css";
const PurchaseItem = ({ platform, formats, onFormatChange }) => {
    const handleFormatChange = (formatId, isChecked) => {
        onFormatChange(platform.id, formatId, isChecked, 'purchase');
    };

    return (
        <div className="purchase-item">
            <div className="purchase-title">{platform.name}</div>
            {formats.map((format) => (
                <div key={format.id} className="purchase-format">
                    <input
                        type="checkbox"
                        id={`purchase-${platform.id}-${format.id}`}
                        name={`${platform.name}-${format.name}`}
                        onChange={(e) => handleFormatChange(format.id, e.target.checked)}
                        className="purchase-checkbox"
                    />
                    <label htmlFor={`purchase-${platform.id}-${format.id}`}>{format.name}</label>
                </div>
            ))}
        </div>
    );
};

const Purchase = ({ platforms, formats, onFormatChange }) => {
    return (
        <section className="purchases">
            <h2 className="purchases-title">Purchase:</h2>
            <div className="purchases-list">
                {platforms.map((platform) => (
                    <PurchaseItem
                        key={platform.id}
                        platform={platform}
                        formats={formats}
                        onFormatChange={onFormatChange}
                    />
                ))}
            </div>
        </section>
    );
}

export default Purchase;