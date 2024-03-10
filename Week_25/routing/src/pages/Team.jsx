import React from 'react'
import Main from '../layouts/Main'
import { useParams } from 'react-router-dom'
import { teamMembers } from '../data'

const Team = () => {
    const id = useParams();
    const member = teamMembers.find((member) => member.id === Number(id.id));
    
  return (
    <Main>
    <h2>Team mamber: {member.name}</h2>
    <img src={member.img} alt="" />
    </Main>
  )
}

export default Team