package com.something.code;

import java.util.ArrayList;
import java.util.Scanner;

public class SomeClass {
	private String result = "";
	private ArrayList<Integer> tempArry ;
	private String[] number= {" ","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
	private String[] tenths = {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	private String[] units = {"","hundred","thousand","lakh","cr"};
	

	public static void main(String[] args) {
		SomeClass instance = new SomeClass();
		for (long i = 0; i < 10; i++) {
			instance.dosomething(i);
		}
		
	}

	private void dosomething(long arg) {
		Scanner scanner = new Scanner(System.in);
		long amount = scanner.nextLong();//arg;
		long amt = amount;
		tempArry = new ArrayList();
		result = "";
		if(amount == 0) {
			System.out.println("result  "+amount+"  Zero");
			return;
		}
		do {
			int taj = (int) (amt % 100);
			tempArry.add(taj);
			amt = amt /100;
		}while(amt > 0);
		
		for (int i = 0; i < tempArry.size(); i++) {
			int k = (int) tempArry.get(i);
			String unit = "";
			if(i > 0)
				unit = units[i];
			if(k< 20)
				result =  number[k] + " "+ unit +" "+ result;
			else {
				result = tenths[k/10]+ " " + number[k%10] + " "+ unit + " "+ result;
			}
			
		}
		System.out.println("result  "+amount+"  "+ result.trim());
		
	}
}
