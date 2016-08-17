package qa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class QaDaoImpl implements QaDao{

	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;


	public QaDaoImpl(DataSource dataSource) {
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
	@Override
	public void insert(Qa a) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into Qa values(seq_qa.nextval, ?, ?, ?, sysdate, ?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getWriter());
			pstmt.setString(2, a.getPwd());
			pstmt.setString(3, a.getTitle());
			pstmt.setString(4, a.getContent());
			pstmt.executeUpdate();
			discon();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Qa select(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from qa where num=?";
		ResultSet rs = null;
		Qa m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
m = new Qa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public ArrayList<Qa> selectAll() {
		// TODO Auto-generated method stub
		con();
		ArrayList<Qa> list = new ArrayList<Qa>();
			String sql = "select * from qa order by num desc";
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
	list.add(new Qa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)));
				}
				discon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public void update(Qa a) {
		// TODO Auto-generated method stub
		System.out.println("dao num:"+a.getNum());
		con();
		String sql = "update qa set title=?, pwd=?, qa_date=sysdate, content=?  where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getTitle());
			pstmt.setString(2, a.getPwd());
			pstmt.setString(3, a.getContent());
			pstmt.setInt(4, a.getNum());
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
		String sql = "delete qa where num=?";
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

	@Override
	public void insertQaRep(QaRep r, int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into qarep values(?, ?, ?, sysdate)";
		r.setNum(num);
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getNum());
			pstmt.setString(2, r.getWriter());
			pstmt.setString(3, r.getContent());
			pstmt.executeUpdate();
			discon();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<QaRep> qarepAll(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from qarep where num=?";
		ResultSet rs = null;
		ArrayList<QaRep> r = new ArrayList<QaRep>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				r.add(new QaRep(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
			}
			discon();
		}catch(SQLException e){
		e.printStackTrace();
		}
		return r;	
	}
}
