import React from "react";
import Main from "../layouts/Main";
import { teamMembers } from '../data'
import { useNavigate,Link } from "react-router-dom";
const About = () => {
    const navigate=useNavigate()
  return (
    <Main>
      <div>About</div>
      {
      teamMembers.map(member=>{
      return (<Link to={`/team/${member.id}`} style={{padding:'20px', background:"black",borderRadius:'10px',color:'white',margin:"10px"}}>
        {member.name}
        </Link>);

      })}
    </Main>
  );
};

export default About;
