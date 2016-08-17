package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class ReservDaoImpl implements ReservDao{
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;
	
	public ReservDaoImpl(DataSource dataSource) {	
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
	public void insert(Reservation r) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into reservation values(seq_reserv.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getMovie());
			pstmt.setString(2, r.getUserid());
			pstmt.setString(3, r.getTheater());
			pstmt.setString(4, r.getReservday());
			pstmt.setString(5, r.getRunning());
			pstmt.setString(6, r.getPeople());
			pstmt.setString(7, r.getSeat());
			pstmt.setString(8, r.getPay());
			
			pstmt.executeUpdate();
			discon();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reservation> select(String userid) {
		// TODO Auto-generated method stub
		con();
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String sql = "select * from reservation where userid=?";
		
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reservation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
