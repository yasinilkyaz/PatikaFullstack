import React from 'react'

const Post = ({
    id,title,body,userId, onDelete
}) => {
  return (
    <div className='post-item'>
        <button onClick={onDelete}>Delete</button>
        
        <div className="post-row">
            <span className='label'>UserID</span>
            <span className='value '>{userId}</span>
        </div>
        <div className="post-row">
            <span className='label'>Title</span>
            <span className='value '>{title}</span>
        </div>
        <div className="post-row">
            <span className='label'>Body</span>
            <span className='value '>{body}</span>
        </div>
        
    </div>
  )
}

export default Post