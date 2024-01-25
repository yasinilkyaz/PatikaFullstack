let inputDOM = document.querySelector("#task");
let ulDOM = document.querySelector("#list");
let buttonDOm = document.querySelector("#liveToastBtn");
let itemsArray = localStorage.getItem('items') ? JSON.parse(localStorage.getItem('items')) : [];
const data = JSON.parse(localStorage.getItem('items'));

function newElement() {
    let inputValue = inputDOM.value;

    
    let liDOM = document.createElement("li");
    liDOM.textContent = inputValue;

    
    let spanDOM = document.createElement("span");
    spanDOM.textContent = "×"; 
    spanDOM.classList.add("close");

    
    liDOM.appendChild(spanDOM);

    
    ulDOM.appendChild(liDOM);

    
    localStorage.clear();
    itemsArray.push(inputValue);
    localStorage.setItem('items', JSON.stringify(itemsArray));

    
    spanDOM.addEventListener('click', function() {
        liDOM.style.display = 'none';
    });
}

function showExistingTasks() {
    
        ulDOM.querySelectorAll('li').forEach(function (liDOM) {
        let spanDOM = document.createElement("span");
        spanDOM.textContent = "×";
        spanDOM.classList.add("close");

        liDOM.appendChild(spanDOM);

        spanDOM.addEventListener('click', function() {
            liDOM.style.display = 'none';
        });
    });
}

showExistingTasks();


ulDOM.addEventListener('click', function(event) {
    const clickedItem = event.target;

    
    if (clickedItem.tagName === 'LI') {
        
        const isSelected = clickedItem.classList.contains("checked");

        
        if (isSelected) {
            clickedItem.classList.remove("checked");
        } else {
            clickedItem.classList.add("checked");
        }
    }
});