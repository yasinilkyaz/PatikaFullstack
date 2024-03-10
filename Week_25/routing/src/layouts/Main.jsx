import React from "react";
import { useNavigate } from "react-router-dom";

const Main = ({children}) => {
  const navigate = useNavigate();

  return (
    <div className="layout-root">
      <div className="nav">
        <button onClick={() => navigate("/home")}>Home</button>
        <button onClick={() => navigate("/about")}>About</button>
        <button onClick={() => navigate("/contact")}>Contact</button>
      </div>
      <div className="content"> {children} </div>
    </div>
  );
};

export default Main;
