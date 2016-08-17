package board;

import java.sql.SQLException;
import java.util.ArrayList;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao;
	//private BoardService instance;
	
	public BoardServiceImpl(BoardDao dao) {
		this.dao = dao;
	}
	
	/*@Override
	public BoardService getInstance(){
		return instance;
	}*/

	@Override
	public void addArticle(Article a) {
		// TODO Auto-generated method stub
		dao.insert(a);
	}

	@Override
	public Article getArticle(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public ArrayList<Article> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editArticle(Article a) {
		// TODO Auto-generated method stub
		dao.update(a);
	}

	@Override
	public void delArticle(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}
	
	@Override
	public void addRep(Rep r, int num) {
		// TODO Auto-generated method stub
		dao.insertRep(r, num);
	}

	@Override
	public ArrayList<Rep> allRep(int num) {
		// TODO Auto-generated method stub
		return dao.repAll(num);
	}	

	@Override
	public Listitem getContentList(int nowPage) throws SQLException {
		// TODO Auto-generated method stub
		int totalContents=dao.totalContents();
		Paging bean=new Paging(totalContents,nowPage);
		ArrayList<Article> list= dao.getContentsList(nowPage);
		Listitem listvo=new Listitem(list,bean);
		return listvo;
	}

}
