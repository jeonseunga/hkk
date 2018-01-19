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

import recommend.HKK_recommendcontent;
import recommend.RecommendDataBean;

public class FoodWriteDBBean {
	private static FoodWriteDBBean instance = new FoodWriteDBBean();
	public static FoodWriteDBBean getInstance()
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
	
	public int insertArticle(FoodWriteDataBean writeDto){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "insert into HKK_food_write values(food_write_seq.NEXTVAL,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writeDto.getFood_title());
			pstmt.setTimestamp(2, writeDto.getFood_reg_date());
			pstmt.setInt(3, writeDto.getFood_readcount());
			pstmt.setString(4, writeDto.getFood_id());
			pstmt.setInt(5, writeDto.getFood_code());

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
	
	public int getArticle(FoodWriteDataBean writeDto){
		int resultCheck = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select food_connum from HKK_food_write where food_id=? and food_title=? order by food_reg_date desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writeDto.getFood_id());
			pstmt.setString(2, writeDto.getFood_title());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				resultCheck = rs.getInt(1);
			}
			
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
		
		return resultCheck;
	}

	public ArrayList<FoodWriteDataBean> getList(int foodcode){
		ArrayList<FoodWriteDataBean> arr = new ArrayList<FoodWriteDataBean>();
		FoodWriteDataBean writeDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select * from hkk_food_write where food_code=? order by food_connum desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, foodcode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				writeDto = new FoodWriteDataBean();
				writeDto.setFood_id(rs.getString("food_id"));
				writeDto.setFood_title(rs.getString("food_title"));
				writeDto.setFood_connum(rs.getInt("food_connum"));
				
				arr.add(writeDto);
			}
			
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
		
		return arr;
	}
	
	public ArrayList<FoodWriteDataBean> getSearchList(String search,String serch,int foodcode){
		ArrayList<FoodWriteDataBean> arr = new ArrayList<FoodWriteDataBean>();
		FoodWriteDataBean writeDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			if(search.equals("id")) {
				sql = "select * from hkk_food_write where food_code=? and food_id=(select id from hkk_member where id=?) order by food_connum desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, foodcode);
				pstmt.setString(2, serch);
			}else if(search.equals("title")) {
				sql = "select * from hkk_food_write where food_code=? and food_title like '%'||?||'%' order by food_connum desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, foodcode);
			//	String ser = "%" + serch + "%";
				pstmt.setString(2, serch);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				writeDto = new FoodWriteDataBean();
				writeDto.setFood_id(rs.getString("food_id"));
				writeDto.setFood_title(rs.getString("food_title"));
				writeDto.setFood_connum(rs.getInt("food_connum"));
				
				arr.add(writeDto);
			}
			
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
		
		return arr;
	}
	
	public FoodWriteDataBean getArticle(int food_connum){
		FoodWriteDataBean writeDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select * from HKK_food_write where food_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_connum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				writeDto = new FoodWriteDataBean();
				
				writeDto.setFood_title(rs.getString("food_title"));
				writeDto.setFood_reg_date(rs.getTimestamp("food_reg_date"));
				writeDto.setFood_readcount(rs.getInt("food_readcount"));
				writeDto.setFood_code(rs.getInt("food_code"));
				writeDto.setFood_id(rs.getString("food_id"));
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return writeDto;
	}
	
	public ArrayList<FoodWriteDataBean> getMainList(int foodcode){
		ArrayList<FoodWriteDataBean> arr = new ArrayList<FoodWriteDataBean>();
		FoodWriteDataBean writeDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select * from hkk_food_write where food_code=? order by food_connum desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, foodcode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				writeDto = new FoodWriteDataBean();
				writeDto.setFood_id(rs.getString("food_id"));
				writeDto.setFood_title(rs.getString("food_title"));
				writeDto.setFood_connum(rs.getInt("food_connum"));
				
				arr.add(writeDto);
				count++;
				if(count == 3){
					break;
				}
			}
			
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
		
		return arr;
	}
	
	public int delete(int connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "delete from hkk_food_write where food_connum=?";
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
	
	public int check(String id, int connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select * from hkk_food_write where food_connum=? and food_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, connum);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else{
				result = -1;
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public ArrayList<FoodWriteDataBean> getArticles(int foodcode, int start, int end) {
	      ArrayList<FoodWriteDataBean> articles = new ArrayList<FoodWriteDataBean>();;
	      FoodWriteDataBean writeDto = null;
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         con = getConnection();
	         String sql = "select food_connum, food_title, food_reg_date, food_readcount, food_id, food_code, r";
	         sql+= " from (select food_connum, food_title, food_reg_date, food_readcount, food_id, food_code , rownum r from ";
	         sql+= "(select food_connum, food_title, food_reg_date, food_readcount, food_id, food_code from  HKK_food_write order by food_connum desc) ";
	         sql+= "order by food_connum desc) where r >= ? and r <= ?+1 and food_code=? ";
	         pstmt= con.prepareStatement(sql);
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         pstmt.setInt(3, foodcode);
	         rs = pstmt.executeQuery();

	         while(rs.next()){
	            writeDto = new FoodWriteDataBean();
	            writeDto.setFood_connum(rs.getInt("food_connum"));
	            writeDto.setFood_title(rs.getString("food_title"));
	            writeDto.setFood_reg_date(rs.getTimestamp("food_reg_date"));
	            writeDto.setFood_readcount(rs.getInt("food_readcount"));
	            writeDto.setFood_id(rs.getString("food_id"));
	            writeDto.setFood_code(rs.getInt("food_code"));
	            articles.add(writeDto);
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
	
	public int getCount(int foodcode) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_food_write where food_code=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, foodcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}else{
				count = 0;
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
}
