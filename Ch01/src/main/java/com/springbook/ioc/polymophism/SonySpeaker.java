package com.springbook.ioc.polymophism;

public class SonySpeaker implements Speaker {
	/* Constructor */
	public SonySpeaker() {
		System.out.println("==> SonySpeaker 객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker---volumeUp.");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker---volumeDown.");
	}

}