package com.property.try1;

import java.io.FileInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Properties;


public class PropertiesFileUtility implements Serializable {

	/**
	 * A Singleton class to load Property file, which is define in fileName variable.
	 */
	private static final long serialVersionUID = -3715013136030937456L;
	private static volatile PropertiesFileUtility instance = null;
	private Properties prop = new Properties();
	private FileInputStream inputStream = null;
	private String fileName = "config.properties";

	public Properties getProp() {
		return this.prop;
	}

	private PropertiesFileUtility() throws Exception {
		if (PropertiesFileUtility.instance != null) {
			throw new RuntimeException(
					"Can't create another instance. please use PropertiesFileUtil.getInstance(), to get instance of PropertiesFileUtil class.");
		}
		this.prop = new Properties();
		inputStream = new FileInputStream(fileName);
		prop.load(inputStream);

	}

	private Object readResolve() throws ObjectStreamException {
		return instance;
	}

	public static PropertiesFileUtility getInstance() {
		if (instance == null) {
			synchronized (PropertiesFileUtility.class) {
				if (instance == null) {
					try {
						instance = new PropertiesFileUtility();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}

}
