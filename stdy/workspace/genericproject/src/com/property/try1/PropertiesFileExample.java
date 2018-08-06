package com.property.try1;

import java.util.Properties;

public class PropertiesFileExample {

	public static void main(String[] args) {
		Properties properties = PropertiesFileUtility.getInstance().getProp();
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("company1"));
		System.out.println(properties.getProperty("company2"));
		System.out.println(properties.getProperty("company3"));
	}
}
