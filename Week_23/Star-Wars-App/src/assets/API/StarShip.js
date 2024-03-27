import axios from "axios";



async function getAllStarships() {
    try {
        const response = await axios.get('https://swapi.dev/api/starships');
        return response.data.results;
    } catch (error) {
        console.error('Error fetching starships:', error);
        return [];
    }
}

// Belirli bir starship'i id'ye göre getiren fonksiyon
async function getStarshipById(id) {
    try {
        const response = await axios.get(`https://swapi.dev/api/starships/${id}`);
        return response.data;
    } catch (error) {
        console.error(`Error fetching starship with id ${id}:`, error);
        return null;
    }
}