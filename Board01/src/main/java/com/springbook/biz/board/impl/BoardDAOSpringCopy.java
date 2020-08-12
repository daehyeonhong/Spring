package com.springbook.biz.board.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.springbook.biz.BoardVO;

/*@Repository*/
public class BoardDAOSpringCopy extends JdbcDaoSupport {

	@Autowired
	public void setSupportDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/* SQL명령어 */
	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content)VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM board),?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?,content=? WHERE seq=?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq=?";
	private final String BOARD_GET = "SELECT*FROM board WHERE seq=?";
	private final String BOARD_LIST = "SELECT*FROM board ORDER BY seq DESC";

	/* 글 등록 */
	public void insertBoard(BoardVO vo) {
		System.out.println("==> JDBC로 insertBoard()기능 처리");
		Object[] args = { vo.getTitle(), vo.getWriter(), vo.getContent() };
		getJdbcTemplate().update(BOARD_INSERT, args);
	}

	/* 글 목록 조회 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.printf("==> JDBC로 getBoardList()기능 처리\n");
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}

	/* 글 상세 조회 */
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard()기능 처리");
		Object[] args = { vo.getSeq() };
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	/* 글 수정 */
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC로 updateBoard()기능 처리");
		Object[] args = { vo.getTitle(), vo.getContent(), vo.getSeq() };
		getJdbcTemplate().update(BOARD_UPDATE, args);
	}

	/* 글 삭제 */
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard()기능 처리");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}

	/* 글 등록 */
	/*
	 * public void insertBoard(BoardVO vo) {
	 * System.out.println("==> JDBC로 insertBoard()기능 처리");
	 * getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(),
	 * vo.getContent()); }
	 */

	/* 글 목록 조회 */
	/*
	 * public List<BoardVO> getBoardList(BoardVO vo) {
	 * System.out.printf("==> JDBC로 getBoardList()기능 처리\n"); return
	 * getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper()); }
	 */

	/* 글 상세 조회 */
	/*
	 * public BoardVO getBoard(BoardVO vo) {
	 * System.out.println("==> JDBC로 getBoard()기능 처리"); Object[] args = {
	 * vo.getSeq() }; return getJdbcTemplate().queryForObject(BOARD_GET, args, new
	 * BoardRowMapper()); }
	 */

	/* 글 수정 */
	/*
	 * public void updateBoard(BoardVO vo) {
	 * System.out.println("==> JDBC로 updateBoard()기능 처리");
	 * getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(),
	 * vo.getSeq()); }
	 */

	/* 글 삭제 */
	/*
	 * public void deleteBoard(BoardVO vo) {
	 * System.out.println("==> JDBC로 deleteBoard()기능 처리");
	 * getJdbcTemplate().update(BOARD_DELETE, vo.getSeq()); }
	 */

}