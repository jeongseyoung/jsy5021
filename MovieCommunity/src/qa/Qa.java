package qa;

import java.sql.Date;

public class Qa {
	private int num;
	private String writer;
	private String pwd;
	private String title;
	private Date qa_date;
	private String content;
	
	public Qa(){}

	public Qa(int num, String writer, String pwd, String title, Date qa_date, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.pwd = pwd;
		this.title = title;
		this.qa_date = qa_date;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getQa_date() {
		return qa_date;
	}

	public void setQa_date(Date qa_date) {
		this.qa_date = qa_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Qa [num=" + num + ", writer=" + writer + ", pwd=" + pwd + ", title=" + title + ", qa_date=" + qa_date
				+ ", content=" + content + "]";
	}
	
	
	
}
