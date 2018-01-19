package market;

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




public class marketDBBean {
	
private static marketDBBean instance = new marketDBBean();
	
	public static marketDBBean getInstance() {
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
			String sql = "select count(*) from HKK_market_write"; // 테이블에 count(*)열 만들어 목록수 반환
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
	
	public int getIdCount(String m_id) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_market_write where m_id=?"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, m_id);
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
	
	public int getTiCount(String m_title) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_market_write where m_title like '%' || ? || '%'"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, m_title);
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
	
	public ArrayList<HKK_market_write> getArticles(int start, int end) {
		ArrayList<HKK_market_write> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select m_connum, m_title, m_reg_date, m_readcount, m_id, r";
			sql+= " from (select m_connum, m_title, m_reg_date, m_readcount, m_id, rownum r from ";
			sql+= "(select m_connum, m_title, m_reg_date, m_readcount, m_id";
			sql+= " from HKK_market_write order by m_connum desc) ";
			sql+= "order by m_connum desc) where r >= ? and r <= ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_market_write>();
				do{
				HKK_market_write MarketDto = new HKK_market_write();
				MarketDto.setM_connum(rs.getInt("m_connum"));
				MarketDto.setM_title(rs.getString("m_title"));
				MarketDto.setM_reg_date(rs.getTimestamp("m_reg_date"));
				MarketDto.setM_readcount(rs.getInt("m_readcount"));
				MarketDto.setM_id(rs.getString("m_id"));
				articles.add(MarketDto);
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
	
	public ArrayList<HKK_market_write> getIdArticles(int start, int end, String m_id) {
		ArrayList<HKK_market_write> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select m_connum, m_title, m_reg_date, m_readcount, m_id, r";
			sql+= " from (select m_connum, m_title, m_reg_date, m_readcount, m_id, rownum r from ";
			sql+= "(select m_connum, m_title, m_reg_date, m_readcount, m_id";
			sql+= " from HKK_market_write where m_id=? order by m_connum desc) ";
			sql+= "where m_id=? order by m_connum desc) where r >= ? and r <= ? and m_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_id);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			pstmt.setString(5, m_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_market_write>();
				do{
				HKK_market_write MarketDto = new HKK_market_write();
				MarketDto.setM_connum(rs.getInt("m_connum"));
				MarketDto.setM_title(rs.getString("m_title"));
				MarketDto.setM_reg_date(rs.getTimestamp("m_reg_date"));
				MarketDto.setM_readcount(rs.getInt("m_readcount"));
				MarketDto.setM_id(rs.getString("m_id"));
				articles.add(MarketDto);
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
	
	public ArrayList<HKK_market_write> getTiArticles(int start, int end, String m_title) {
		ArrayList<HKK_market_write> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select m_connum, m_title, m_reg_date, m_readcount, m_id, r";
			sql+= " from (select m_connum, m_title, m_reg_date, m_readcount, m_id, rownum r from ";
			sql+= "(select m_connum, m_title, m_reg_date, m_readcount, m_id";
			sql+= " from HKK_market_write where m_title LIKE '%' || ? || '%' order by m_connum desc) ";
			sql+= "order by m_connum desc) where r >= ? and r <= ?";
			
			System.out.println(m_title+start+"스타트"+end+"앤드"+"메서드 타이틀");
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, m_title);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_market_write>();
				do{
				HKK_market_write MarketDto = new HKK_market_write();
				MarketDto.setM_connum(rs.getInt("m_connum"));
				MarketDto.setM_title(rs.getString("m_title"));
				MarketDto.setM_reg_date(rs.getTimestamp("m_reg_date"));
				MarketDto.setM_readcount(rs.getInt("m_readcount"));
				MarketDto.setM_id(rs.getString("m_id"));
				articles.add(MarketDto);
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
	
	public int insertArticle(HKK_market_write MarketDto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			sql = "insert into HKK_market_write(m_connum, m_title, m_reg_date, m_id) "
				  +"values(market_connum_seq.NEXTVAL,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, MarketDto.getM_title());
			pstmt.setTimestamp(2, MarketDto.getM_reg_date());
			pstmt.setString(3, MarketDto.getM_id());
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
	
	public int insertArticle(HKK_marketcontent MKContentDto) {
		int check = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			sql = "insert into HKK_marketcontent "
				  +"values(market_listnum_seq.NEXTVAL,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, MKContentDto.getM_content());
			pstmt.setString(2, MKContentDto.getM_image_path());
			pstmt.setInt(3, MKContentDto.getM_c_connum());

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
	
	
	public ArrayList<HKK_marketcontent> getArticle(int m_connum) {
		ArrayList<HKK_marketcontent> MKCon = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_marketcontent where m_c_connum=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MKCon = new ArrayList<HKK_marketcontent>();
				do{
				HKK_marketcontent MKcontentDto = new HKK_marketcontent();
				MKcontentDto.setM_listnum(rs.getInt("m_listnum"));
				MKcontentDto.setM_content(rs.getString("m_content"));
				MKcontentDto.setM_image_path(rs.getString("m_image_path"));
				MKCon.add(MKcontentDto);
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
		return MKCon;
	}
	
	public HKK_marketcontent getImg(int m_connum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HKK_marketcontent MKcontentDto = new HKK_marketcontent();
		try {
			con = getConnection();
			String sql = "select m_image_path from HKK_marketcontent where m_c_connum=?";
			sql += "and m_listnum=(select min(m_listnum) from HKK_marketcontent where m_c_connum=?)";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			pstmt.setInt(2, m_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do{
					MKcontentDto.setM_image_path(rs.getString("m_image_path"));
					System.out.println(rs.getString("m_image_path")+"이미지경로");
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
		return MKcontentDto;
	}
	
	public HKK_market_write getarticle(int m_connum) {
		HKK_market_write MarketDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_market_write where m_connum=?"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MarketDto = new HKK_market_write();
				MarketDto.setM_id(rs.getString("m_id"));
				MarketDto.setM_readcount(rs.getInt("m_readcount"));
				MarketDto.setM_reg_date(rs.getTimestamp("m_reg_date"));
				MarketDto.setM_title(rs.getString("m_title"));
				MarketDto.setM_connum(rs.getInt("m_connum"));
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
		return MarketDto;
	}
	
	public void addCount(int m_connum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update HKK_market_write set m_readcount=m_readcount+1 where m_connum=?"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
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
	
	public int check(String m_id)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_member recom where id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("memcode")==2) {
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
	
	public int checkreply(int m_connum)
	{
		int checkreply = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_m_reply where m_r_connum=? order by m_r_reg_date desc";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
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
	
	public int deleteAticle(int m_connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_marketcontent where m_c_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			result = pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from HKK_m_reply where m_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			result = pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from HKK_market_write where m_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
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
	
	public int deleteAticle(String m_id, int m_connum) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_marketcontent where m_c_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			result = pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from HKK_m_reply where m_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			result = pstmt.executeUpdate();
			pstmt.close();
			sql = "delete from HKK_market_write where m_connum=? and m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			pstmt.setString(2, m_id);
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
	
	public int getconnum(HKK_market_write MarketDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcheck = 0;
		try {
			con = getConnection();
			String sql = "select * from HKK_market_write where m_id=? and m_title=? order by m_reg_date desc"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, MarketDto.getM_id());
			pstmt.setString(2, MarketDto.getM_title());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultcheck = rs.getInt("m_connum");
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
	
	public int insertHanKKI(HKK_m_reply MKReDto){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			
			String sql = null;
			
			sql = "insert into HKK_m_reply(m_r_renum, m_r_recontent, m_r_reg_date, m_r_id, m_r_connum)"
				+ " values(market_renum_seq.NEXTVAL,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, MKReDto.getM_r_recontent());
			pstmt.setTimestamp(2, MKReDto.getM_r_reg_date());
			pstmt.setString(3, MKReDto.getM_r_id());
			pstmt.setInt(4,MKReDto.getM_r_connum());
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
	
	public ArrayList<HKK_m_reply> getRecomReply(int m_connum){
		ArrayList<HKK_m_reply> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_m_reply where m_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articles = new ArrayList<HKK_m_reply>();
				do{
					HKK_m_reply MKReDto = new HKK_m_reply();
					
					MKReDto.setM_r_id(rs.getString("m_r_id"));
					MKReDto.setM_r_recontent(rs.getString("m_r_recontent"));
					MKReDto.setM_r_reg_date(rs.getTimestamp("m_r_reg_date"));
					MKReDto.setM_r_renum(rs.getInt("m_r_renum"));
					
					articles.add(MKReDto);
					
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
	
	public int RecomReDel(int m_connum, String m_id, int m_r_renum) {
		int replydel = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_m_reply where m_r_connum=? and m_r_id=? and m_r_renum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_connum);
			pstmt.setString(2, m_id);
			pstmt.setInt(3, m_r_renum);
			System.out.println(m_connum+m_id+m_r_renum+"디비빈");
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
