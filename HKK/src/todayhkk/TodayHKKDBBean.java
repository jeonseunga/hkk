package todayhkk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class TodayHKKDBBean {
	private static TodayHKKDBBean instance = new TodayHKKDBBean();
	public static TodayHKKDBBean getInstance()
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
	
	public int getCount(){
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_todayhkk";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt( 1 );
			}
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
		System.out.println(count);
		return count;
		
	}
	//id검색할때 count
	public int getsearch_Count(String search_id){
		int search_count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_todayhkk where t_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				search_count = rs.getInt( 1 );
			}
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
		System.out.println(search_count);
		return search_count;
		
	}
	
	public ArrayList<TodayHKKDataBean> getHanKKi(String t_reg_date){
		ArrayList<TodayHKKDataBean> articles = new ArrayList<TodayHKKDataBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try { 
			con = getConnection();
			String sql = "select * from HKK_todayhkk where t_reg_date=? order by t_listnum desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t_reg_date);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				do{
					TodayHKKDataBean article = new TodayHKKDataBean();
					
					article.setT_id(rs.getString("t_id"));
					article.setT_content(rs.getString("t_content"));
					article.setT_reg_date(rs.getString("t_reg_date"));
					article.setT_listnum(rs.getInt("t_listnum"));
					article.setT_image_path(rs.getString("t_image_path"));
					
					articles.add(article);
					
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
	
	public ArrayList<TodayHKKDataBean> getsearchHanKKi(String search_id){
		ArrayList<TodayHKKDataBean> articles = new ArrayList<TodayHKKDataBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try { 
			con = getConnection();
			String sql = "select * from HKK_todayhkk where t_id=? order by t_listnum desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1, search_id );
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				do{
					TodayHKKDataBean article = new TodayHKKDataBean();
					
					article.setT_id(rs.getString("t_id"));
					article.setT_content(rs.getString("t_content"));
					article.setT_reg_date(rs.getString("t_reg_date"));
					article.setT_listnum(rs.getInt("t_listnum"));
					article.setT_image_path(rs.getString("t_image_path"));
					
					articles.add(article);
					
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
	
	
	public int insertHanKKI(TodayHKKDataBean todayhkkDto){
		 
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			
			sql = "insert into HKK_todayhkk values(todayhkk_seq.nextVal,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, todayhkkDto.getT_content());
			pstmt.setString(2, todayhkkDto.getT_image_path());
			pstmt.setString(3,todayhkkDto.getT_reg_date());
			pstmt.setString(4, todayhkkDto.getT_id());
			
			
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
	
	
	public int check(String session_id, int t_listnum){
		int resultcheck = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from HKK_todayhkk where t_listnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t_listnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(session_id.equals(rs.getString("t_id"))){
					
					resultcheck = 1;
				}else{
					resultcheck = 0;
				}
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs != null) pstmt.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
		
		return resultcheck;
	}
	
	public int deleteArticle_manager(int t_listnum){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "delete from HKK_todayhkk where t_listnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t_listnum);
			result = pstmt.executeUpdate();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
		
		return result;
	}
	
	public int deleteArticle(String t_id, int t_listnum){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "delete from HKK_todayhkk where t_listnum=? and t_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t_listnum);
			pstmt.setString(2, t_id);
			result = pstmt.executeUpdate();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
		
		return result;
	}
	
	
	public int checkmembercode(String id){
		int membercode = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from hkk_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				membercode = rs.getInt("memcode");
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs != null) pstmt.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}

		return membercode;
	}
	
}//
