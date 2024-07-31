package com.ktdsuniversity.edu.file.io.input;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Article {

	private int articleNumber;
	private String title;
	private String description;
	private String author;
	private int viewCount;
	
	public Article(String line) {
		String[] lineArray = line.split("\\|"); // \\ 쓰인 이유: |가 정규표현식이 아니고 문자인걸 알리기 위해서
		
		this.articleNumber = Integer.parseInt(lineArray[0]);
		this.title = lineArray[1];
		this.description = lineArray[2];
		this.author = lineArray[3];
		this.viewCount = Integer.parseInt(lineArray[4]);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("번호: " + this.articleNumber);
		sb.append("\n제목: " + this.title);
		sb.append("\n내용: " + this.description);
		sb.append("\n작성자: " + this.author);
		sb.append("\n조회수: " + this.viewCount);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
//		String line = "1|첫 번째 게시글입니다.|첫 번째 게시글의 내용입니다.|신동원|46";
//		Article article = new Article(line);
//		System.out.println(article);
		
		// 1. articles.txt 파일을 File 인스턴스로 가져온다
		File articlesFile = new File("C:\\\\Java Exam","articles.txt");
		
		// 2. List<Article> 인스턴스를 정의한다.
		List<Article> articleList = new ArrayList<>();
		
		// 3. articles.txt 파일을 Files.readAlllines()를 통해 읽는다
		try {
			List<String> lines = Files.readAllLines(articlesFile.toPath(), Charset.defaultCharset());
			
			// 4. 읽어온 결과를 List<Article>에 add 한다
			for (String line : lines) {
				articleList.add(new Article(line));
			}
			
			// 5. List<Article>을 모두 출력한다
			for (Article article  : articleList) {
				System.out.println(article);
			}
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
