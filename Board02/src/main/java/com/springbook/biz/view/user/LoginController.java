package com.springbook.biz.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		/* 1. 사용자 입력 정보 추출 */
		String id = request.getParameter("id"), password = request.getParameter("password");

		ModelAndView mav = new ModelAndView();
		UserVO user = null;
		mav.setViewName((user != null) ? "getBoardList.do" : "login");
		return mav;
	}

}