
// fetch("setting.json").then(response =>{
//     return response.json();
// }).then(responseJson =>{
//     console.log(responseJson);
//     console.log(responseJson.userName);
// })
fetch("https://jsonplaceholder.typicode.com/posts").then(response =>{
    return response.json();
}).then(responseJson =>{
    console.log(responseJson);
})