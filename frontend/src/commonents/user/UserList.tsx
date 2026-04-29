import { useEffect, useState } from 'react'
import type { UserResponse } from '../../types/user'
import { getUsers } from '../../api/userApi'
import styles from './UserList.module.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import Table from 'react-bootstrap/Table';

export default function UserList() {
    const [users, setUsers] = useState<UserResponse[]>([])
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        getUsers()
            .then(data => setUsers(data))
            .finally(() => setLoading(false))
    }, [])

    if (loading) {
        return <div className={styles.loadingSpinner}>불러오는 중...</div>
    }

    if (users.length === 0) {
        return <div className={styles.emptyState}>등록된 유저가 없습니다.</div>
    }

    return (
        <div className={styles.container}>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>유저 아이디</th>
                    <th>역할</th>
                    <th>상태</th>
                    <th>가입일</th>
                    <th>만료일</th>
                </tr>
                </thead>
                <tbody>
                {users.map(user => (
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.userId}</td>
                        <td>
                                <span className={`${styles.badge} ${user.role === 'ADMIN' ? styles.badgeAdmin : styles.badgeUser}`}>
                                    {user.role}
                                </span>
                        </td>
                        <td>
                                <span className={user.useUser ? styles.statusActive : styles.statusInactive}>
                                    {user.useUser ? '활성' : '비활성'}
                                </span>
                        </td>
                        <td>{user.crDate ?? '-'}</td>
                        <td>{user.endDate ?? '-'}</td>
                    </tr>
                ))}
                </tbody>
            </Table>
        </div>
    )
}