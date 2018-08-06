package com.multithread.try1;

import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {
	public static void main(String[] args) {
		MyCyclicBarrier instance = new MyCyclicBarrier();
		instance.proccess();
	}

	private void proccess() {
		CyclicBarrier barrier1 = new CyclicBarrier(3);
		CyclicBarrier barrier2 = new CyclicBarrier(3);
		CyclicBarrier barrier3 = new CyclicBarrier(3);
		CyclicBarrier barrier4 = new CyclicBarrier(3);
		Thread[] t = new Thread[9]; 
		for(int i =0; i< t.length; i++) {
			t[i] = new Thread(new MyRunnable(barrier1, barrier2, barrier3, barrier4));
			t[i].setName("Thread Number "+i);
		}
		System.out.println("starting all thread...");
		
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}
		
	}

}

class MyRunnable implements Runnable {
	CyclicBarrier barrier1;
	CyclicBarrier barrier2;
	CyclicBarrier barrier3;
	CyclicBarrier barrier4;

	public MyRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2, CyclicBarrier barrier3, CyclicBarrier barrier4) {
		super();
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
		this.barrier3 = barrier3;
		this.barrier4 = barrier4;
	}

	@Override
	public void run() {

		try {
			step1();
			this.barrier1.await();
			step2();
			this.barrier2.await();
			step3();
			this.barrier3.await();
			step4();
			this.barrier4.await();
			System.out.println(Thread.currentThread().getName() + " Complited");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	private void step4() throws Exception {
		System.out.println(Thread.currentThread().getName() + " ia at STEP 4");
		Thread.sleep(1000);
	}

	private void step3() throws Exception {
		System.out.println(Thread.currentThread().getName() + " ia at STEP 3");
		Thread.sleep(1000);

	}

	private void step2() throws Exception {
		System.out.println(Thread.currentThread().getName() + " ia at STEP 2");
		Thread.sleep(1000);

	}

	private void step1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " ia at STEP 1");
		Thread.sleep(1000);

	}
}
