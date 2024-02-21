import React from 'react'
import { findItemById } from '../helper/utils'
import Item from '../item/Item.jsx';
import Preview from '../preview/Preview';
import { UseViewerContext } from "../../contexts/viewer-context.jsx";

const Viewer = () => {
    const { list, handleBack, activeFolderId, selectedId, select, backFolderId } = UseViewerContext();
    const data = findItemById(list, activeFolderId);

    return (
        <>
            {backFolderId && <button onClick={handleBack}>Back</button>}
            <div className='viewer'>
                {data?.subItems?.length > 0 ? (
                    data.subItems.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            type={item.type}
                            image={item.image}
                        />
                    ))
                ) : (
                    <p>No items to display</p>
                )}
                <div>
                    <Preview />
                </div>
            </div>
        </>
    )
};

export default Viewer;