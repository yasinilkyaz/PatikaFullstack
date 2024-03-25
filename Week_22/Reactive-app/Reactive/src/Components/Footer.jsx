import React from "react";

const Footer = () => {
  return (
    <footer className="footer" id="footer">
      <div>
        <div>
          <img src="Resimler/logo.png" alt="" />
        </div>
        <div>
          <p style={{ color: 'white', fontWeight: 500 }}>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ex modi voluptatibus perferendis rerum optio nisi esse delectus officia eos explicabo. Fuga eum vel molestiae magni. Perferendis voluptatum culpa natus omnis.</p>
        </div>
        <div className="space-around">
          <div>
            <h3 style={{ color: 'white', fontWeight: 700, fontSize: '30px' }}>Information</h3>
            <ul style={{ lineHeight: '1.5rem' }}>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#">About Us</a></li>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#classes">Classes</a></li>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#review">Blog</a></li>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#contact">Contact</a></li>
            </ul>
          </div>
          <div>
            <h3 style={{ color: 'white', fontWeight: 700, fontSize: '30px' }}>Helpful Links</h3>
            <ul style={{ lineHeight: '1.5rem' }}>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#footer">Services</a></li>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#footer">Supports</a></li>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#footer">Terms & Condition</a></li>
              <li className="liste-ogesi" style={{ fontWeight: 400 }}><a href="#footer">Privacy Policy</a></li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;