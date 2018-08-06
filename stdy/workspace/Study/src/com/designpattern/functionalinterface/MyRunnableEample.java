package com.designpattern.functionalinterface;

public class MyRunnableEample {

	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnableImpelement());
		t.setName("MyRunnableImpelement Thread");
		Thread t1 = new Thread(new MyRunnableImpelement1());
		t1.setName("MyRunnableImpelement1 Thread");
		t.start();
		t1.start();
	}
}

class MyRunnableImpelement implements MyRunnable{
	
}
class MyRunnableImpelement1 implements MyRunnable{
	public void run() {
//		super.run();
		System.out.println(Thread.currentThread().getName()+" run method at MyRunnableImpelement1 ");
	}
}