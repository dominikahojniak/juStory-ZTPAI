import React from "react";
import "./Subscription.css"; // Importowanie pliku CSS

// Komponent SubscriptionItem
const SubscriptionItem = ({ title }) => {
    return (
        <div className="subscription-item ">
            <input type="checkbox" className="subscription-checkbox" />
            <div className="subscription-title">{title}</div>
        </div>
    );
};

// Komponent MyComponent
const Subscription = () => {
    const subscriptions = [
        { title: "Legimi" },
        { title: "Bookbeat" },
        { title: "Storytell" },
        { title: "EmpikGo" },
    ];

    return (
        <section className="sub">
            <h2 className="sub-title">Subscription:</h2>
            <div className="sub-list">
                {subscriptions.map((subscription, index) => (
                    <React.Fragment key={index}>
                        <SubscriptionItem title={subscription.title} />
                    </React.Fragment>
                ))}
            </div>
        </section>
    );
}

export default Subscription;