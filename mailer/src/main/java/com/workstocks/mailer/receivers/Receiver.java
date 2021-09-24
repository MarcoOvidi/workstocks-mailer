package com.workstocks.mailer.receivers;

import java.util.concurrent.CountDownLatch;

import org.springframework.jms.annotation.JmsListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	@JmsListener(destination = "helloworld.q")
	public void receive(String message) {
		log.info("received message='{}'", message);
		latch.countDown();
	}
}