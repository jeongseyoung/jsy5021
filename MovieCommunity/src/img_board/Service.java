package img_board;

import java.util.List;


public interface Service {
	void addImg(Img img);
	List writeContent(ImgBoard imgBoard);
	List getAll();
	void delete(int num);
	String getPath(int num);
	void imgedit(Img b);
	Img select(int num);
	List getBoard(int img_num);
}
