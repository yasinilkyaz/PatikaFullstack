import React from 'react';
import { UseViewerContext } from "../../contexts/viewer-context.jsx";

const Item = ({ id, title, type, image }) => {
    const { changeFolder } = UseViewerContext();

    const handleDblClick = () => {
        if (type === "folder") {
            changeFolder(id);
        }
    };

    return (
        <div className='viewer-item' onDoubleClick={handleDblClick}>
            {title}
            <img src={image} alt={title} />
        </div>
    );
};

export default Item;