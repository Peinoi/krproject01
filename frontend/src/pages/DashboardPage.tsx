import UserList from '../commonents/user/UserList'
import styles from './DashboardPage.module.css'

export default function DashboardPage() {
    return (
        <div className={styles.simpleWrapper}>
            <div className={styles.container}>
                <h2 className={styles.title}>유저 목록</h2>
                <h3>PullRequest merge 테스트</h3>
                <h3>PullRequest Rebase 테스트</h3>
                <div className={styles.listCard}>
                    <UserList />
                </div>
            </div>
        </div>
    )
}