import { useState, useEffect } from 'react';
import logo from '/Resimler/logo.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBars } from '@fortawesome/free-solid-svg-icons';

function Navbar() {
  const [menuOpen, setMenuOpen] = useState(false);

  const toggleMenu = () => {
    setMenuOpen(!menuOpen);
  };

  useEffect(() => {
    window.addEventListener('scroll', handleScroll);
    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  const handleScroll = () => {
    var header = document.querySelector('header');
    var scrollPosition = window.scrollY;
    var windowHeight = window.innerHeight;

    if (scrollPosition >= windowHeight * 0.8) {
      header.style.backgroundColor = '#355592';
    } else {
      header.style.backgroundColor = 'transparent';
    }
    header.classList.toggle('scrolled', window.scrollY > 0);
  };

  return (
    <header>
      <nav className="">
        <div className="flexHeader">
          <div>
            <img src={logo} id="logo" alt="Logo" />
          </div>
          <label htmlFor="menu-btn" className="menu-icon" onClick={toggleMenu}>
            <FontAwesomeIcon icon={faBars} />
          </label>
          <input type="checkbox" className="menu-btn" id="menu-btn" checked={menuOpen} onChange={toggleMenu} />
          <navbar className={menuOpen ? 'menu open' : 'menu'}>
            <ul>
              <li><a href="#">Home</a></li>
              <li><a href="#classes">Classes</a></li>
              <li><a href="#trainer">Trainer</a></li>
              <li><a href="#review">Review</a></li>
              <li><a href="#contact">Contact</a></li>
              <li><a href="#"><span id="join-us">JOIN US</span></a></li>
            </ul>
          </navbar>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
