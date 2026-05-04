
import type {BoardResponse} from "../types/board.ts";
import axiosInstance from "./axiosInstance.ts";

export const getBoard = (page: number, size: number, keyword: string) => {
    return axiosInstance.get("/boards", {
        params: {
            page,
            size,
            keyword
        }
    }).then(res => res.data);
};