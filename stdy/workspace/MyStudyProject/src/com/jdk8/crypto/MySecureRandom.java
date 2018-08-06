package com.jdk8.crypto;

import java.security.SecureRandom;

public class MySecureRandom {

	public static void main(String[] args) {
		try{
			byte[] seed = {1, 20 , 9 , 3, 7, 51 ,5};
			SecureRandom secureRandom0 = new SecureRandom(seed );
			SecureRandom secureRandom1 = new SecureRandom();
			SecureRandom secureRandom2 = SecureRandom.getInstance("Windows-PRNG");
			SecureRandom secureRandom3 = SecureRandom.getInstanceStrong();
			SecureRandom secureRandom4 = new SecureRandom(secureRandom1.generateSeed(10));
			System.out.println(secureRandom3.getAlgorithm());
			for(int i=0; i< 10; i++){
				System.out.println("net double from secureRandom0 "+secureRandom0.nextDouble());
				System.out.println("net double from secureRandom1 "+secureRandom1.nextDouble());
				System.out.println("net double from secureRandom2 "+secureRandom2.nextDouble());
				System.out.println("net double from secureRandom3 "+secureRandom3.nextDouble());
				System.out.println("net double from secureRandom4 "+secureRandom4.nextDouble());
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
