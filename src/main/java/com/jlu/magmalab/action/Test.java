package com.jlu.magmalab.action;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		String filepath = "/BACKUP";
		readFile(filepath);
	}

	private static void readFile(String filepath) {
		File file = new File(filepath);
		String[] filelist = file.list();
		for (int i = 0; i < filelist.length; i++) {
			File readfile = new File(filepath + "/" + filelist[i]);
			if (!readfile.isDirectory()) {
				String fileName=readfile.getAbsolutePath()+"/"+readfile.getName();
				int lastDotPos = fileName.lastIndexOf(".");
				String extType = fileName.substring(lastDotPos+1, fileName.length());
				System.out.println(extType+":"+fileName);
				

			} else if (readfile.isDirectory()) {
				readFile(filepath + "/" + filelist[i]);
			}
		}
	}
}
