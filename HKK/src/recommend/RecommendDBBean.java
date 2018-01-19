package recommend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class RecommendDBBean {
	
private static RecommendDBBean instance = new RecommendDBBean();
	
	public static RecommendDBBean getInstance() {
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
			String sql = "select count(*) from HKK_recommend"; // 테이블에 count(*)열 만들어 목록수 반환
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
	
	public int getIdCount(String r_id) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_recommend where r_id=?"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, r_id);
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
	
	public int getTiCount(String r_title) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_recommend where r_title like '%' || ? || '%'"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, r_title);
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
	
	public ArrayList<RecommendDataBean> getArticles(int start, int end) {
		ArrayList<RecommendDataBean> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select r_connum, r_title, r_reg_date, r_readcount, r_id, r";
			sql+= " from (select r_connum, r_title, r_reg_date, r_readcount, r_id, rownum r from ";
			sql+= "(select r_connum, r_title, r_reg_date, r_readcount, r_id";
			sql+= " from HKK_recommend order by r_connum desc) ";
			sql+= "order by r_connum desc) where r >= ? and r <= ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<RecommendDataBean>();
				do{
				RecommendDataBean RecomDto = new RecommendDataBean();
				RecomDto.setR_connum(rs.getInt("r_connum"));
				RecomDto.setR_title(rs.getString("r_title"));
				RecomDto.setR_reg_date(rs.getTimestamp("r_reg_date"));
				RecomDto.setR_readcount(rs.getInt("r_readcount"));
				RecomDto.setR_id(rs.getString("r_id"));
				articles.add(RecomDto);
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
	
	public ArrayList<RecommendDataBean> getIdArticles(int start, int end, String id) {
		ArrayList<RecommendDataBean> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select r_connum, r_title, r_reg_date, r_readcount, r_id, r";
			sql+= " from (select r_connum, r_title, r_reg_date, r_readcount, r_id, rownum r from ";
			sql+= "(select r_connum, r_title, r_reg_date, r_readcount, r_id";
			sql+= " from HKK_recommend where r_id=? order by r_connum desc) ";
			sql+= "where r_id=? order by r_connum desc) where r >= ? and r <= ? and r_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			pstmt.setString(5, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<RecommendDataBean>();
				do{
				RecommendDataBean RecomDto = new RecommendDataBean();
				RecomDto.setR_connum(rs.getInt("r_connum"));
				RecomDto.setR_title(rs.getString("r_title"));
				RecomDto.setR_reg_date(rs.getTimestamp("r_reg_date"));
				RecomDto.setR_readcount(rs.getInt("r_readcount"));
				RecomDto.setR_id(rs.getString("r_id"));
				articles.add(RecomDto);
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
	
	public ArrayList<RecommendDataBean> getTiArticles(int start, int end, String title) {
		ArrayList<RecommendDataBean> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select r_connum, r_title, r_reg_date, r_readcount, r_id, r";
			sql+= " from (select r_connum, r_title, r_reg_date, r_readcount, r_id, rownum r from ";
			sql+= "(select r_connum, r_title, r_reg_date, r_readcount, r_id";
			sql+= " from HKK_recommend where r_title LIKE '%' || ? || '%' order by r_connum desc) ";
			sql+= "order by r_connum desc) where r >= ? and r <= ?";
			
			System.out.println(title+"메서드 타이틀");
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<RecommendDataBean>();
				do{
				RecommendDataBean RecomDto = new RecommendDataBean();
				RecomDto.setR_connum(rs.getInt("r_connum"));
				RecomDto.setR_title(rs.getString("r_title"));
				RecomDto.setR_reg_date(rs.getTimestamp("r_reg_date"));
				RecomDto.setR_readcount(rs.getInt("r_readcount"));
				RecomDto.setR_id(rs.getString("r_id"));
				articles.add(RecomDto);
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
	
	public int insertArticle(RecommendDataBean RecomDto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			sql = "insert into HKK_recommend(r_connum, r_title, r_reg_date, r_id) "
				  +"values(Recom_connum_seq.NEXTVAL,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, RecomDto.getR_title());
			pstmt.setTimestamp(2, RecomDto.getR_reg_date());
			pstmt.setString(3, RecomDto.getR_id());
			pstmt.executeUpdate();
			result = 1;
			
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
	
	public int insertArticle(HKK_recommendcontent RecomContentDto) {
		int check = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			sql = "insert into HKK_recommendcontent "
				  +"values(Recom_listnum_seq.NEXTVAL,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, RecomContentDto.getR_content());
			pstmt.setString(2, RecomContentDto.getR_image_path());
			pstmt.setInt(3, RecomContentDto.getR_c_connum());

			check = pstmt.executeUpdate();
			
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
		return check;
	}
	
	
	public ArrayList<HKK_recommendcontent> getArticle(int r_connum) {
		ArrayList<HKK_recommendcontent> RecomCon = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_recommendcontent where r_c_connum=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				RecomCon = new ArrayList<HKK_recommendcontent>();
				do{
				HKK_recommendcontent RecomContentDto = new HKK_recommendcontent();
				RecomContentDto.setR_listnum(rs.getInt("r_listnum"));
				RecomContentDto.setR_content(rs.getString("r_content"));
				RecomContentDto.setR_image_path(rs.getString("r_image_path"));
				RecomCon.add(RecomContentDto);
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
		return RecomCon;
	}
	
	public HKK_recommendcontent getImg(int r_connum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HKK_recommendcontent RecomContentDto = new HKK_recommendcontent();
		try {
			con = getConnection();
			String sql = "select r_image_path from HKK_recommendcontent where r_c_connum=?";
			sql += "and r_listnum=(select min(r_listnum) from HKK_recommendcontent where r_c_connum=?)";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			pstmt.setInt(2, r_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do{
					RecomContentDto.setR_image_path(rs.getString("r_image_path"));
					System.out.println(rs.getString("r_image_path")+"이미지경로");
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
		return RecomContentDto;
	}
	
	public RecommendDataBean getarticle(int r_connum) {
		RecommendDataBean RecomDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_recommend where r_connum=?"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				RecomDto = new RecommendDataBean();
				RecomDto.setR_id(rs.getString("r_id"));
				RecomDto.setR_readcount(rs.getInt("r_readcount"));
				RecomDto.setR_reg_date(rs.getTimestamp("r_reg_date"));
				RecomDto.setR_title(rs.getString("r_title"));
				RecomDto.setR_connum(rs.getInt("r_connum"));
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
		return RecomDto;
	}
	
	public void addCount(int r_connum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update HKK_recommend set r_readcount=r_readcount+1 where r_connum=?"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			pstmt.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int check(String r_id)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_member where id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, r_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("memcode")==3) {
					result = 1;
				}
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
		return result;
	}
	
	public int checkreply(int r_connum)
	{
		int checkreply = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_r_reply where r_r_connum=? order by r_r_reg_date desc";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
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
	
	public int deleteAticle(String r_id, int r_connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_recommendcontent where r_c_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			result = pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from HKK_r_reply where r_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			result = pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from HKK_recommend where r_connum=? and r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			pstmt.setString(2, r_id);
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
	
	public int getconnum(RecommendDataBean RecomDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcheck = 0;
		try {
			con = getConnection();
			String sql = "select * from HKK_recommend where r_id=? and r_title=? order by r_reg_date desc"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, RecomDto.getR_id());
			pstmt.setString(2, RecomDto.getR_title());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultcheck = rs.getInt("r_connum");
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
		return resultcheck;
	}
	
	public int insertHanKKI(HKK_r_reply RecomReDto){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			
			String sql = null;
			
			sql = "insert into HKK_r_reply(r_r_renum, r_r_recontent, r_r_reg_date, r_r_id, r_r_connum)"
				+ " values(recom_renum_seq.NEXTVAL,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, RecomReDto.getR_r_recontent());
			pstmt.setTimestamp(2, RecomReDto.getR_r_reg_date());
			pstmt.setString(3, RecomReDto.getR_r_id());
			pstmt.setInt(4,RecomReDto.getR_r_connum());
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
	
	public ArrayList<HKK_r_reply> getRecomReply(int r_connum){
		ArrayList<HKK_r_reply> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_r_reply where r_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articles = new ArrayList<HKK_r_reply>();
				do{
					HKK_r_reply RecomReDto = new HKK_r_reply();
					
					RecomReDto.setR_r_id(rs.getString("r_r_id"));
					RecomReDto.setR_r_recontent(rs.getString("r_r_recontent"));
					RecomReDto.setR_r_reg_date(rs.getTimestamp("r_r_reg_date"));
					RecomReDto.setR_r_renum(rs.getInt("r_r_renum"));
					
					articles.add(RecomReDto);
					
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
	
	public int RecomReDel(int r_connum, String r_id, int r_r_renum) {
		int replydel = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_r_reply where r_r_connum=? and r_r_id=? and r_r_renum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_connum);
			pstmt.setString(2, r_id);
			pstmt.setInt(3, r_r_renum);
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
