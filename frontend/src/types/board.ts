export interface BoardResponse{
    id: number
    title : string
    // content : string
    crDate  : string
    userId : string
}
export interface BoardPageResponse{
    // content: BoardResponse[]
    totalPages : number
    totalElements: number
}