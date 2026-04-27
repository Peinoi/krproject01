import axiosInstance from './axiosInstance' // 같은 폴더의 설정 불러오기
import type { UserResponse } from '../types/user'

export const getUsers = async (): Promise<UserResponse[]> => {
    const response = await axiosInstance.get('/users')
    return response.data
}