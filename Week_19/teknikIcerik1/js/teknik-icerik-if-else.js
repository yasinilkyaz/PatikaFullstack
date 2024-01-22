var ogrVizeNot = prompt("vize notu giriniz"); // Bu kod satırını değiştiriniz. 

if(ogrVizeNot>100 && ogrVizeNot<0){
    console.log("Lütfen 0-100 arası bir değer giriniz.");
    throw new Error("Lütfen 0-100 arası bir değer giriniz.");
}
console.log("vize notunuz: " + ogrVizeNot);


var ogrFinalNot = prompt("final notu giriniz"); // Bu kod satırını değiştiriniz. 
if(ogrFinalNot<0 && ogrFinalNot>100){
    console.log("Lütfen 0-100 arası bir değer giriniz.");
}
console.log("final notunuz: " + ogrFinalNot);

var ogrOrtalama = (ogrVizeNot * 0.3) + (ogrFinalNot * 0.7);

if(ogrOrtalama >= 0 && ogrOrtalama <= 30) {
  console.log("Not ortalamanız: " +ogrOrtalama + " KALDINIZ(FF).");
}

else if(ogrOrtalama >= 31 && ogrOrtalama <= 49) {
  console.log("Not ortalamnız: " +ogrOrtalama + " DC - KOŞULLU ");
}

else if(ogrOrtalama >= 50 && ogrOrtalama <= 84) {
  console.log("Not ortalamnız: " +ogrOrtalama + " CC - GEÇTİNİZ ");
}

else if(ogrOrtalama >= 85 && ogrOrtalama <= 100) {
  console.log("Not ortalamnız: " +ogrOrtalama + " AA - GEÇTİNİZ ");
}
