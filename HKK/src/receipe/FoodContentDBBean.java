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

public class FoodContentDBBean {
	private static FoodContentDBBean instance = new FoodContentDBBean();
	public static FoodContentDBBean getInstance()
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
	
	public int insertArticle(FoodContentDataBean contentDto){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "insert into HKK_foodcontent values(foodcontent_seq.NEXTVAL,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, contentDto.getFood_content());
			pstmt.setString(2, contentDto.getFood_image_path());
			pstmt.setString(3, contentDto.getFood_video_path());
			pstmt.setInt(4, contentDto.getFood_c_connum());
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
	
	public String getPath(int connum){
		String path = null;
		FoodWriteDataBean writeDto = new FoodWriteDataBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select food_image_path from HKK_foodcontent where food_c_connum=? order by food_listnum asc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, connum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				path = rs.getString(1);
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
		
		return path;
	}
	
	public ArrayList<FoodContentDataBean> getContent(int food_connum){
		ArrayList<FoodContentDataBean> contentlist = new ArrayList<FoodContentDataBean>();
		FoodContentDataBean contentDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			
			sql = "select * from HKK_foodcontent where food_c_connum=? order by food_listnum asc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_connum);
			
			rs = pstmt.executeQuery();

			while(rs.next()){
				contentDto = new FoodContentDataBean();
				contentDto.setFood_content(rs.getString("food_content"));
				contentDto.setFood_image_path(rs.getString("food_image_path"));
				contentDto.setFood_video_path(rs.getString("food_video_path"));
				
				contentlist.add(contentDto);
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
		return contentlist;
	}
	
	public int delete(int connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = null;
			
			sql = "delete from hkk_foodcontent where food_c_connum=?";
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
