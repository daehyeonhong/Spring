package com.springbook.ioc.polymophism;

public class LGTV implements TV {
	private Speaker speaker;
	private int price;

	public LGTV() {
	}

	public LGTV(Speaker speaker) {
		System.out.println("==> LGTV 객체 생성");
		this.speaker = speaker;
	}

	public LGTV(Speaker speaker, int price) {
		System.out.println("==> LGTV 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.printf("LGTV---PowerOn.(Price: %d)\n", price);
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV---powerOff");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

	@Override
	public int getPrice() {
		return price;
	}

}