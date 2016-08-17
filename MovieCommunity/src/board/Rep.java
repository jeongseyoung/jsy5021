package board;

import java.sql.Date;

public class Rep {	
	private int num;
	private String writer;
	private String content;
	private Date rep_date;
	
	public Rep() {		
	}

	public Rep(int num, String writer, String content, Date rep_date) {	
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.rep_date = rep_date;
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

	public Date getRep_date() {
		return rep_date;
	}

	public void setRep_date(Date rep_date) {
		this.rep_date = rep_date;
	}

	@Override
	public String toString() {
		return "Rep [num=" + num + ", writer=" + writer + ", content=" + content + ", rep_date=" + rep_date + "]";
	}	
}
