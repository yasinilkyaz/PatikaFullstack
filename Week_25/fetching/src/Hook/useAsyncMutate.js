import { useState } from "react";
export const useAsyncMutate = (mutationFn, config, asyncState) => {
    const [status, setStatus] = useState("idle");

    const execute = (...args)=>{
        const rollBackState = asyncState.data;
        setStatus("mutating")

        if (config?.isOptimistic) {
            config?.onUpdate?.(...args)
            
        }

        mutationFn(...args)
        .then(()=>{
            if (!config?.isOptimistic) {
                config?.onUpdate?.(...args)
                
            }
            config?.onSuccess?.(res)
        })
        .catch((error)=>{
            config?.onError?.(error)
            if (config?.isOptimistic) {
                asyncState.setData(rollBackState)
                
                
            }
        })
        .finally(()=>{
            setStatus("idle");
            config.onFinally?.()
        })
    }


    return {
        execute,
        status,
        isMutating : status ==="mutating",
        isIdle : status ==="idle"
    }
};
