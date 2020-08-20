package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		 System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		 return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		 if(!vo.getUploadFile().isEmpty()) {
	 	    mybatis.update("BoardDAO.updateBoard",vo);
		 }else {
			 mybatis.update("BoardDAO.updateBoard2",vo);
		 }
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
		
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		updateBoardCnt(vo);
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public void updateBoardCnt(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoardCnt() 기능 처리");
		mybatis.update("BoardDAO.updateBoardCnt", vo);
	}
	

}
