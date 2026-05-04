import { useEffect, useState } from 'react';
import { Radar, RadarChart, PolarGrid, PolarAngleAxis, PolarRadiusAxis, ResponsiveContainer, Legend, Tooltip } from 'recharts';
import { getDeptChart } from '../../api/chartApi';
import type { DeptChartDto } from '../../types/chart';

const STATUS_COLORS: Record<string, string> = {
    '근무중':   '#1D9E75',
    '반차':     '#BA7517',
    '휴가':     '#7F77DD',
    '육아휴직': '#D4537E',
};

export default function DeptRadarChart() {
    const [data, setData] = useState<DeptChartDto[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getDeptChart()
            .then(setData)
            .catch(() => setError('데이터를 불러오지 못했습니다.'))
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <p>로딩 중...</p>;
    if (error) return <p>{error}</p>;

    // { deptName, 근무중, 반차, 휴가, 육아휴직 } 형태로 변환
    const chartData = data.map((dept) => {
        const row: Record<string, string | number> = { dept: dept.deptName };
        dept.details.forEach((d) => {
            row[d.status] = (Number(row[d.status] ?? 0)) + d.count;
        });
        return row;
    });

    const statuses = ['근무중', '반차', '휴가', '육아휴직'];

    return (
        <ResponsiveContainer width="100%" height={320}>
            <RadarChart data={chartData}>
                <PolarGrid stroke="#e5e5e5" />
                <PolarAngleAxis dataKey="dept" tick={{ fontSize: 13, fontWeight: 500 }} />
                <PolarRadiusAxis angle={90} domain={[0, 4]} tickCount={5} tick={{ fontSize: 10 }} />
                {statuses.map((s) => (
                    <Radar
                        key={s}
                        name={s}
                        dataKey={s}
                        stroke={STATUS_COLORS[s]}
                        fill={STATUS_COLORS[s]}
                        fillOpacity={0.2}
                        dot={{ r: 4, fill: STATUS_COLORS[s] }}
                    />
                ))}
                <Legend />
                <Tooltip formatter={(value) => `${value}명`} />
            </RadarChart>
        </ResponsiveContainer>
    );
}