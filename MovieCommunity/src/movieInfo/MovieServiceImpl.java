package movieInfo;

import java.util.ArrayList;



public class MovieServiceImpl implements MovieService {
	private MovieDao dao;

	public MovieServiceImpl(MovieDao dao) {
		this.dao = dao;
	}


	@Override
	public void addMovie(Movie m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public Movie getMovie(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public ArrayList<Movie> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editMovie(Movie m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMovie(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
