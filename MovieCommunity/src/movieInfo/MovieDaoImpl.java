package movieInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import java.util.ArrayList;
import org.springframework.jdbc.datasource.DataSourceUtils;

import board.Article;
import member.Member;

public class MovieDaoImpl implements MovieDao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;


	public MovieDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void con() {
		// TODO Auto-generated method stub
		conn = DataSourceUtils.getConnection(dataSource);
	}

	public void discon() {
		// TODO Auto-generated method stub
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

	public void insert(Movie a) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into movieInfo values(seq_movieInfo.nextval, ?, ?, ?, ?, ?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getTitle());
			pstmt.setString(2, a.getDirector());
			pstmt.setString(3, a.getRelease_date());
			pstmt.setString(4, a.getVideo());
			pstmt.setString(5, a.getContent());
			pstmt.executeUpdate();
			discon();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Movie select(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from movieInfo where num=?";
		ResultSet rs = null;
		Movie m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			m=new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public ArrayList<Movie> selectAll() {
		// TODO Auto-generated method stub
		con();
	ArrayList<Movie> list = new ArrayList<Movie>();
		String sql = "select * from movieInfo order by num desc";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Movie m) {
		// TODO Auto-generated method stub
		System.out.println("dao num:"+m.getNum());
		con();
		String sql = "update movieInfo set title=?, director=?, release_date=?, video=?, content=?  where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, m.getDirector());
			pstmt.setString(3, m.getRelease_date());
			pstmt.setString(4, m.getVideo());
			pstmt.setString(5, m.getContent());
			pstmt.setInt(6, m.getNum());
			pstmt.executeUpdate();
			discon();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "delete movieInfo where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
