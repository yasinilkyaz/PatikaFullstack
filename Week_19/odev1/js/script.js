istek();

function istek()
{
    let name = prompt("İsminizi giriniz");
    let namePlace= document.querySelector("#myName");
    namePlace.innerHTML = name;
}
