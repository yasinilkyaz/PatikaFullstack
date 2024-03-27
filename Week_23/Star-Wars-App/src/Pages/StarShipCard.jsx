import React, { useState } from 'react';

function StarshipCard({ starship, onBack }) {
    const [isExpanded, setIsExpanded] = useState(false);

    const handleExpand = () => {
        setIsExpanded(true);
    };

    const handleCollapse = () => {
        setIsExpanded(false);
    };

    return (
        <div>
            {!isExpanded ? (
                <div className="card" onClick={handleExpand}>
                    <h2>{starship.name}</h2>
                    <p>Model: {starship.model}</p>
                </div>
            ) : (
                <div className="expanded-card">
                    <button onClick={handleCollapse}>Back</button>
                    <h2>{starship.name}</h2>
                    <p>Model: {starship.model}</p>
                    <p>Manufacturer: {starship.manufacturer}</p>
                    <p>Cost in Credits: {starship.cost_in_credits}</p>
                    <p>Length: {starship.length}</p>
                    <p>Max Atmosphering Speed: {starship.max_atmosphering_speed}</p>
                    <p>Crew: {starship.crew}</p>
                    <p>Passengers: {starship.passengers}</p>
                    <p>Cargo Capacity: {starship.cargo_capacity}</p>
                    <p>Consumables: {starship.consumables}</p>
                    <p>Hyperdrive Rating: {starship.hyperdrive_rating}</p>
                    <p>MGLT: {starship.MGLT}</p>
                    <p>Starship Class: {starship.starship_class}</p>
                    <button onClick={onBack}>Back</button>
                </div>
            )}
        </div>
    );
}

export default StarshipCard;