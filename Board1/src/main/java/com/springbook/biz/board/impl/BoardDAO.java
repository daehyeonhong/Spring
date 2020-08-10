package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Component;
import com.springbook.biz.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Component("boardDAO")
public class BoardDAO {
	/* JDBC관련 변수 */
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/* SQL명령어 */
	private final String BOARD_INSERT = "INSERT INTO BOARD(seq,title,writer,content)VALUES((SELECT NVL(MAX(SEQ),0)+1FROM board))";
	private final String BOARD_UPDATE = "UPDATE board SET title=?,content=? WHERE seq=?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq=?";
	private final String BOARD_GET = "SELECT*FROM board WHERE seq=?";
	private final String BOARD_LIST = "SELECT*FROM board ORDER BY seq DESC";

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
}