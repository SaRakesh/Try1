package com.parser.stringsprite;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PoDeserialization {
	public static void main(String[] args) throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D://Fundamentals_aus//wesley//deploy//server//bin//au.mo"));
		System.out.println("" + (String) inputStream.readObject());
	}
}
