import React from "react";

const BMISection = () => {
  const calculateBMI = () => {
    var height = document.getElementById('height').value;
    var weight = document.getElementById('weight').value;
    
    if (isNaN(height) || isNaN(weight)) {
      alert('Lütfen geçerli bir sayı girin.');
      return;
    }
    
    var bmi = weight / ((height / 100) * (height / 100));
    var vkiScale = document.querySelector('.vki-scale');

    if (bmi < 18.5) {
      vkiScale.style.left = "15%";
    } else if (bmi >= 18.5 && bmi < 25) {
      vkiScale.style.left = "30%";
    } else if (bmi >= 25 && bmi < 30) {
      vkiScale.style.left = "48%";
    } else if (bmi >= 30 && bmi < 35) {
      vkiScale.style.left = "64%";
    } else {
      vkiScale.style.left = "80%";
    }
  };

  return (
    
      <div className="bmi US-flex vh-50">
        <div>
          <h2 style={{ fontWeight: 900, color: "darkblue", textAlign: "center" }}>BMI Calculator</h2>
          <br />
          <p style={{ fontWeight: 700 }}>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
          <br />
          <p style={{ fontWeight: 700 }}>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
          <br />
          <div className="input-container flex">
            <div>
              <input type="number" placeholder="Your Height" id="height" onInput={calculateBMI} /> <span className="margin10px">cm</span>
            </div>
            <div>
              <input type="number" placeholder="Your Weight" id="weight" onInput={calculateBMI} /> <span className="margin10px">kg</span>
            </div>
          </div>
        </div>
        <div>
          <div className="vki-img">
            <img src="Resimler/bmi-index.jpg" className="img" alt="" />
            <div className="vki-scale"></div>
          </div>
        </div>
      </div>
    
  );
};

export default BMISection;