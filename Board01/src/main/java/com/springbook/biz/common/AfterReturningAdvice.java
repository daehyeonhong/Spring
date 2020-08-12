package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	@AfterReturning(pointcut = "execution(* com.springbook.biz..*Impl.get*(..))", returning = "returnObj")
	public void afterLog(JoinPoint joinPoint, Object returnObj) {
		String method = joinPoint.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("Admin")) {
				System.out.printf("%s 로그인(Admin)", user.getName());
			}
		}
		System.out.println("[사후 처리]" + method + "()Method_return" + returnObj.toString());
	}
}