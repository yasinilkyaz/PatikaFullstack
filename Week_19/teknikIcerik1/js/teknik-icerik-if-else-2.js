//Kod satırını buraya ekleyiniz.

// var weight = prompt("Kilonuzu giriniz");
// var height = prompt("Boyunuzu giriniz");
// function vkiHesapla(weight, height) {
//     var vki=weight/(height*height); //Bu kod satırını değiştiriniz
//   if(vki<18.5) return alert(`Vücut kitle indeksiniz: ${vki}, değerleriniz düşüktür`);
//   if(vki>= 18.5 && vki <= 24.9) return alert(`Vücut kitle indeksiniz: ${vki}, normal değerdesiniz`);
//   if(vki>= 25.0 && vki <= 29.9) return alert(`Vücut kitle indeksiniz: ${vki}, kilolusunuz`);
//   if(vki>= 30) return alert(`Vücut kitle indeksiniz: ${vki}, aşırı kilolusunuz`);
//   return alert("Girdiğiniz değerleri kontrol ediniz");
//   };
//   vkiHesapla(weight, height);

function factorial(n) {
  let number = n;
  let result = 1;

  while (number != 0) {
    result = result * number;
    number--;
  }

  return result;
}

function carp(n1,n2){
  return n1*n2;
}