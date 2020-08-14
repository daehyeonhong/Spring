package com.springbook.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.springbook.biz.BoardVO;
import com.springbook.biz.view.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==> 글 수정 처리");

		/* 1.사용자 입력 정보 추출 */
		String title = request.getParameter("title"), content = request.getParameter("content"),
				seq = request.getParameter("seq");

		/* 2. DB 연동 처리 */
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));

		System.out.printf("Title: %s\nContent: %s\n%Seq: s\n", vo.getTitle(), vo.getContent(), vo.getSeq());

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);

		/* 3. 화면 네비게이션 */
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");

		return mav;
	}

}