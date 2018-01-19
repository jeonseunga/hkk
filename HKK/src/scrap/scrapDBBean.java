package scrap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import recommend.RecommendDataBean;


public class scrapDBBean {
private static scrapDBBean instance = new scrapDBBean();
	
	public static scrapDBBean getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/kh");
		return ds.getConnection();
	}
	
	public int getCount() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_scrap"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int insertArticle(HKK_scrap scrapDto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			sql = "insert into HKK_scrap(s_renum, s_r_id, s_r_title, s_connum, s_img_path, s_id, s_foodcode) "
				  +"values(scrap_renum_seq.NEXTVAL,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scrapDto.getS_r_id());
			pstmt.setString(2, scrapDto.getS_r_title());
			pstmt.setInt(3, scrapDto.getS_connum());
			pstmt.setString(4, scrapDto.getS_img_path());
			pstmt.setString(5, scrapDto.getS_id());
			pstmt.setInt(6, scrapDto.getS_foodcode());
			System.out.println(scrapDto.getS_r_id()+scrapDto.getS_r_title()+scrapDto.getS_connum());
			System.out.println(scrapDto.getS_img_path()+scrapDto.getS_id());
			result = pstmt.executeUpdate();
			System.out.println(result+"결과값 출력");
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<HKK_scrap> getArticles(int start, int end, String s_id) {
		ArrayList<HKK_scrap> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select s_renum, s_r_id, s_r_title, s_connum, s_foodcode, s_img_path, s_id, r";
			sql+= " from (select s_renum, s_r_id, s_r_title, s_connum, s_foodcode, s_img_path, s_id, rownum r from ";
			sql+= "(select s_renum, s_r_id, s_r_title, s_connum, s_foodcode, s_img_path, s_id";
			sql+= " from HKK_scrap order by s_renum desc) ";
			sql+= "order by s_renum desc) where s_id = ? and r >= ? and r <= ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_scrap>();
				do{
				HKK_scrap scrapDto = new HKK_scrap();
				scrapDto.setS_connum(rs.getInt("s_connum"));
				scrapDto.setS_renum(rs.getInt("s_renum"));
				scrapDto.setS_r_title(rs.getString("s_r_title"));
				scrapDto.setS_img_path(rs.getString("s_img_path"));
				scrapDto.setS_r_id(rs.getString("s_r_id"));
				scrapDto.setS_foodcode(rs.getInt("s_foodcode"));
				articles.add(scrapDto);
				} while (rs.next());
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return articles;
	}
	
	public int deleteAticle(int s_renum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_scrap where s_renum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_renum);
			result = pstmt.executeUpdate();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int delete(int connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = getConnection();
			String sql = null;
			
			sql = "delete from HKK_scrap where s_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, connum);
			result = pstmt.executeUpdate();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
