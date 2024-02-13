import React from 'react'

const Item = (id,title, type, image, changeFolder) => {
  const handleDblClick = () =>{
    if(type==="folder"){
      changeFolder(id)
  }

  console.log("id",id)
  return (
    <div className='viewer-item' onDoubleClick={handleDblClick}>
      {title}
    </div>
  );
}
}
export default Item