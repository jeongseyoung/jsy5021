package board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardService {
	//BoardService getInstance();
	void addArticle(Article a);
	Article getArticle(int num);
	ArrayList<Article> getAll();
	void editArticle(Article a);
	void delArticle(int num);
	void addRep(Rep r, int num);
	ArrayList<Rep> allRep(int num);	
	Listitem getContentList(int nowPage) throws SQLException;
}
