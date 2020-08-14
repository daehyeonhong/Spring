package com.springbook.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller /* Controller */
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET) /* HandlerMapping */
	public String loginView(@ModelAttribute("user") UserVO vo) {/* Model.addAttribute("user", vo) */
		System.out.println("==> 로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test1234");
		return "login.jsp";
	}

	/* ID, Password 값이 설정된 UserVO가 넘어 옴 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("useName", user.getName());
			System.out.printf("userName: %s", user.getName());
			return "getBoardList.do";
		}
		return "login.jsp";
	}

}