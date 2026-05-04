export interface ChartStatusDto {
    status: string;
    count: number;
}

export interface DeptDetailDto {
    role: string;
    status: string;
    count: number;
}

export interface DeptChartDto {
    deptName: string;
    total: number;
    details: DeptDetailDto[];
}