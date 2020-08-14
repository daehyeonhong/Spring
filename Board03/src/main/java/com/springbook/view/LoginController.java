package com.springbook.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;

@Controller /* Controller */
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET) /* HandlerMapping */
	public String loginView(@ModelAttribute("user") UserVO vo) {/* Model.addAttribute("user", vo) */
		System.out.println("==> 로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test1234");
		return "login.jsp";
	}

}