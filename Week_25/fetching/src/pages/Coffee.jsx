import { useState } from "react";
import React from "react";
import Main from "../layouts/Main";
import {useAsyncState} from "./../Hook/useAsyncState"
import {getHotCoffees, getIcedCoffees} from "./../services/coffee-service"
import CoffeeItem from "./../components/Coffee/Coffee";
const Coffee = () => {
  const [temperature, setTemperature] = useState("hot");
  const fetcher = temperature === "hot" ? getHotCoffees : getIcedCoffees;
  const coffeeList = useAsyncState([], fetcher);

  return (
    <Main>
        <button
        onClick={() => {
          if (temperature === "hot") {
            setTemperature("iced");
          }
          if (temperature === "iced") {
            setTemperature("hot");
          }
        }}
      >
        Toggle Temperature
      </button>
      {coffeeList.isIdle &&
        coffeeList.data?.map((item) => {
          return (
            <CoffeeItem
              key={item.id}
              id={item.id}
              title={item.title}
              description={item.description}
              ingredient={item.ingredients}
              image={item.image}
            />
          );
        })}
    </Main>
  );
};

export default Coffee;
