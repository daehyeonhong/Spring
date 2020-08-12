package com.springbook.biz;

import java.sql.Date;

public class BoardVO {
	private int seq, cnt;
	private String title, writer, content;
	private Date regDate;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [글 번호: " + seq + ", 글 제목: " + title + ", 작성자: " + writer + ", 내용: " + content + ", 등록 일: "
				+ regDate + ", 조회 수: " + cnt + "]";
	}

}