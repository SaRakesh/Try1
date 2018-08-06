package com.parser.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.parser.stringsprite.pojo.JsonData;
import com.parser.stringsprite.pojo.MyEnum;

public class MySerialization {

	public static void main(String[] args) {
		try {
			new MySerialization().serialization();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void serialization() throws Exception {

		JsonData[] date = generatData();
		File outFile = new File("objectFile.txt");
//		if (outFile.exists()) {
//			outFile.delete();
//		}
//		outFile.createNewFile();
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outFile));
		for (int i = 0; i < date.length; i++) {
			outputStream.writeObject(date[i]);
		}
		for (int i = 0; i < 10; i++) {
			outputStream.writeObject(new String("abcd "+i));
		}
		outputStream.flush();
		outputStream.close();

	}

	private JsonData[] generatData() {
		JsonData[] data = new JsonData[8];
		for (int i = 1; i <= data.length; i++) {
			String[] speaktag = { "" + (1 * i), "" + (2 * i), "" + (3 * i), "" + (4 * i) };
			data[i-1] = new JsonData("aaaaaa" + i, "bbbbbbb" + i,MyEnum.valueOf("MyEnum"+i), speaktag);
			data[i-1].setNewArg("new Arg " + i);
			System.out.println(data[i-1]);
		}
		return data;
	}
}
