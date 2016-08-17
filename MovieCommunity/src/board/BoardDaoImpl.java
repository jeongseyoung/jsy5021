package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class BoardDaoImpl implements BoardDao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;


	public BoardDaoImpl(DataSource dataSource) {
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
	public void insert(Article a) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into board values(seq_board.nextval, ?, ?, ?, sysdate, ?)";
		
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
	public Article select(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from board where num=?";
		ResultSet rs = null;
		Article m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public ArrayList<Article> selectAll() {
		// TODO Auto-generated method stub
		con();
		ArrayList<Article> list = new ArrayList<Article>();
		String sql = "select * from board order by num desc";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)));
			}
			discon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Article a) {
		// TODO Auto-generated method stub
		System.out.println("dao num:"+a.getNum());
		con();
		String sql = "update board set title=?, pwd=?, board_date=sysdate, content=?  where num=?";
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
		String sql = "delete board where num=?";
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
	public void insertRep(Rep r, int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into rep values(?, ?, ?, sysdate)";
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
	public ArrayList<Rep> repAll(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from rep where num=? order by rep_date";
		ResultSet rs = null;
		ArrayList<Rep> r = new ArrayList<Rep>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				r.add(new Rep(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
			}
			discon();
		}catch(SQLException e){
		e.printStackTrace();
		}
		return r;	
	}

	@Override
	public int totalContents() throws SQLException{
		// TODO Auto-generated method stub
		con();
		ResultSet rs=null;		
		PreparedStatement pstmt=null;		
		int totalContents=0;
		try{		
			String sql="select count(*) from board";			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				totalContents=rs.getInt(1);
			}		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return totalContents;
	}

	@Override
	public ArrayList<Article> getContentsList(int nowPage) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		ArrayList<Article> list=new ArrayList<Article>();
		try{			
			String sql="select num, writer ,pwd, title, board_date, content from(select num, writer ,pwd, title, board_date, content, page from (select num, writer ,pwd, title, board_date, content, rownum as row_num,ceil(rownum/?) as page from board) order by num desc) where page=? order by num DESC";
			//String sql1="select num, writer ,pwd, title, board_date, content from (select num, writer ,pwd, title, board_date, content, rownum from (select num, writer ,pwd, title, board_date, content from board order by num) where 1=1) where rownum >= ? and rownum <= ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			pstmt.setInt(2, nowPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;	
	}

}
