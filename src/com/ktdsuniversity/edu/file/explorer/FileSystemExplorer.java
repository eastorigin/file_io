package com.ktdsuniversity.edu.file.explorer;

import java.io.File;

public class FileSystemExplorer {

	/**
	 * 지정한 경로 아래에 있는 모든 파일들의 전체 경로를 출력
	 * @param dir : 지정한 경로
	 */
	public void explorer (File dir) {
		if (dir.exists() && dir.isDirectory()) { // 파라미터 dir이 존재하고 폴더일 경우
			File[] itemInDir = dir.listFiles(); // itemInDir 라는 파일 배열에 dir 내에 존재하는 모든 것들을 넣는다.
			
			for (File item : itemInDir) { // itemInDir 배열의 각 파일 요소들을 item이라 명명하고
				if (item.isDirectory()) { // 만일 item이 폴더일 경우
					explorer(item); // Recursive Call
				}else {
					System.out.println(item.getAbsolutePath()); // item이 폴더가 아니라면 item의 절대경로를 콘솔창에 출력한다.
				}
			}
		}else if (dir.exists() && dir.isFile()) { // 파라미터 dir이 존재하고 파일일 경우
			System.out.println(dir.getAbsolutePath()); // dir의 절대경로를 출력한다
		}
	}
	
	public static void main(String[] args) {
		FileSystemExplorer fse = new FileSystemExplorer(); // FileSystemExplorer 객체 생성
		File dir = new File("C:\\Program Files (x86)"); // C드라이브 프로그램 파일 경로를 dir에 넣는다
		fse.explorer(dir); // dir에 대해 explorer 실행
	}
}
