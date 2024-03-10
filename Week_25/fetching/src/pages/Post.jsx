import React from "react";
import Main from "../layouts/Main";
import PostItem from "./../components/Post/Post";
import { useQuery } from "../queries/useQuery";

const Post = () => {
  const { postList, postDelete } = useQuery();

  const handleDelete = (id) => {
    postDelete.execute(id);
  };
  return (
    <Main>
      {postList.isIdle &&
        postList.data.map((item) => (
          <PostItem
            key={item.id}
            onDelete={() => handleDelete(item.id)}
            id={item.id}
            title={item.title}
            body={item.body}
            userId={item.userId}
          />
        ))}
    </Main>
  );
};

export default Post;
