import 'bootstrap/dist/css/bootstrap.min.css'
import Table from "react-bootstrap/Table";

export default function Board(){
    return (
        <div>
            <span>공지사항</span>
            <input />
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>생성일</th>
                        <th>작성자</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </Table>
        </div>

    )
}
