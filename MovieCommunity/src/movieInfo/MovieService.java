package movieInfo;

import java.util.ArrayList;

public interface MovieService {
	void addMovie(Movie m);
	Movie getMovie(int num);
	ArrayList<Movie> getAll();
	void editMovie(Movie m);
	void delMovie(int num);
}
