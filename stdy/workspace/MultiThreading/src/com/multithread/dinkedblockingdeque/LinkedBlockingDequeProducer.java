package com.multithread.dinkedblockingdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeProducer implements Runnable {

	private BlockingDeque<String> blockingDeque;

	public LinkedBlockingDequeProducer(BlockingDeque<String> blockingDeque) {
		this.blockingDeque = blockingDeque;
	}

	@Override
	public void run() {
		for(int i=0; i< 100; i++) {
			try {
				boolean result1 = this.blockingDeque.offerFirst("offerFirst count "+i, 1, TimeUnit.SECONDS);
				if(!result1) {
					System.out.println("offerFirst count "+i+" missed");
				}else
					System.out.println("offerFirst count "+i+" success");
				
				boolean result2 = this.blockingDeque.offerLast("offerLast count "+i, 1, TimeUnit.SECONDS);
				if(!result2) {
					System.out.println("offerLast count "+i+" missed");
				}else
					System.out.println("offerLast count "+i+" success");
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
