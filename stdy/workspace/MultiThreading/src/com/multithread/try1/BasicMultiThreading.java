package com.multithread.try1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BasicMultiThreading {

	final private Object obj = new Object();

	public static void main(String[] args) throws Exception {
		BasicMultiThreading instance = new BasicMultiThreading();
		instance.process();
	}

	public void process() throws Exception {
		Thread threadOne = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					for (int i = 1; i < 13; i = i + 2) {

						System.out.println("count One = " + i);
						obj.notifyAll();
						try {
							obj.wait();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				}
				System.out.println("one done");

			}
		});
		Thread threadTwo = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					for (int i = 2; i < 12; i = i + 2) {

						System.out.println("count Two = " + i);
						obj.notifyAll();
						try {
							obj.wait();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				}
				System.out.println("two done");

			}
		});

		// Thread threadThree = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// synchronized (obj) {
		// for (int i = 3; i < 15; i = i + 3) {
		//
		// System.out.println("count Three = " + i);
		// obj.notifyAll();
		// try {
		// obj.wait();
		// } catch (InterruptedException e) {
		// System.out.println(e.getMessage());
		// e.printStackTrace();
		// }
		// }
		// }
		// System.out.println("Three done");
		//
		// }
		// });
		Process p = Runtime.getRuntime().exec("cmd /c dir");

		p.waitFor();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		char[] buffer = new char[1024];
		// String data= inputStream.readLine();
		Integer a = (Integer) 1;
		for (;;) {

			int rsz = bufferedReader.read(buffer, 0, buffer.length);
			if (rsz < 0)
				break;
			System.out.println(new String(buffer));
		}
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Shuting down it now....");
			}
		});

		bufferedReader.close();
		threadOne.start();
		Thread.sleep(1000);
		threadTwo.start();
		// threadThree.start();
	}
}
