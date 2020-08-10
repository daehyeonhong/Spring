package com.springbook.ioc.polymophism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {
	public static void main(String[] args) {
		/* 1. Spring Container 구동 */
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext03.xml");

		/* 2. Spring Container로 부터 필요한 객체 요청 */
		TV tv = (TV) factory.getBean("Samsung");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		/* 3. Spring Container 종료 */
	}
}