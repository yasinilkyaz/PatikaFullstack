import React from 'react'
import { useNavigate } from 'react-router-dom'

const Main = ({children}) => {
    const navigate=useNavigate();
  return (
    <div>
        <div className="navigation">
            <button onClick={()=>navigate("/coffee")}>Coffees</button>
            <button onClick={()=>navigate("/posts")}>Posts</button>
            <button onClick={()=>navigate("/add-post")}>Add Post</button>
        </div>
        <div className="content">
            {children}
        </div>
    </div>
  )
}

export default Main