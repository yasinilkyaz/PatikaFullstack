import React, { useState, useEffect } from 'react';

const Card = ({ item, onBuy, onSell, setItems }) => {
  const [quantity, setQuantity] = useState(0);

  const handleBuy = () => {
    setItems(prevItems => ({
      ...prevItems,
      [item.name]: (prevItems[item.name] || 0) + 1
    }));
    setQuantity(prevQuantity => prevQuantity + 1);
    onBuy(item.price);
  };
  const handleSell = () => {
    if (quantity === 0) return;
    setItems(prevItems => ({
      ...prevItems,
      [item.name]: prevItems[item.name] - 1
    }));
    setQuantity(prevQuantity => prevQuantity - 1);
    onSell(item.price);
  };

  const total = quantity * item.price;

  const handleChange = (e) => {
    const value = parseInt(e.target.value);
    const newValue = isNaN(value) ? 0 : Math.max(0, value);
    setQuantity(newValue);
  };
  return (
    <div className="card">
      <img src="https://picsum.photos/200" alt="" />
      <h3>{item.name}</h3>
      <p>Price: ${item.price}</p>
      <div>
        <button onClick={handleSell}>Sell</button>
        <input
          className='input'
          type="number"
          value={quantity}
          onChange={handleChange}
        />
        <button onClick={handleBuy}>Buy</button>
      </div>
      <p>Total: ${total}</p>
    </div>
  );
};

export default Card;