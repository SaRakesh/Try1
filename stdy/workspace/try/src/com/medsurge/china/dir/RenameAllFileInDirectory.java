package com.medsurge.china.dir;

import java.io.File;
import java.io.FilenameFilter;

public class RenameAllFileInDirectory {
	public static void main(String[] args) {
		new RenameAllFileInDirectory().process(args);
	}

	private void process(String[] args) {
		try {
			String directoryName = "E:/test/rename";
			String extensionSrc = ".mp3";
			String extensionDest = ".wav.mp3";
			File directory = new File(directoryName);
			FilenameFilter filter = new MyFilenameFilter(extensionSrc);
			File[] filesList = directory.listFiles(filter);
			for (int i = 0; i < filesList.length; i++) {
				File file = filesList[i];
				String newFileName = file.getName().replaceAll(extensionSrc, extensionDest);
				file.renameTo(new File(directoryName+"/"+newFileName));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
class MyFilenameFilter implements FilenameFilter{

	private String extension;

	public MyFilenameFilter(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.toLowerCase().endsWith(this.extension);
	}
	
}
