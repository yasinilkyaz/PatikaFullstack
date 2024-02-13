import { useState } from "react"
import Component from "./components"
import ClickComp from "./ClickComp"

function App() {

  const [selam, setSelam] = useState("Merhaba");

  

  return (
    <>
      <h1>Yasin ilkyaz
      <Component str={selam} />
      <ClickComp setSelam={setSelam} />
      
      </h1>
      
    </>
  )
}

export default App
