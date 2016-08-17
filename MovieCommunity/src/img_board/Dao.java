package img_board;

import java.util.List;

public interface Dao {
	void insertImg(Img img);
	void insertArticle(ImgBoard imgBoard);
	List getImgs();
	List getArticles(int img_num);
	void delete(int num);
	String getPath(int num);
	void update(Img b);
	Img getImg(int num);
}
