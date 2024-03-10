import React from 'react'
import { useAsyncState } from '../Hook/useAsyncState';
import { useAsyncMutate } from '../Hook/useAsyncMutate';
import * as postsService from "./../services/posts-service"

const Context = React.createContext(undefined)

export const QueryProvider = ({ children, value }) => {

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
        isOptimistic: true,
        asyncState:postList,
      },
      postList
      );

      const postAdd = useAsyncMutate({
        mutationFn: postsService.create,
        
        onUpdate: (payload) => {
          
          payload.userId = "1";
          postList.setData((prev) => [payload, ...prev]);
        },
        onError: (error) => {
          console.log(error);
        },
        isOptimistic: true,
        asyncState: postList,
      });

      



  return (
    <Context.Provider value={{postAdd,postList,postDelete}}>{children}</Context.Provider>
  )
}
 
export const useQuery = () => {
    const value = React.useContext(Context);
    if (!value) throw new Error("useQuery must be used within a QueryProvider");
    
  return value
}

