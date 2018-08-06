package com.multithread.try1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyBasicConsumerProducerSolution {

	public static void main(String[] args) {
		MyBasicConsumerProducerSolution instance = new MyBasicConsumerProducerSolution();
		instance.process();
	}

	private void process() {
		try {
			LinkedBlockingQueue<String> blockingDeque = new LinkedBlockingQueue<String>();
			Thread producer = new Thread(new MyProducer(blockingDeque));
			Thread consumer = new Thread(new MyConsumer(blockingDeque));
			producer.start();
			consumer.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
class MyProducer implements Runnable{

	private LinkedBlockingQueue<String> blockingDeque;

	public MyProducer(LinkedBlockingQueue<String> blockingDeque2) {
		this.blockingDeque = blockingDeque2;
	}

	@Override
	public void run() {
		try {
			for(int i=0; i<100 ; i++) {
				System.out.println("Counter number "+i+" A added ");
				this.blockingDeque.offer("Counter number "+i+" A");
//				this.blockingDeque.offerFirst("Counter number "+i+" B");
//				this.blockingDeque.offerFirst("Counter number "+i+" C");
//				this.blockingDeque.offerFirst("Counter number "+i+" D");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	

}
class MyConsumer implements Runnable{

	private LinkedBlockingQueue<String> blockingDeque;

	public MyConsumer(LinkedBlockingQueue<String> blockingDeque2) {
		this.blockingDeque = blockingDeque2;
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println(Thread.currentThread().getName()+" is waiting...");
				String data = this.blockingDeque.poll(3, TimeUnit.SECONDS);
				if(data == null) {
					System.out.println(Thread.currentThread().getName()+ " missed data ");
				}else
					System.out.println(Thread.currentThread().getName()+ "got data "+data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
	
