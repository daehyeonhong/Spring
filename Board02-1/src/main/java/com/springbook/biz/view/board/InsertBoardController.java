package com.springbook.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.BoardVO;
import com.springbook.biz.view.board.impl.BoardDAO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==> 글 등록 처리");

		/* 1. 사용자 입력 정보 추출 */
		String title = request.getParameter("title"), writer = request.getParameter("writer"),
				content = request.getParameter("content");
		/* 2. DB 연동 처리 */
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		/* 3. 화면 네비게이션 */
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");

		return mav;
	}

}