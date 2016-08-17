package qa;

import java.sql.Date;

public class QaRep {
	private int num;
	private String writer;
	private String content;
	private Date qarep_date;
	
	public QaRep(){}

	public QaRep(int num, String writer, String content, Date qarep_date) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.qarep_date = qarep_date;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getQarep_date() {
		return qarep_date;
	}

	public void setQarep_date(Date qarep_date) {
		this.qarep_date = qarep_date;
	}

	@Override
	public String toString() {
		return "QaRep [num=" + num + ", writer=" + writer + ", content=" + content + ", qarep_date=" + qarep_date + "]";
	}
	
	
}
