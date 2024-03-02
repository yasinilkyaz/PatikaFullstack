import { useState, useEffect } from 'react';
export const useAsyncState = (
    initialState,fetcher,config
)=>{
    const [data, setData] = useState(initialState);
    const [status, setStatus] = useState("idle");

    useEffect(() => {
       
        setStatus("Loading");
        fetcher()
        .then((res) => {
          const mappedData = config?.mapper?.(res) || res;
            config?.onSuccess?.(res);
          setData(mappedData);
        })
        .catch((error)=>{
          config?.onError?.(error);
        })
        .finally( ()=>{
            config?.onFinally?.();
          setStatus("idle");
        });
      }, [fetcher.toString()]);

      return{data,setData,status,isLoading:status==="Loading",isIdle: status==="idle"}
}