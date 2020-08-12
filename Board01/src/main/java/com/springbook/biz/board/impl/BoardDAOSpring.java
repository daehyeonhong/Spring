package com.springbook.biz.board.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.springbook.biz.BoardVO;

@Repository
public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;/* Dependency Injection */

	/* SQL명령어 */
	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content)VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM board),?,?,?)",
			BOARD_UPDATE = "UPDATE board SET title=?,content=? WHERE seq=?",
			BOARD_DELETE = "DELETE FROM board WHERE seq=?", BOARD_GET = "SELECT*FROM board WHERE seq=?",
			BOARD_LIST = "SELECT*FROM board ORDER BY seq DESC";

	/* 글 등록 */
	public void insertBoard(BoardVO vo) {
		System.out.println("==> JDBC로 insertBoard()기능 처리");
		Object[] args = { vo.getTitle(), vo.getWriter(), vo.getContent() };
		jdbcTemplate.update(BOARD_INSERT, args);
	}

	/* 글 목록 조회 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.printf("==> JDBC로 getBoardList()기능 처리\n");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}

	/* 글 상세 조회 */
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard()기능 처리");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	/* 글 수정 */
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC로 updateBoard()기능 처리");
		Object[] args = { vo.getTitle(), vo.getContent(), vo.getSeq() };
		jdbcTemplate.update(BOARD_UPDATE, args);
	}

	/* 글 삭제 */
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard()기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

}