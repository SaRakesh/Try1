package com.multithread.try1;

import java.util.Arrays;

public class MyparallelStream {
	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19).stream().forEach(s -> System.out.println(s+" "));
	}
}
