package com.singaltom.try1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.Random;

public class MySingletonMain {
	public static void main(String[] args) {
		Thread[] t = new Thread[100];
		for(int i =0; i<100; i++) {
			t[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					MySingleton singleton = MySingleton.getInstance();
					System.out.println("Hash code of11 "+singleton.hashCode());
					try {
						Random random = new Random();
						String fileName ="E:/temp/s2"+random.nextInt()+".ser";
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
						oos.writeObject(singleton);
						oos.close();
						
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
						MySingleton singleton2 = (MySingleton) ois.readObject();
						ois.close();
						System.out.println("Hash code of serialigetion "+singleton2.hashCode());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("error 1"+e1.getMessage());
					}
					try {
						Class<MySingleton> class1 = (Class<MySingleton>) Class.forName("com.singaltom.try1.MySingleton");
						Constructor<MySingleton> k =  (Constructor<MySingleton>) class1.getDeclaredConstructors()[0];
						k.setAccessible(true);
						MySingleton singleton2 = k.newInstance();
						System.out.println("Hash code of22 "+singleton2.getClass()+"  :  "+singleton2.hashCode());
					} catch (Exception e) {
						System.out.println("error 1"+e.getMessage());
//						e.printStackTrace();
					}
					
				}
			});
		}
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}
	}
}
