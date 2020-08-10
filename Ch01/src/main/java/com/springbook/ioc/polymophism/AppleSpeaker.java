package com.springbook.ioc.polymophism;

import org.springframework.stereotype.Component;

@Component("speaker")
public class AppleSpeaker implements Speaker {
	/* Constructor */
	public AppleSpeaker() {
		System.out.println("==> AppleSpeaker 객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker---volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker---volumeDown");
	}

}