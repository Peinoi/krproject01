export interface UserResponse {
    id: number
    userId: string
    useUser: boolean
    crDate: string
    endDate: string | null
    role: string
    deptName: string
}

export interface UserRequest {
    userId: string
    password: string
    role?: string
}