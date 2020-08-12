package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	/* 외부 파일로 작성한 pointcut을 호출하여 사용할 수 있음 */
	/* @Around("execution(* com.springbook.biz..*Impl.*(..))") */
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		/* Client가 요청한 Method 실행 */
		Object object = proceedingJoinPoint.proceed();
		stopWatch.stop();
		System.out.printf("%s()Method 실행에 걸린 시간: %d(ms)초%n", method, stopWatch.getTotalTimeMillis());
		return object;
	}
}