import React from "react";

function InsideClick(props) {
    const handeleClick = () => {
        props.setSelam("Selam değişti");
        }
    return (
        <div onClick={handeleClick} >Asıl İnside Click</div>
    )
}

export default InsideClick; 