import React, { useState } from "react";
import Card from "../src/component/Card";
import data from "../src/data";

function App() {
  const [money, setMoney] = React.useState(100000000000);
  const [total, setTotal] = React.useState(0);
  const [items, setItems] = useState({});

  const handleBuy = (price, itemId) => {
    setMoney(money - price);
    setTotal(total + price);
    setItems((prevItems) => ({
      ...prevItems,
      [itemId]: (prevItems[itemId] || 0) + 1,
    }));
  };

  const handleSell = (price, itemId) => {
    if (items[itemId] === 0 || !items[itemId]) return;
    setMoney(money + price);
    setTotal(total - price);
    setItems((prevItems) => ({
      ...prevItems,
      [itemId]: prevItems[itemId] - 1,
    }));
  };

  return (
    <>
      <h1>Spend Bill Gates' Money</h1>
      <div className="total-money">
        <p>${money}</p>
        <p>Total Spend: ${total}</p>
      </div>

      <div className="card-container">
        {data.map((item) => {
          return (
            <Card
              onBuy={() => handleBuy(item.price, item.id)}
              onSell={() => handleSell(item.price, item.id)}
              key={item.id}
              item={item}
              setItems={setItems}
              quantity={items[item.id] || 0}
            />
          );
        })}
        <div>
          <p>Your Receipt</p>
          {Object.keys(items).map((id) => {
            const item = data.find((i) => i.id === parseInt(id));
            if (!item) return null;
            return (
              <p key={id}>
                {item.name} x {items[id]}
              </p>
            );
          })}
          <p>Total: ${total}</p>
        </div>
      </div>
    </>
  );
}

export default App;
