package com.multithread.linkedblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueProducer implements Runnable{

	private BlockingQueue<String> blockingQueue;
	private int count = 0;

	public LinkedBlockingQueueProducer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				//System.out.println("produce numer "+count);
				boolean result = this.blockingQueue.offer("produce numer "+count, 1, TimeUnit.SECONDS);
				count++;
				if(!result)
					System.out.println("Count Number "+ count+" missed by Comsumer");
				else {
					System.out.println("Count Number "+ count+" Success fully consumed by Comsumer");
				}
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
