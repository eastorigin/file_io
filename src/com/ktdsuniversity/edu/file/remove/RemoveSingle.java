package com.ktdsuniversity.edu.file.remove;

import java.io.File;

public class RemoveSingle {

	public void removeFile(File file) {
		file.delete();
	}
	
	public void removeDir(File dir) {
		dir.delete();
	}
	
	public static void main(String[] args) {
		
		RemoveSingle removeSingle = new RemoveSingle();
		
		File txtFile = new File("C:\\java\\outputs\\java_output.txt");
		removeSingle.removeFile(txtFile);
		
		File dir = new File("C:\\java\\outputs\\exam");
		removeSingle.removeDir(dir);
		
		File dir2 = new File("C:\\java\\outputs");
		removeSingle.removeDir(dir2);
		
		File dir3 = new File("C:\\java");
		removeSingle.removeDir(dir3);
		
		// 파일은 삭제 가능
		// 폴더의 경우에는 비어있는 폴더만 삭제 가능
		// 폴더를 지우려면, 폴더 내부의 모든 파일 및 폴더를 삭제해야한다
	}
}