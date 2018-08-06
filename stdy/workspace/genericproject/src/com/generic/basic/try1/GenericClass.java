package com.generic.basic.try1;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {

	public static void main(String[] args) {
		MyGenericClass<String> instance = new MyGenericClass<String>();
		instance.setGenericVariable("kalu");
		System.out.println(instance.getGenericVariable());
		 List<?> list1 = new ArrayList<A>();
		 List<? extends A> list2 = new ArrayList<A>();
		 List<? super A> list3 = new ArrayList<A>();
//		 List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
		 List<? super B> list5 = new ArrayList<A>();
//		 List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
		 List<? extends B> list7 = new ArrayList<C>();
	}
	public static <T> MyGenericInterfaceImplementAnother<T> ship(T t) {
		System.out.println("Preparing " + t);
		return new MyGenericInterfaceImplementAnother<T>();
		}
	public  <T> MyGenericInterfaceImplementAnother<T> ship1(T t) {
		System.out.println("Preparing " + t);
		return new MyGenericInterfaceImplementAnother<T>();
	}
}
class A {}
class B extends A { }
class C extends B { }
