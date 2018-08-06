package com.medsurge.china.dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileComparatorInDirectory {

	private String absolutePath = "E:/test/sounds1";
	private boolean printDirectory = true;
	private List<File> listSrc;
	private Map<String, File> mapDest;

	public static void main(String[] args) {
		new FileComparatorInDirectory().process();
	}

	public FileComparatorInDirectory() {
		listSrc = new ArrayList<>();
		mapDest = new HashMap<String, File>();
	}

	public void process() {
		try {
			File dirSrc = new File(absolutePath);
			File dirDest = new File("E:/test/sounds2");
			File[] dirListSrc = dirSrc.listFiles();
			File[] dirListDest = dirDest.listFiles();
			checkDirecory(dirListSrc, dirListDest);

			while (listSrc.size() > 0) {
				printDirectory = true;
				File fi1 = listSrc.remove(0);
				dirListSrc = fi1.listFiles();
				File fi2 = mapDest.remove(getAbsolutePath(fi1.getAbsolutePath()));
				dirListDest = fi2.listFiles();
				checkDirecory(dirListSrc, dirListDest);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("done");

	}

	private void checkDirecory(File[] dirListSrc, File[] dirListDest) {
		Arrays.sort(dirListDest, new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (File f : dirListSrc) {
			File temp = isFileOrDirectoryPresentUsingBinarysearch(f, dirListDest);
			if (f.isDirectory()) {
				if (temp != null) {
					listSrc.add(f);
					mapDest.put(getAbsolutePath(f.getAbsolutePath()), temp);
				} else {
					printMessage("Directory missing ", f);
				}
			} else {
				if (temp == null) {
					printMessage("File missing ", f);
				}
			}
		}

	}

	private void printMessage(String string, File file) {
		if (printDirectory) {
			System.out.println("Director name ============= " + file.getParent());
			printDirectory = false;
		}
		System.out.println(string + file.getName());

	}

	private String getAbsolutePath(String absolutePath2) {
		return absolutePath2.replaceFirst(absolutePath, "");
	}

	private File isFileOrDirectoryPresentUsingBinarysearch(File f, File[] dirListDest) {
		File result = null;
		int first = 0;
		int last = dirListDest.length - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			if (dirListDest[middle].getName().compareTo(f.getName()) < 0)
				first = middle + 1;
			else if (dirListDest[middle].getName().compareTo(f.getName()) == 0) {
				if ((dirListDest[middle].isDirectory() && f.isDirectory())
						|| (dirListDest[middle].isFile() && f.isFile())) {
					result = dirListDest[middle];
					break;
				}
			} else
				last = middle - 1;

			middle = (first + last) / 2;
		}
		return result;
	}
}