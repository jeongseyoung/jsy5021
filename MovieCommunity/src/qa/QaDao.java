package qa;

import java.util.ArrayList;


public interface QaDao {
	void insert(Qa a);
	Qa select(int num);
	ArrayList<Qa> selectAll();
	void update(Qa a);
	void delete(int num);
	void insertQaRep(QaRep r, int num);
	ArrayList<QaRep> qarepAll(int num);
}
