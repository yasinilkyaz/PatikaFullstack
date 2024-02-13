import React, { FC } from'react';
import { NewBlockProps } from './NewBlock.types';


export const colorMap = {
    success: 'green',
    warning: 'yellow',
    danger:'red',
    plain: 'blue',
}
const NewBlock: FC<NewBlockProps> =(props) => {
    return(
        <div
        style={{
            backgroundColor: colorMap[props.priority],
        }}
        >
            <h1>
                {props.heading}
            </h1>
            <img src={props.img} alt="" />
            <p>{props.summary}</p>
        </div>
    )
}

export default NewBlock;

