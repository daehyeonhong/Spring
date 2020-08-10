package com.springbook.ioc.polymophism;

import javax.annotation.Resource;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;*/
import org.springframework.stereotype.Component;

@Component("TV")
public class LGTV implements TV {
	/* @Autowired 자동 주입(ComponentScan에 의해 등록된 component중에 speaker 객체 주입) */
	/* @Qualifier("sony") */
	@Resource(name = "sony") /* Java 제공 */
	private Speaker speaker;
	private int price;
	/* Constructor */
	/*
	 * public LGTV() { }
	 * 
	 * public LGTV(Speaker speaker) { System.out.println("==> LGTV 객체 생성");
	 * this.speaker = speaker; }
	 * 
	 * public LGTV(Speaker speaker, int price) {
	 * System.out.println("==> LGTV 객체 생성"); this.speaker = speaker; this.price =
	 * price; }
	 */

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