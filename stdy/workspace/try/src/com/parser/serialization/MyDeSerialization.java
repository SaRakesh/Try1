package com.parser.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.parser.stringsprite.pojo.JsonData;

public class MyDeSerialization {
	public static void main(String[] args) {
		try {
			new MyDeSerialization().deSerialization();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deSerialization() throws Exception {
		File inputFile = new File("objectFile.txt");
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFile));
		for (int i = 0; true; i++) {
			Object obj = inputStream.readObject();
			if (obj instanceof JsonData) {
				JsonData data = (JsonData) obj;
				System.out.print("object of JsonData ");
				System.out.println(data);
			} else if (obj instanceof String) {
				String data = (String) obj;
				System.out.print("object of String ");
				System.out.println(data);
			} else {
				System.out.println("unknow object to deserialied");
			}
		}
	}
}
