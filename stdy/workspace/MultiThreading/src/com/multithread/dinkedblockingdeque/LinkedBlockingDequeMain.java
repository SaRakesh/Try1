package com.multithread.dinkedblockingdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeMain {
	public static void main(String[] args) {
		BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>();
		LinkedBlockingDequeProducer producer = new LinkedBlockingDequeProducer(blockingDeque);
		LinkedBlockingDequeConsumer consumer1 = new LinkedBlockingDequeConsumer(blockingDeque);
		LinkedBlockingDequeConsumer consumer2 = new LinkedBlockingDequeConsumer(blockingDeque);
		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}
