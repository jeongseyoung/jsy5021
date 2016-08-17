package movieInfo;

import java.sql.Date;

public class Movie {

	private int num;
	private String title;
	private String director;
	private String release_date;
	private String video;
	private String content;
	

	public Movie(){}


	public Movie(int num, String title, String director, String release_date, String video, String content) {
		super();
		this.num = num;
		this.title = title;
		this.director = director;
		this.release_date = release_date;
		this.video = video;
		this.content = content;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getRelease_date() {
		return release_date;
	}


	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}


	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Movie [num=" + num + ", title=" + title + ", director=" + director + ", release_date=" + release_date
				+ ", video=" + video + ", content=" + content + "]";
	}

	
	
	
	
}
