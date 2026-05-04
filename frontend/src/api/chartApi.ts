import axiosInstance from './axiosInstance';
import type {ChartStatusDto, DeptChartDto} from '../types/chart'; // 경로 확인
// 경로 확인

export const getStatusChart = async (): Promise<ChartStatusDto[]> => {
    const response = await axiosInstance.get<ChartStatusDto[]>('/charts/status');
    return response.data;
};

export const getDeptChart = async (): Promise<DeptChartDto[]> => {
    const response = await axiosInstance.get<DeptChartDto[]>('/charts/dept');
    return response.data;
};