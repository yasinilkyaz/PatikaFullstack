import { useState ,useReducer } from "react";
import "./App.css";
import { NewBlockProps } from "./components/news-block/NewBlock.types";

import NewsBlock from "./components/news-block/NewsBlock";

function App() {
  // const [haberler, setHaber] = useState<NewBlockProps[]>(
  //   [{
  //     id: "123",
  //     heading: "Yazılım öğrenme fırsatı",
  //     summary: "summary Yazılım öğrenme fırsatı",
  //     img: "https://picsum.photos/200",
  //     priority: "success",
  //     date: "01.01.2024",
  //   }],
  // );

  const initialState: NewBlockProps[] =  [
    {
       id: "123",
       heading: "Yazılım öğrenme fırsatı",
       summary: "summary Yazılım öğrenme fırsatı",
       img: "https://picsum.photos/200",
       priority: "success",
       date: "01.01.2024",
       },
      ]
      type AddAction={
        type:"add",
        payload:NewBlockProps
      }
      type RemoveAction={
        type:"remove",
        payload:string
      }
      type ReducerAction = AddAction | RemoveAction;
      type Reducer = (state: NewBlockProps[], action: ReducerAction) => NewBlockProps[];

      const reducer:Reducer =(state, action) =>{
        switch (action.type) {
          case "add":
            return [ action.payload, ...state ];
            case "remove":
              return state.filter((haber) => haber.id!== action.payload);
          default:
            return state;
        }
      }
  const [haberler,dispatchHaberler] = useReducer(reducer, 
   initialState);

      const handleAddNew = () => {
        dispatchHaberler(
          {type:"add",
        payload:{
          id: "123",
          heading: "Yazılım öğrenme fırsatı",
          summary: "summary Yazılım öğrenme fırsatı",
          img: "https://picsum.photos/200",
          priority: "danger",
          date: "01.01.2024",
        },
      });
      };

      const handleRemove = () => {
        dispatchHaberler({type:"remove",payload:"123"});
      }

  return (
    <>
    <button onClick={handleAddNew}>Add New</button>
    <div>
      {haberler.map((haber) => (
        <NewsBlock
          priority={haber.priority}
          id={haber.id}
          heading={haber.heading}
          date={haber.date}
          img={haber.img}
          summary={haber.summary}
        />
      ))}
    </div>
    </>
  );
}

export default App;
