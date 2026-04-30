
import type {BoardResponse} from "../types/board.ts";
import axiosInstance from "./axiosInstance.ts";

export const getBoard = async (page: number, size:number): Promise<BoardResponse[]> =>{
    const response = await  axiosInstance.get('/boards',{
        params : {page,size}
    })
    return response.data
}