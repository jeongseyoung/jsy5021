package board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDao {
	void insert(Article a);
	Article select(int num);
	ArrayList<Article> selectAll();
	void update(Article a);
	void delete(int num);
	void insertRep(Rep r, int num);
	ArrayList<Rep> repAll(int num);
	int totalContents() throws SQLException;
	ArrayList<Article> getContentsList(int nowPage);
}
