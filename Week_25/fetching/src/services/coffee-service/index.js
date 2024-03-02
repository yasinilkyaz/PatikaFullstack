const baseUrl = "https://api.sampleapis.com/coffee";

export const getHotCoffees = async () => {
  try {
    const res = await fetch(`${baseUrl}/hot`);
    const json = await res.json();
    if (json.error) {
      throw new Error(json.message);
    }
    return json;
  } catch (error) {
    throw error;
  }
};
export const getIcedCoffees = async () => {
  try {
    const res = await fetch(`${baseUrl}/iced`);
    const json = await res.json();
    
    if (json.error) {
      throw new Error(json.message);
    }

    return json;
  } catch (error) {
   throw error;
  }
};
