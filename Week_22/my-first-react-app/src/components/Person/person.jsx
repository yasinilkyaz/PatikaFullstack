
const Person = (props) => {
  return (
    <div>
        
      <h1>{props.name}</h1>
      <h1>{props.phoneNumber}</h1>
      <h1>{props.address}</h1>
    </div>
  );
};

export default Person;
