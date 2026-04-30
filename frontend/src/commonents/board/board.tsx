import 'bootstrap/dist/css/bootstrap.min.css';
import Table from "react-bootstrap/Table";
import { useEffect, useState } from "react";
import type { BoardResponse } from "../../types/board.ts";
import { getBoard } from "../../api/boardApi.ts";

const PAGE_SIZE = 3;

export default function Board() {
    // 1. 초기값을 세션 스토리지에서 읽어옴 (없으면 1페이지)
    const [currentPage, setCurrentPage] = useState<number>(() => {
        const savedPage = sessionStorage.getItem("boardPage");
        return savedPage ? parseInt(savedPage, 10) : 1;
    });

    const [boards, setBoards] = useState<BoardResponse[]>([]);
    const [totalPages, setTotalPages] = useState(0);

    useEffect(() => {
        // API 요청
        getBoard(currentPage, PAGE_SIZE)
            .then(data => {
                setBoards(data.content);
                setTotalPages(data.totalPages);
            })
            .catch(err => console.error("데이터 로딩 실패:", err));

        // 2. 페이지가 바뀔 때마다 세션 스토리지에 저장
        sessionStorage.setItem("boardPage", String(currentPage));
    }, [currentPage]);

    const goToPage = (page: number) => {
        setCurrentPage(page);
    };

    return (
        <div>
            <span>공지사항 (현재 페이지: {currentPage})</span>
            <div className="mb-2">
                <input /> <button>검색</button>
            </div>

            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>작성자</th>
                </tr>
                </thead>
                <tbody>
                {boards.length > 0 ? (
                    boards.map(board => (
                        <tr key={board.id}>
                            <td>{board.id}</td>
                            <td>{board.title}</td>
                            <td>{board.crDate}</td>
                            <td>{board.userId}</td>
                        </tr>
                    ))
                ) : (
                    <tr><td colSpan={4} className="text-center">데이터가 없습니다.</td></tr>
                )}
                </tbody>
            </Table>

            {/* 페이징 버튼 */}
            <div className="d-flex gap-1">
                <button
                    className="btn btn-sm btn-outline-secondary"
                    onClick={() => goToPage(currentPage - 1)}
                    disabled={currentPage === 1}
                >
                    이전
                </button>

                {Array.from({ length: totalPages }, (_, i) => i + 1).map(page => (
                    <button
                        key={page}
                        className={`btn btn-sm ${page === currentPage ? "btn-primary" : "btn-outline-primary"}`}
                        onClick={() => goToPage(page)}
                    >
                        {page}
                    </button>
                ))}

                <button
                    className="btn btn-sm btn-outline-secondary"
                    onClick={() => goToPage(currentPage + 1)}
                    disabled={currentPage === totalPages || totalPages === 0}
                >
                    다음
                </button>
            </div>
        </div>
    );
}