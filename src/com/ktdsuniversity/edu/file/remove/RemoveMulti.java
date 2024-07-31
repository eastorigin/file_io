package com.ktdsuniversity.edu.file.remove;

import java.io.File;

public class RemoveMulti {

	public void removeAllFiles(File removeDir) {
		if (removeDir.exists() && removeDir.isDirectory()) {
			File[] itemInDir = removeDir.listFiles();
			
			for (File item : itemInDir) {
				if (item.isDirectory()) {
					removeAllFiles(item); // Recursive Call
				}else {
					item.delete();
				}
			}
			
			removeDir.delete();
			
		}else if (removeDir.exists() && removeDir.isFile()) {
			removeDir.delete();
		}
	}
	
	public static void main(String[] args) {
		RemoveMulti removeMulti = new RemoveMulti();
		File removeDir = new File("C:\\java");
		removeMulti.removeAllFiles(removeDir);
	}
}
