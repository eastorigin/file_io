package com.ktdsuniversity.edu.file.io.input;

public class Article {

	private int articleNumber;
	private String title;
	private String description;
	private String author;
	private int viewCount;
	
	public Article(String line) {
		String[] lineArray = line.split("\\|");
		
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
		
		String line = "1|첫 번째 게시글입니다.|첫 번째 게시글의 내용입니다.|신동원|46";
		Article article = new Article(line);
		System.out.println(article);
	}
}
