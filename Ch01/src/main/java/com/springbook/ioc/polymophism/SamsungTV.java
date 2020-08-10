package com.springbook.ioc.polymophism;

public class SamsungTV implements TV {
	/* 속성 */
	private Speaker speaker;
	private int price;

	/* Constructor */
	public SamsungTV() {
		System.out.println("==> SamsungTV(1) 객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println("==> SamsungTV(1) 객체 생성");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("==> SamsungTV(1) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}

	/* Setter_Method */
	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("==> setPrice() 호출");
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.printf("SamsungTV---PowerOn.(Price: %d)\n", price);
	}

	@Override
	public void powerOff() {
		System.out.printf("SamsungTV---PowerOff.\n");
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