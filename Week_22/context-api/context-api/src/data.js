export const content = {
  id: "1",
  title: "root",
  type:"folder",
  subItems: [
    {   id:"2",
        title: "klasör 1" ,
        type:"folder",
        subItems:[
            {   id:"5",
                type:"folder",
                title:"alt klasör 1",
            },
            {
                id:"6",
                type:"image",
                title:"Image 1",
            },
            {
                id:"7",
                type:"image",
                title:"Image 2",
            },
        ]
    },
    {   id:"3",
        type:"folder",
        title: "klasör 2" ,
        subItems:[
            {
                id:"10",
                type:"image",
                title:"Image id 10",
            },
        ]
    },
    {   id:"4",
        type:"folder",
        title: "klasör 3"
    },
    
    {
        id:"8",
        type:"image",
        title:"root Image 1",
    },
    {
        id:"9",
        type:"image",
        title:"root Image 2",
    },
  ],
};
