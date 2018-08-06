package com.designpattern.immutable;

import java.util.Arrays;

public class MyMutable {
	private char[] charArray;

	public char[] getCharArray() {
		return charArray;
	}

	public void setCharArray(char[] charArray) {
		this.charArray = charArray;
	}

	public MyMutable(char[] charArray) {
		super();
		this.charArray = charArray;
	}

	@Override
	public String toString() {
		return "MyMutable [charArray=" + Arrays.toString(charArray) + "]";
	}
	
}
