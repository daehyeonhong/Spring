package com.springbook.biz.view.board.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.springbook.biz.BoardVO;
import com.springbook.biz.common.JDBCUtil;

public class BoardDAO {
	/* JDBC관련 변수 */
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/* SQL명령어 */
	private final String
			BOARD_INSERT = "INSERT INTO board(seq,title,writer,content)VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM board),?,?,?)",
			BOARD_UPDATE = "UPDATE board SET title=?,content=? WHERE seq=?",
			BOARD_DELETE = "DELETE FROM board WHERE seq=?",
			BOARD_GET = "SELECT*FROM board WHERE seq=?",
			BOARD_LIST = "SELECT*FROM board ORDER BY seq DESC",
			BOARD_CNT = "UPDATE BOARD SET cnt=NVL(cnt,0)+1 WHERE seq=?";

	/* 글 입력 */
	public void insertBoard(BoardVO vo) {
		System.out.println("==> JDBC로 insertBoard()기능 처리");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_INSERT);
			preparedStatement.setString(1, vo.getTitle());
			preparedStatement.setString(2, vo.getWriter());
			preparedStatement.setString(3, vo.getContent());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}

	/* 글 목록 조회 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.printf("==> JDBC로 getBoardList()기능 처리\n");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_LIST);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BoardVO board = new BoardVO();
				int seq = resultSet.getInt("seq"), cnt = resultSet.getInt("cnt");
				String title = resultSet.getString("title"), writer = resultSet.getString("writer"),
						content = resultSet.getString("content");
				Date regDate = resultSet.getDate("regDate");
				board.setSeq(seq);
				board.setTitle(title);
				board.setWriter(writer);
				board.setContent(content);
				board.setRegDate(regDate);
				board.setCnt(cnt);

				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}
		return boardList;
	}

	/* 게시글 조회 */
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard()기능 처리");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BoardVO board = new BoardVO();
		/* 조회수 증가 메소드 호출 */
		updateBoardCnt(vo);
		try {
			int seq = vo.getSeq();
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_GET);
			preparedStatement.setInt(1, seq);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				board.setSeq(seq);
				board.setTitle(resultSet.getString("title"));
				board.setWriter(resultSet.getString("writer"));
				board.setContent(resultSet.getString("content"));
				board.setRegDate(resultSet.getDate("regDate"));
				board.setCnt(resultSet.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}
		return board;
	}

	/* 게시글 수정 */
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC로 updateBoard()기능 처리");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_UPDATE);
			preparedStatement.setString(1, vo.getTitle());
			preparedStatement.setString(2, vo.getContent());
			preparedStatement.setInt(3, vo.getSeq());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}

	/* 게시글 삭제 */
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard()기능 처리");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_DELETE);
			preparedStatement.setInt(1, vo.getSeq());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}

	/* 조회수 증가 */
	public void updateBoardCnt(BoardVO vo) {
		System.out.println("==> JDBC로 updateBoardCnt()기능 처리");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_CNT);
			preparedStatement.setInt(1, vo.getSeq());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}
}