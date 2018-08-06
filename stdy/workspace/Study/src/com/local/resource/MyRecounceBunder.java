package com.local.resource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyRecounceBunder {

	public static void main(String[] args) {
		MyRecounceBunder.process();
	}

	private static void process() {
		Locale localIN = new Locale("hi", "IN");
		Locale localEN = new Locale("en", "US");
		loadRsouceBunder(localIN);
		loadRsouceBunder(localEN);
	}

	private static void loadRsouceBunder(Locale localIN) {
		ResourceBundle bundle = ResourceBundle.getBundle("config", localIN);
		String user = bundle.getString("user");
		System.out.println(MessageFormat.format(user, "Aherikar"));
		System.out.println(bundle.getString("company1"));
		System.out.println(bundle.getString("company2"));
		System.out.println(bundle.getString("company3"));
		
	}
}
