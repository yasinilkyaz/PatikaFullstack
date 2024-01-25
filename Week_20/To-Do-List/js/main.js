let inputDOM = document.querySelector("#task");
let ulDOM = document.querySelector("#list");
let buttonDOm = document.querySelector("#liveToastBtn");
let itemsArray = localStorage.getItem('items') ? JSON.parse(localStorage.getItem('items')) : [];
const data = JSON.parse(localStorage.getItem('items'));
let errorToast = document.querySelector("#errorToast");

function showToast(message, type) {
    let toastDOM = document.querySelector("#liveToast");
    let toastBodyDOM = toastDOM.querySelector(".toast-body");

    toastDOM.classList.remove("success", "error");
    toastDOM.classList.add(type);
    toastBodyDOM.textContent = message;

    $(toastDOM).toast('show');
}

function newElement() {
    let inputValue = inputDOM.value.trim(); // Boşlukları kaldır

    if (inputValue === "") {
        showToast('Listeye boş ekleme yapamazsınız!', 'error');
        inputDOM.value = "";
        return;
    }

    let liDOM = document.createElement("li");
    liDOM.textContent = inputValue;

    let spanDOM = document.createElement("span");
    spanDOM.textContent = "×";
    spanDOM.classList.add("close");

    liDOM.appendChild(spanDOM);
    ulDOM.appendChild(liDOM);

    itemsArray.push(inputValue);
    localStorage.setItem('items', JSON.stringify(itemsArray));

    spanDOM.addEventListener('click', function () {
        liDOM.style.display = 'none';
    });

    showToast('Listeye eklendi.', 'success');
    inputDOM.value = "";
}

function showExistingTasks() {
    ulDOM.querySelectorAll('li').forEach(function (liDOM) {
        let spanDOM = document.createElement("span");
        spanDOM.textContent = "×";
        spanDOM.classList.add("close");

        liDOM.appendChild(spanDOM);

        spanDOM.addEventListener('click', function () {
            liDOM.style.display = 'none';
        });
    });
}

showExistingTasks();

ulDOM.addEventListener('click', function (event) {
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
