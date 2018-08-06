package com.eception;

import java.util.Scanner;

public class TryBlockStudy {

	public static void main(String[] args)  {
		TryBlockStudy instance = new TryBlockStudy();
		instance.process();
	}

	private void process() {
		try(MyAutoCloseable autoCloseable = new MyAutoCloseable();
				Scanner s = new Scanner(System.in)){
			autoCloseable.doSomething();
			String variable = s.nextLine();
			System.out.println(variable);
			autoCloseable.throwExceoption();
		}catch (Exception e) {
			System.out.println("Catch Block");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("finally block");
		}
		
	}
}

class MyAutoCloseable implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("close function is running...");
		
	}
	
	public void throwExceoption() throws Exception {
		System.out.println("throwExceoption Function");
		throw new Exception("Exception Class Object", null);
	}

	public void doSomething() {
		for(int i =0; i< 10; i++) {
			System.out.println("Kalu Bhaiya ...");
		}
	}
	
}