package img_board;

public class ImgBoard {
	private int num;
	private String content;
	private String writer;
	private int img_num;
	
	public ImgBoard(){}
	public ImgBoard(int num, String content, String writer, int img_num) {
		this.num = num;
		this.content = content;
		this.writer = writer;
		this.img_num = img_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	@Override
	public String toString() {
		return "ImgBoard [num=" + num + ", content=" + content + ", writer="
				+ writer + ", img_num=" + img_num + "]";
	}
	
	
}
