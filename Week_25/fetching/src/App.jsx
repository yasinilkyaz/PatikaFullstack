import { useEffect, useState } from "react";

import "./App.css";
import Coffee from "./components/Coffee/Coffee";
import { getHotCoffees, getIcedCoffees } from "./services/coffee-service";
import { useAsyncState } from "./Hook/useAsyncState";
import * as postsService from "./services/posts-service";
import Post from "./components/Post/Post";
import { useAsyncMutate } from "./Hook/useAsyncMutate";

function App() {
  const [temperature, setTemperature] = useState("hot");
  const [route, setRoute] = useState("coffee");
  const fetcher = temperature === "hot" ? getHotCoffees : getIcedCoffees;
  
  
  const coffeeList = useAsyncState([], fetcher);

  const postList = useAsyncState([],postsService.index, {
    mapper: (res) => res.data,
    onError: (error) => {
      console.log(error);
    },
    onSuccess: (value) => {
      console.log(value);
    },
    onFinally: () => {
      console.log("it is idle now");
    },
  });

  const postDelete=useAsyncMutate(postsService.remove, {
    onUpdate: (id) => {
      postList.setData((prev) => prev.filter((item) => item.id !== id));
    },
    onError:(error)  =>{
      console.log(error);
    },
    isOptimistic: true
  },
  postList
  );

  const handleDelete = (id) => {
    postDelete.execute(id);
  };

  // const handleDelete = (id) => {
  //   const rollBackState = postList.data;
  //   {
  //     postList.setData((prev) => {
  //       prev.filter((item) => item.id !== id);
  //     });
  //   }
  //   setStatus("mutating");
  //   postsService
  //     .remove(id)
  //     .then(() => {})
  //     .catch(() => {
  //       postList.setData(rollBackState);
  //       console.log(error);
  //       //hata
  //     })
  //     .finally(() => {
  //       setStatus("idle");
  //     });
  //   console.log(id);
  // };

  return (
    <>
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
      {route === "coffee" && (
        <button onClick={() => setRoute("posts")}> Show Posts</button>
      )}
      {route === "posts" && (
        <button onClick={() => setRoute("coffee")}>
          {" "}
          Show Coffee {postDelete.isMutating ? "siliniyor" : ""}
        </button>
      )}
      {(coffeeList.isLoading || postList.isLoading) && "Loading..."}
      {route === "coffee" &&
        coffeeList.isIdle &&
        coffeeList.data?.map((item) => {
          return (
            <Coffee
              key={item.id}
              id={item.id}
              title={item.title}
              description={item.description}
              ingredient={item.ingredients}
              image={item.image}
            />
          );
        })}

      {route === "posts" &&
        postList.isIdle &&
        postList.data.map((item) => (
          <Post
            key={item.id}
            onDelete={() => handleDelete(item.id)}
            id={item.id}
            title={item.title}
            body={item.body}
            userId={item.userId}
          />
        ))}
    </>
  );
}

export default App;
