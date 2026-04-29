import UserList from '../commonents/user/UserList'
import styles from './DashboardPage.module.css'

export default function DashboardPage() {
    return (
        <div className={styles.simpleWrapper}>
                <h1 className={styles.title}>대쉬 보드</h1>
            <div className={styles.container}>
                <div className={styles.listCard}>
                    <h2>유저 목록</h2>
                    <UserList />
                </div>
                <div className={styles.listCard}>
                    <h2>게시판</h2>
                    <UserList />
                </div>
                <div className={styles.listCard}>
                    <h2>차트</h2>
                    <UserList />
                </div>
            </div>
        </div>
    )
}