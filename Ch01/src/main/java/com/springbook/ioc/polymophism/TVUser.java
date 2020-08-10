package com.springbook.ioc.polymophism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		/* 1. Spring Container 구동. */
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext01.xml");

		/* 2. Spring Container로 부터 필요한 Object 요청.(lookup) */
		TV tv = (TV) factory.getBean("TV");
		System.out.printf("가격: %d\n", tv.getPrice());
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

		/* 3. Spring Container 종료. */
		factory.close();
	}
}