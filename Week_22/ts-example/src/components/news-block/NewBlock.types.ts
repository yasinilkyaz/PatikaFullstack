import { colorMap } from './NewsBlock';

type ColorMapType = typeof colorMap;
export type Priority = keyof ColorMapType;
export type NewBlockProps ={
    priority:Priority;
    id:string;
    heading:string;
    date:string;
    img:string;
    summary:string;
};