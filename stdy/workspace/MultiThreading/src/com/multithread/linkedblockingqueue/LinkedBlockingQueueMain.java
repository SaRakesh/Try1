package com.multithread.linkedblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueMain {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
		LinkedBlockingQueueProducer producer = new LinkedBlockingQueueProducer(blockingQueue);
		LinkedBlockingQueueConsumer consumer1 = new LinkedBlockingQueueConsumer(blockingQueue);
		LinkedBlockingQueueConsumer consumer2 = new LinkedBlockingQueueConsumer(blockingQueue);
		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}
