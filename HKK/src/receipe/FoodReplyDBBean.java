package receipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import recommend.HKK_r_reply;

public class FoodReplyDBBean {
	private static FoodReplyDBBean instance = new FoodReplyDBBean();
	public static FoodReplyDBBean getInstance()
	{
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException
	{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/kh");
		return ds.getConnection();
	}
	
	public int delete(int connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "delete from hkk_f_reply where food_r_connum=?";
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
	
	public int insertHanKKI(FoodReplyDataBean FoReDto){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			
			String sql = null;
			
			sql = "insert into HKK_f_reply(food_renum, food_r_code, food_recontent, food_r_reg_date, food_r_id, food_r_connum)"
				+ " values(food_renum_seq.NEXTVAL,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, FoReDto.getFood_r_code());
			pstmt.setString(2, FoReDto.getFood_recontent());
			pstmt.setTimestamp(3, FoReDto.getFood_r_reg_date());
			pstmt.setString(4, FoReDto.getFood_r_id());
			pstmt.setInt(5,FoReDto.getFood_r_connum());
			result = pstmt.executeUpdate();
		
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs != null)pstmt.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
		}
		return result;
	}
	
	public int checkreply(int food_r_connum)
	{
		int checkreply = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_f_reply where food_r_connum=? order by food_r_reg_date desc";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, food_r_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkreply = 1;
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
		return checkreply;
	}
	
	public ArrayList<FoodReplyDataBean> getRecomReply(int food_r_connum){
		ArrayList<FoodReplyDataBean> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_f_reply where food_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_r_connum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articles = new ArrayList<FoodReplyDataBean>();
				do{
					FoodReplyDataBean FoReDto = new FoodReplyDataBean();
					
					FoReDto.setFood_r_id(rs.getString("Food_r_id"));
					FoReDto.setFood_recontent(rs.getString("Food_recontent"));
					FoReDto.setFood_r_reg_date(rs.getTimestamp("Food_r_reg_date"));
					FoReDto.setFood_renum(rs.getInt("food_renum"));
					FoReDto.setFood_r_code(rs.getInt("food_r_code"));
					FoReDto.setFood_r_connum(rs.getInt("food_r_connum"));
					
					articles.add(FoReDto);
					
				}while(rs.next());
				
			}	
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs != null) pstmt.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
		}
		return articles;
	}
	
	public int RecomReDel(int food_r_connum, String r_id, int food_renum, int food_r_code) {
		int replydel = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_f_reply where food_r_connum=? and food_r_id=? and food_r_code=? and food_renum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_r_connum);
			pstmt.setString(2, r_id);
			pstmt.setInt(3, food_r_code);
			pstmt.setInt(4, food_renum);
			replydel = pstmt.executeUpdate();
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
		return replydel;
	}
}
