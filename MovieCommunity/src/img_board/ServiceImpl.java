package img_board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class ServiceImpl implements Service {
	private Dao dao;

	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}


	@Override
	public void addImg(Img img) {
		// TODO Auto-generated method stub
		dao.insertImg(img);
	}

	@Override
	public List writeContent(ImgBoard imgBoard) {
		// TODO Auto-generated method stub
		dao.insertArticle(imgBoard);
		return dao.getArticles(imgBoard.getImg_num());
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return dao.getImgs();
		/*ArrayList<ImgView> data = new ArrayList<ImgView>();
		ArrayList<Img> imgs = (ArrayList<Img>) dao.getImgs();
		for (int i = 0; i < imgs.size(); i++) {
			Img img = imgs.get(i);
			ImgView imgView = new ImgView(img,
					(ArrayList<ImgBoard>) dao.getArticles(img.getNum()));
			data.add(imgView);
		}
		return data;*/
	}

	@Override
	public void delete(int num) {
		dao.delete(num);	
		
	}


	@Override
	public String getPath(int num) {
		// TODO Auto-generated method stub
		return dao.getPath(num);
	}


	@Override
	public void imgedit(Img b) {
		// TODO Auto-generated method stub
		dao.update(b);
	}

	@Override
	public Img select(int num) {
		// TODO Auto-generated method stub
		return dao.getImg(num);
	}


	@Override
	public List getBoard(int img_num) {
		// TODO Auto-generated method stub
		return dao.getArticles(img_num);
	}		
}
