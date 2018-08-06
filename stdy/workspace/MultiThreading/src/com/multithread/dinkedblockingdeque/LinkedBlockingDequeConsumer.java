package com.multithread.dinkedblockingdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeConsumer implements Runnable{

	private BlockingDeque<String> blockingDeque;

	public LinkedBlockingDequeConsumer(BlockingDeque<String> blockingDeque) {
		this.blockingDeque = blockingDeque;
	}

	@Override
	public void run() {
		for(int i=0; i<100;i++) {
			try {
				String data = this.blockingDeque.pollFirst(1, TimeUnit.SECONDS);
				if(data != null) {
					System.out.println(Thread.currentThread().getName()+" pollFirst "+data);
				}else {
					data = this.blockingDeque.pollLast(1, TimeUnit.SECONDS);
					if(data != null)
						System.out.println(Thread.currentThread().getName()+" pollLast "+data);
					else {
						System.out.println(Thread.currentThread().getName()+" Consumer missed "+ data);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
