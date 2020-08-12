package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springbook.biz.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(resultSet.getInt("seq"));
		board.setTitle(resultSet.getString("title"));
		board.setWriter(resultSet.getString("writer"));
		board.setContent(resultSet.getString("content"));
		board.setRegDate(resultSet.getDate("regDate"));
		board.setCnt(resultSet.getInt("cnt"));
		return board;
	}

}