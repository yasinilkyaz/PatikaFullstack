type NotTsProps={
   person:{
      name:string,
      surname: string;
   }
}
const NotTs=(props:NotTsProps)=>{
 return(
    <div>This is not TS <br />
    {props.name}
    </div>
 )
};

export default NotTs;