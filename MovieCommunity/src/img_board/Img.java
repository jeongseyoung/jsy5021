package img_board;

import org.springframework.web.multipart.MultipartFile;

public class Img {
	private int num;
	private String path;
	private String title;
	private String id;
	private MultipartFile file;
	private String content;
	
	public Img(){}
	
	
	public Img(int num, String path, String title, String id, String content) {
		this.num = num;
		this.path = path;
		this.title = title;
		this.id = id;		
		this.content = content;
	}


	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Img [num=" + num + ", path=" + path + ", title=" + title + ", id=" + id + ", file=" + file
				+ ", content=" + content + "]";
	}	
}
