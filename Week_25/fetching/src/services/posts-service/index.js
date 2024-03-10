import axios from "axios";


const instance = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com",
})

export const index =  () => instance.get("/posts")

export const create =  (payload) => instance.post("/posts",{payload}).then(function (response) {
  console.log(response);
})
.catch(function (error) {
  console.log(error);
});

export const remove =  (id) =>  instance.delete(`/posts/${id}`)

