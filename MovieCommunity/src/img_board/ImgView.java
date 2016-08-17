package img_board;

import java.util.ArrayList;

public class ImgView {
	private Img img;
	private ArrayList<ImgBoard> list;
	
	public ImgView(){}
	public ImgView(Img img, ArrayList<ImgBoard> list) {
		this.img = img;
		this.list = list;
	}
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
	}
	public ArrayList<ImgBoard> getList() {
		return list;
	}
	public void setList(ArrayList<ImgBoard> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ImgView [img=" + img + ", list=" + list + "]";
	}
	
	
}
