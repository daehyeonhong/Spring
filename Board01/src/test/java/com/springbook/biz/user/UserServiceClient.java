package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");

		/* LoginTset */
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test1234");
		UserVO user = userService.getUser(vo);
		System.out.printf((user != null) ? "%s님 환영합니다." : "로그인 실패.", user.getName());
		container.close();
	}
}