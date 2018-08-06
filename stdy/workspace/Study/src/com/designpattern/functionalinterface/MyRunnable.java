package com.designpattern.functionalinterface;

/**
 * This is also a function Interface
 * @author rakesh
 *
 */
public interface MyRunnable extends Runnable {

	public default void run() {
		System.out.println(Thread.currentThread().getName()+" run method at MyRunnable Interface ");
	}
}
