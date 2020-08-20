package com.springbook.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller//콘트롤러
public class LoginController{
	//HandlerMapping
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
   public String loginView(HttpServletRequest request) {//Model.addAttribute("user", vo)
	   System.out.println("로그인 화면으로 이동....");
	   UserVO vo=new UserVO();
	   
	   //vo.setId("kim");
	   //vo.setPassword("kim1234");
	   //vo.setName("홍길동");
	  // vo.setRole("admin");
	   
	   HttpSession session=request.getSession();
	   //Model.addAttribute("user", vo);
	  //request.setAttribute("user", vo);
	  /// session.setAttribute("user", vo);
	 
	   return "login.jsp";
   }
	// id,password값이 설정된 UserVO가 넘어옴
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("아이디:"+vo.getId());
		System.out.println("패스워드:"+vo.getPassword());
		/*
		 * String id=request.getParameter("id"); String
		 * pwd=request.getParamenter("password");
		 */
		   
		if(vo.getId()==null|| vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해햐 합니다.");	
		}
		UserVO user = userDAO.getUser(vo);
		
		if(user!=null) {
			session.setAttribute("useName", user.getName());
			System.out.println("userName:"+user.getName());
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
	}
	
}
