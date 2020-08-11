package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@AfterThrowing(pointcut = "execution(* com.springbook.biz..*Impl.*(..))", throwing = "exceptionObject")
	public void exceptionLog(JoinPoint joinPoint, Exception exceptionObject) {
		String method = joinPoint.getSignature().getName();
		System.out.printf("%s()Method실행 중 예외 발생\n", method);
		if (exceptionObject instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력 되었습니다.");
		} else if (exceptionObject instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if (exceptionObject instanceof Exception) {
			System.out.println("문제가 발생하였습니다.");
		}
	}
}