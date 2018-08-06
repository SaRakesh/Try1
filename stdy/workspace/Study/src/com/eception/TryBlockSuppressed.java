package com.eception;

import java.util.Random;

public class TryBlockSuppressed {
	public static void main(String[] args) {
		TryBlockSuppressed instance = new TryBlockSuppressed();
		instance.process();
	}

	private void process() {
		try(MyAutoCloseables autoCloseables1 = new MyAutoCloseables(new CommandClass("Command1"));
				MyAutoCloseables autoCloseables2 = new MyAutoCloseables(new CommandClass("Command2"));
				MyAutoCloseables autoCloseables3 = new MyAutoCloseables(new CommandClass("Command3"))){
			autoCloseables1.doSometing();
			autoCloseables2.doSometing();
		}catch (CanNotCloseException e) {
			System.out.println("catch block of Exception CanNotCloseException...");
			System.out.println("exception msg  "+e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				System.out.println("--- "+t.getMessage());
			}
		}catch (AnyException e) {
			System.out.println("catch block of Exception AnyException...");
			System.out.println("exception msg  "+e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				System.out.println("=== "+t.getClass());
			}
		}
		catch (Exception e) {
			System.out.println("catch block of Exception Exception...");
			System.out.println("exception msg  "+e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				System.out.println("+++ "+t.getMessage());
			}
		}finally {
			System.out.println("finally block... ");
		}
		
	}

}
class MyAutoCloseables implements AutoCloseable{

	private CommandClass cmds;

	public MyAutoCloseables(CommandClass cmds) {
		super();
		this.cmds = cmds;
	}

	public void doSometing() throws AnyException{
		System.out.println("doSometing function....");
		throw new AnyException("Exception throw in Try block....");
		
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing... "+cmds.getName());
		if(!cmds.canClose()) {
			throw new CanNotCloseException();
		}
	}
	
}
class CommandClass{
	private Random random;
	private String name;
	public String getName() {
		return name;
	}
	public CommandClass(String name) {
		this.random = new Random();
		this.name = name;
	}
	public boolean canClose() {
		boolean result = false;
		if(this.random.nextInt() % 2 == 0 && false) {
			result = true;
		}
		return result;
	}
	
}
class CanNotCloseException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8869492281617621629L;
	public CanNotCloseException() {
		super();
	}
	public CanNotCloseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public CanNotCloseException(String message, Throwable cause) {
		super(message, null);
	}
	public CanNotCloseException(String message) {
		super(message);
	}
	public CanNotCloseException(Throwable cause) {
		super();
	}
}
class AnyException extends Exception{
	private static final long serialVersionUID = 1L;
	public AnyException() {
		super();
	}
	public AnyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AnyException(String message, Throwable cause) {
		super(message, null);
	}
	public AnyException(String message) {
		super(message);
	}
	public AnyException(Throwable cause) {
		super();
	}
}