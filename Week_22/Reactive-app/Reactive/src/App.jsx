
import './App.css'
import Navbar from './Components/Navbar'
import HeroSection from './Pages/HeroSection'
import Classes from './Pages/Classes'
import BMISection from './Components/BMISection'
import TrainerSection from './Pages/TrainerSection'
import PurchaseSection from './Pages/PurchaseSection'
import ReviewSection from './Pages/ReviewSection'
import ContactSection from './Pages/ContactSection'
import Footer from './Components/Footer'

function App() {
  

  return (
    <>
     <Navbar />
     <HeroSection />
     <Classes />
     <BMISection />
     <TrainerSection />
     <PurchaseSection/>
     <ReviewSection/>
     <ContactSection />
     <Footer/>
    </>
  )
}

export default App
