import React from "react"
import InsideClick from "./InsideClick"

function ClickComp(prop){
    
    
    return (
        <div  >Click ME 
        <InsideClick setSelam={prop.setSelam} />
        </div>
        
    )
}

export default ClickComp