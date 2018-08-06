package com.designpattern.functionalinterface;

public interface MyFunctionalSubInterface extends MyFunctionalInterface {

	public  void function1();//if we add this function than MyFunctionalSubInterface is not a Functional Interface.
	public default  void function() {
		System.out.println("Impelementing Functional Interface function...");
	}
}
