package com.multithread.linkedblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueConsumer implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public LinkedBlockingQueueConsumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = this.blockingQueue.poll(2, TimeUnit.SECONDS);
				if(data == null) {
					System.out.println(Thread.currentThread().getName()+" missed");
				}else {
					System.out.println(Thread.currentThread().getName()+" get Data '"+data+"'");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}