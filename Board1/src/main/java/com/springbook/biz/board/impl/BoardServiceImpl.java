package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springbook.biz.BoardVO;
import com.springbook.biz.board.BoardService;

@Component("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(BoardVO vo) {

	}

	@Override
	public void updateBoard(BoardVO vo) {

	}

	@Override
	public void deleteBoard(BoardVO vo) {

	}

	@Override
	public BoardVO getboBoardVO(BoardVO boardVO) {
		return null;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return null;
	}

}