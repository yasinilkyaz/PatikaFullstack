import { useState } from 'react'

import './App.css'
import Person from './components/Person'
import { people } from './data'

function App() {

  return (
    <>
    {people.map((person)=>{
      return(
        <Person 
        key={person.name} 
        avatar={person.avatar} 
        name={person.name} 
        phoneNumber={person.phoneNumber} 
        address={person.address} />
      )
    })}
    
    </>
  )
}

export default App
