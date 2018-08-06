package com.singaltom.try1;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MySingleton implements Serializable {

	private static final long serialVersionUID = 8109048858749666502L;
	private static volatile MySingleton instance = null;

	private MySingleton() {
		if (MySingleton.instance != null) {
			throw new RuntimeException(
					"Can't create another instance. please use MySingleton.getInstance(), to get instance of MySinglton class.");
		}
		System.out.println("creating instance of MySingloton.");
	}

	private Object readResolve() throws ObjectStreamException {
		return instance;
	}

	public static MySingleton getInstance() {
		if (instance == null) {
			synchronized (MySingleton.class) {
				if (instance == null) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}

}
