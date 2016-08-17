package movieInfo;

import java.util.ArrayList;

public interface MovieDao {
	void insert(Movie m);
	Movie select(int num);
	ArrayList<Movie> selectAll();
	void update(Movie m);
	void delete(int num);
}
