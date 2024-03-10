import { useState } from "react";
export const useAsyncMutate = (mutationFn, config, asyncState) => {
    const [status, setStatus] = useState("idle");

    const execute = async (...args) => {
      setStatus("mutating");
    
      try {
        // Önceki durumdan gelen veriyi kaydet
        const rollBackState = asyncState?.data; // asyncState.data'ya erişmeden önce kontrol edin
        const res = await mutationFn(...args);
    
        if (config?.isOptimistic) {
          config?.onUpdate?.(...args);
        }
        config?.onSuccess?.(res);
      } catch (error) {
        config?.onError?.(error);
        if (config?.isOptimistic) {
          // Eğer bir hata olursa, eski durumu geri yükleyin
          asyncState.setData(rollBackState);
        }
      } finally {
        setStatus("idle");
        config?.onFinally?.(); // onFinally özelliğini kontrol etmek için ?. kullanın
      }
    };


    return {
        execute,
        status,
        isMutating : status ==="mutating",
        isIdle : status ==="idle"
    }
};
