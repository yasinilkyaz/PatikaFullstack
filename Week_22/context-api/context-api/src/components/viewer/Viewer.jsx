import React from 'react'
import { findItemById } from '../helper/utils'
import Item from '../item/Item';



const Viewer = ( {activeFolderId, list, changeFolder} ) => {
  const data = findItemById([list], activeFolderId);
  
  return (
    <div className='viewer'>
      {data?.subItem?.map((item) => {
        console.log(item.id);
        return 
          <Item
            id={item.id}
            changeFolder={changeFolder}
            title={item.title}
            type={item.type}
            image={item.image}
          />
        
      })}
    </div>
  )
};

export default Viewer