package com.parser.stringsprite;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MyStringParser {
	public static void main(String[] args) throws Exception {
		String data = readJSON("E://workspace//try//as.po.json");
		if(data != null){
			String[] jsonElements = data.split("},");
			for(int i =0 ;i < 50; i++){
				System.out.println(jsonElements[i].trim());
			}
		}else{
			System.out.println("fail to read json file");
		}
	}

	private static String readJSON(String fileName) throws Exception {
		File fileas = new File(fileName);
		Reader fisas = null;
		String stras = null;
		try {
			fisas = new InputStreamReader(new FileInputStream(fileas), "UTF-8");
			char[] dataas = new char[(int) fileas.length()];
			fisas.read(dataas);
			stras = new String(dataas);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fisas.close();
		}
		return stras;
	}

}
