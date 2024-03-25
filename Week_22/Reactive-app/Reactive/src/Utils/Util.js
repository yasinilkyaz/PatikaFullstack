window.addEventListener('scroll', function() {
    var header = document.querySelector('header');
    var scrollPosition = window.scrollY;
    var windowHeight = window.innerHeight;

    
    if ((scrollPosition ) >= windowHeight*0.8) {
        header.style.backgroundColor = '#355592';
    } else {
        header.style.backgroundColor = 'transparent'; 
    }
    header.classList.toggle('scrolled', window.scrollY > 0);
    
});


const buttons = document.querySelectorAll('.button','.button-clicked');


buttons.forEach(button => {
    button.addEventListener('click', function() {
        
        buttons.forEach(btn => {
            btn.classList.remove('button-clicked');
            btn.classList.add('button');
        });

        
        this.classList.remove('button');
        this.classList.add('button-clicked');
    });
});

const content = document.getElementById('content');


buttons.forEach(button => {
    button.addEventListener('click', function() {
        
        const buttonId = this.id;

        
        switch (buttonId) {
            case 'Yoga':
                content.innerHTML = `
                    <div class="m-3">
                        <h2 style="font-weight: 700;">Why are your Yoga?</h2><br>
                        <p style="font-weight: 700;">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit cumque quia illum neque odit, similique nobis at eligendi nihil rerum deserunt rem voluptatum autem numquam sit nesciunt ab deleniti officiis?</p><br>
                        <h2 style="font-weight: 700;">When comes Yoga Your Time.</h2><br>
                        <p style="font-weight: 700;">Saturday-Sunday: 8:00am - 10:00am</p><br>
                        <p style="font-weight: 700;">Monday-Tuesday: 10:00am - 12:00pm</p><br>
                        <p style="font-weight: 700;">Wednesday-Friday: 3:00pm - 6:00pm</p>  
                    </div>
                    <div class="classes-flex m-3">
                        <img src="Resimler/yoga.jpg" class="img" alt="">
                    </div>
                `;
                break;
            case 'Group':
                content.innerHTML = `
                    <div class="m-3">
                        <h2 style="font-weight: 700;">Why are your Group?</h2><br>
                        <p style="font-weight: 700;">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit cumque quia illum neque odit, similique nobis at eligendi nihil rerum deserunt rem voluptatum autem numquam sit nesciunt ab deleniti officiis?</p><br>
                        <h2 style="font-weight: 700;">When comes Group Your Time.</h2><br>
                        <p style="font-weight: 700;">Saturday-Sunday: 8:00am - 10:00am</p><br>
                        <p style="font-weight: 700;">Monday-Tuesday: 10:00am - 12:00pm</p><br>
                        <p style="font-weight: 700;">Wednesday-Friday: 3:00pm - 6:00pm</p>  
                    </div>
                    <div class="classes-flex m-3">
                        <img src="Resimler/group.webp" class="img" alt="">
                    </div>
                `;
                break;
            case 'Solo':
                content.innerHTML = `
                    <div class="m-3">
                        <h2 style="font-weight: 700;">Why are your Solo?</h2><br>
                        <p style="font-weight: 700;">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit cumque quia illum neque odit, similique nobis at eligendi nihil rerum deserunt rem voluptatum autem numquam sit nesciunt ab deleniti officiis?</p><br>
                        <h2 style="font-weight: 700;">When comes Solo Your Time.</h2><br>
                        <p style="font-weight: 700;">Saturday-Sunday: 8:00am - 10:00am</p><br>
                        <p style="font-weight: 700;">Monday-Tuesday: 10:00am - 12:00pm</p><br>
                        <p style="font-weight: 700;">Wednesday-Friday: 3:00pm - 6:00pm</p>  
                    </div>
                    <div class="classes-flex m-3">
                        <img src="Resimler/solo.jpg" class="img" alt="">
                    </div>
                `;
                break;
            case 'Stretching':
                content.innerHTML = `
                    <div class="m-3">
                        <h2 style="font-weight: 700;">Why are your Stretching?</h2><br>
                        <p style="font-weight: 700;">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit cumque quia illum neque odit, similique nobis at eligendi nihil rerum deserunt rem voluptatum autem numquam sit nesciunt ab deleniti officiis?</p><br>
                        <h2 style="font-weight: 700;">When comes Stretching Your Time.</h2><br>
                        <p style="font-weight: 700;">Saturday-Sunday: 8:00am - 10:00am</p><br>
                        <p style="font-weight: 700;">Monday-Tuesday: 10:00am - 12:00pm</p><br>
                        <p style="font-weight: 700;">Wednesday-Friday: 3:00pm - 6:00pm</p>  
                    </div>
                    <div class="classes-flex m-3">
                        <img src="Resimler/stret.webp" class="img" alt="">
                    </div>
                `;
                break;
            default:
                break;
        }
    });
});


function calculateBMI() {
   
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
    
}

