let submitButton = document.getElementById("submitButton");
let resetButton = document.getElementById("resetButton");
let myTable = document.getElementsByClassName("myTable");
let ul = document.createElement("ul");
ul.setAttribute("id", "theList");
myTable.appendChild(ul);


function submitFunction() {
    let inputVal = document.getElementById("inputArea").value;
    alert(inputVal);
   
}