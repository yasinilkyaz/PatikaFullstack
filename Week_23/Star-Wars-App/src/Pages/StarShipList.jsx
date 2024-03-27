import React, { useState, useEffect } from 'react';
import axios from 'axios';

function StarshipList() {
    const [starships, setStarships] = useState([]);
    const [filteredStarships, setFilteredStarships] = useState([]);
    const [nextPageUrl, setNextPageUrl] = useState('');
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedStarship, setSelectedStarship] = useState(null);

    useEffect(() => {
        async function fetchStarships() {
            try {
                const response = await axios.get('https://swapi.dev/api/starships');
                setStarships(response.data.results);
                setFilteredStarships(response.data.results);
                setNextPageUrl(response.data.next);
            } catch (error) {
                console.error('Error fetching starships:', error);
            }
        }

        fetchStarships();
    }, []);

    const loadMoreStarships = async () => {
        try {
            const response = await axios.get(nextPageUrl);
            setStarships(prevState => [...prevState, ...response.data.results]);
            setFilteredStarships(prevState => [...prevState, ...response.data.results]);
            setNextPageUrl(response.data.next);
        } catch (error) {
            console.error('Error loading more starships:', error);
        }
    };

    const handleSearch = (e) => {
        const searchTerm = e.target.value.toLowerCase();
        setSearchTerm(searchTerm);
        const filteredResults = starships.filter(starship => {
            return starship.name.toLowerCase().includes(searchTerm) || starship.model.toLowerCase().includes(searchTerm);
        });
        setFilteredStarships(filteredResults);
    };

    const handleStarshipClick = (selectedStarship) => {
        setSelectedStarship(selectedStarship);
    };

    const handleBack = () => {
        setSelectedStarship(null);
    };

    return (
        <div className="starship-list">
            <img className='image' src="/Star_Wars_Logo.svg" alt="" />
            <h1>Starships</h1>
            {!selectedStarship && (
                <div className="filter-container input-container">
                    <input
                        type="text"
                        placeholder="Search by name or model"
                        value={searchTerm}
                        onChange={handleSearch}
                    />
                </div>
            )}
            <div className="card-container">
                {!selectedStarship ? (
                    filteredStarships.map(starship => (
                        <div key={starship.url} className="card" onClick={() => handleStarshipClick(starship)}>
                            <img className='image' src="/ship.jpg" alt="" />
                            <h2>{starship.name}</h2>
                            <p>Model: {starship.model}</p>
                        </div>
                    ))
                ) : (
                    <div className="expanded-card">
                        <button onClick={handleBack}>Back</button>
                        
                        <h2>{selectedStarship.name}</h2>
                        <img className='image' src="/ship.jpg" alt="" />
                        <p>Model: {selectedStarship.model}</p>
                        <p>Manufacturer: {selectedStarship.manufacturer}</p>
                        <p>Cost in Credits: {selectedStarship.cost_in_credits}</p>
                        <p>Length: {selectedStarship.length}</p>
                        <p>Max Atmosphering Speed: {selectedStarship.max_atmosphering_speed}</p>
                        <p>Crew: {selectedStarship.crew}</p>
                        <p>Passengers: {selectedStarship.passengers}</p>
                        <p>Cargo Capacity: {selectedStarship.cargo_capacity}</p>
                        <p>Consumables: {selectedStarship.consumables}</p>
                        <p>Hyperdrive Rating: {selectedStarship.hyperdrive_rating}</p>
                        <p>MGLT: {selectedStarship.MGLT}</p>
                        <p>Starship Class: {selectedStarship.starship_class}</p>
                    </div>
                )}
            </div>
            {nextPageUrl && !selectedStarship && (
                <button className='load-more-button' onClick={loadMoreStarships}>Load More</button>
            )}
        </div>
    );
}

export default StarshipList;
