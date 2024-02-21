import React from 'react'
import { findItemById } from '../helper/utils'
import {UseViewerContext} from "../../contexts/viewer-context.jsx";


const Preview = () => {
    const {selectedId, list} = UseViewerContext();
    if(!selectedId) return null;
    const data = findItemById([list], selectedId);
    return (
        <div>
            {data.type==="folder" &&(
                <>Sub Item Count: {data.subItems?.length  || 0}</>
            )}

            {data.type==="image" && <img src={data.image} alt={data.title} />}
        </div>
    )

}

export default Preview