import React from "react";

const ContactSection = () => {
  return (
    <section className="purchase-bg classes-flex" id="contact">
      <div className="margi50px"></div>
      <div>
        <div className="relative bar-size">
          <p className="section-title margi50px">CONTACT US</p>
          <div className="bar"></div>
        </div>
      </div>
      <p className="section-content">
        Lorem Ipsum is not simply random text. It has roots in a piece of classical at <br />
        Hampden-Sydney College.
      </p>

      <div className="flex-only margi50px">
        <div className="sol-bolum">
          <div className="flex-contact">
            <div>
              <h5 style={{ fontWeight: 500, color: '#4E4E4E' }}>Mobile Number </h5>
              <p style={{ fontWeight: 500, color: '#4E4E4E' }}>+135 773 321 4442</p>
            </div>
            <div className="pl20px">
              <h5 style={{ fontWeight: 500, color: '#4E4E4E' }}>E-posta Adresi: </h5>
              <p style={{ fontWeight: 500, color: '#4E4E4E' }}>demo@demo.com</p>
            </div>
          </div>
          <div className="randevu">
            <h2>Make An Appointment</h2>
            <form>
              <input type="text" id="isim" name="isim" placeholder="Your Name" />
              <input type="email" id="eposta" name="eposta" placeholder="Your Email" />
              <textarea id="mesaj" name="mesaj" placeholder="Your Message"></textarea>
            </form>
          </div>
        </div>
        <div className="sag-bolum">
          <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2979.032583472481!2d-70.56179968455823!3d41.45442497925764!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89e4c7a9a5a0f0a9%3A0x6f0c0b0f3a5c6c4!2sDos%20Mas!5e0!3m2!1str!2str!4v1633527261360!5m2!1str!2str" width="500" height="450" style={{ border: 0 }} allowFullScreen="" loading="lazy"></iframe>
        </div>
      </div>
    </section>
  );
};

export default ContactSection;
