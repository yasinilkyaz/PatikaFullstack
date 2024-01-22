// let ve const ile değişken tanımlama

// var ile değişken tanımlama

// var serverName = "kodluyoruz patika+";
// console.log(serverName);

// let ile boş tanımlama

let serverName;
console.log(serverName);

// let ile bilgi atama

serverName = "kodluyoruz patika+";
console.log(serverName);

// let ile değişkene bilgi atarak tanımlama
let password = "<PASSWORD>";
console.log(password);

// değiken ataması yapmadan önce kullanmaya çalışmak
// console.log(fullName); Hatalı kullanım olacaktır.
let fullName = "<NAME>";

//let ile tanımlanan değişkenin değişmesi
fullName = "değişti";
console.log(fullName);

// birleştirme veya ekleme işlemi
fullName = fullName + " " + "Kodluyoruz";
console.log(fullName+" " + "patika+");

let yeniDegisken = "Yasin";
yeniDegisken += " ilkyaz";
console.log(yeniDegisken);

// const ile değişkeni boş tanımlamaya çalışmak
// const serverPassword; içi boş tanımlanamaz


// const ile değişken tanımlama
const SERVER_PASSWORD = "<PASSWORD>";
// SERVER_PASSWORD = "<PASSWORD>"; sonradan değiştirme yapılamaz
console.log(SERVER_PASSWORD); 