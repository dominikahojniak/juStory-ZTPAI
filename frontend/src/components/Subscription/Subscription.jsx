import React from "react";
import "./Subscription.css"; // Importowanie pliku CSS
const SubscriptionItem = ({ platform, formats, onFormatChange }) => {
    const handleFormatChange = (formatId, isChecked) => {
        onFormatChange(platform.id, formatId, isChecked, 'subscription'); // Przekazanie informacji o platformie
    };

    return (
        <div className="subscription-item">
            <div className="subscription-title">{platform.name}</div>
            {formats.map((format) => (
                <div key={format.id} className="subscription-format">
                    <input
                        type="checkbox"
                        id={`subscription-${platform.id}-${format.id}`}
                        name={`${platform.name}-${format.name}`}
                        onChange={(e) => handleFormatChange(format.id, e.target.checked)}
                    />
                    <label htmlFor={`subscription-${platform.id}-${format.id}`}>{format.name}</label>
                </div>
            ))}
        </div>
    );
};

const Subscription = ({ platforms, formats, onFormatChange }) => {
    return (
        <section className="sub">
            <h2 className="sub-title">Subscription:</h2>
            <div className="sub-list">
                {platforms.map((platform) => (
                    <SubscriptionItem
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

export default Subscription;