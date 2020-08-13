package com.springbook.biz.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.springbook.biz.BoardVO;
import com.springbook.biz.view.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==> 글 목록 검색 처리");

		/* DB연동 처리 */
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		/* 검색 결과 세션에 저장하고 목록 화면 리턴 */
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList");
		return mav;
	}

}