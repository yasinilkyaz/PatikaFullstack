import React, { useState } from "react";
import Main from "../layouts/Main";
import { useQuery } from "../queries/useQuery";
import { useNavigate } from "react-router-dom";

const AddPost = () => {
  const { postAdd } = useQuery();
  const navigate = useNavigate();
  const [formValues, setFormValues] = useState({
    title: "",
    body: "",
    userId : 1
  });

  const handleAdd = (payload) => {
    // postAdd.execute(payload); // Önceki hali
    postAdd.execute(payload).then(() => {
      navigate("/posts");
    });
  };

  const handleChange = (e) => {
    setFormValues((prev)=>({...prev,[e.target.name]:e.target.value}));
    
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(formValues);
    await handleAdd(formValues);
  };

  return (
    <Main>
      <h1>add post</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <input
            name="title"
            value={formValues.title}
            onChange={handleChange}
          />
        </div>
        <div>
          <textarea
            name="body"
            value={formValues.body}
            onChange={handleChange}
          />
        </div>
        <div>
          <button type= "submit">Save</button>
        </div>
      </form>
    </Main>
  );
};

export default AddPost;
