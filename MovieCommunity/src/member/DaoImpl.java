package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class DaoImpl implements Dao {

	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;

	public DaoImpl(DataSource dataSource) {
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
	public void insert(Member m) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into membership values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());		
			pstmt.setString(3, m.getEmail());
			pstmt.executeUpdate();
			discon();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from membership where id=?";
		ResultSet rs = null;
		Member m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(rs.getString(1), rs.getString(2),
						rs.getString(3));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;

	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		con();
		String sql = "update membership set pwd=?, email=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getId());
			pstmt.executeUpdate();
			discon();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		con();
		String sql = "delete membership where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		con();
		Member m = select(id);
		if (m == null) {
			return true;
		}
		discon();
		return false;

	}

	@Override
	public ArrayList<Member> selectAll() {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from membership";
		ArrayList<Member> data = new ArrayList<Member>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new Member(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
