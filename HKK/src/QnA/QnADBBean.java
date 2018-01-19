package QnA;

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
import recommend.HKK_recommendcontent;
import recommend.RecommendDataBean;
import scrap.scrapDBBean;

public class QnADBBean {
	private static QnADBBean instance = new QnADBBean();
	
	public static QnADBBean getInstance() {
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
			String sql = "select count(*) from HKK_qna"; // 테이블에 count(*)열 만들어 목록수 반환
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
	
	public int getIdCount(String q_id) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_qna where q_id=?"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, q_id);
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
	
	public int getTiCount(String q_title) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from HKK_qna where q_title like '%' || ? || '%'"; // 테이블에 count(*)열 만들어 목록수 반환
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, q_title);
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
	
	public ArrayList<HKK_qna> getArticles(int start, int end) {
		ArrayList<HKK_qna> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select q_connum, q_title, q_pw, q_content, q_reg_date, q_id, r";
			sql+= " from (select q_connum, q_title, q_pw, q_content, q_reg_date, q_id, rownum r from ";
			sql+= "(select q_connum, q_title, q_pw, q_content, q_reg_date, q_id";
			sql+= " from HKK_qna order by q_connum desc) ";
			sql+= "order by q_connum desc) where r >= ? and r <= ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_qna>();
				do{
				HKK_qna QnADto = new HKK_qna();
				QnADto.setQ_connum(rs.getInt("q_connum"));
				QnADto.setQ_title(rs.getString("q_title"));
				QnADto.setQ_pw(rs.getString("q_pw"));
				QnADto.setQ_content(rs.getString("q_content"));
				QnADto.setQ_reg_date(rs.getTimestamp("q_reg_date"));
				QnADto.setQ_id(rs.getString("q_id"));
				articles.add(QnADto);
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
	
	public ArrayList<HKK_qna> getIdArticles(int start, int end, String id) {
		ArrayList<HKK_qna> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select q_connum, q_title, q_pw, q_content, q_reg_date, q_id, r";
			sql+= " from (select q_connum, q_title, q_pw, q_content, q_reg_date, q_id, rownum r from ";
			sql+= "(select q_connum, q_title, q_pw, q_content, q_reg_date, q_id";
			sql+= " from HKK_qna where q_id=? order by q_connum desc) ";
			sql+= "where q_id=? order by q_connum desc) where r >= ? and r <= ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_qna>();
				do{
				HKK_qna QnADto = new HKK_qna();
				QnADto.setQ_connum(rs.getInt("q_connum"));
				QnADto.setQ_title(rs.getString("q_title"));
				QnADto.setQ_pw(rs.getString("q_pw"));
				QnADto.setQ_content(rs.getString("q_content"));
				QnADto.setQ_reg_date(rs.getTimestamp("q_reg_date"));
				QnADto.setQ_id(rs.getString("q_id"));
				articles.add(QnADto);
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
	
	public ArrayList<HKK_qna> getTiArticles(int start, int end, String title) {
		ArrayList<HKK_qna> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select q_connum, q_title, q_pw, q_content, q_reg_date, q_id, r";
			sql+= " from (select q_connum, q_title, q_pw, q_content, q_reg_date, q_id, rownum r from ";
			sql+= "(select q_connum, q_title, q_pw, q_content, q_reg_date, q_id";
			sql+= " from HKK_qna where q_title LIKE '%' || ? || '%' order by q_connum desc) ";
			sql+= "order by q_connum desc) where r >= ? and r <= ?";
			
			System.out.println(title+"메서드 타이틀");
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articles = new ArrayList<HKK_qna>();
				do{
				HKK_qna QnADto = new HKK_qna();
				QnADto.setQ_connum(rs.getInt("q_connum"));
				QnADto.setQ_title(rs.getString("q_title"));
				QnADto.setQ_pw(rs.getString("q_pw"));
				QnADto.setQ_content(rs.getString("q_content"));
				QnADto.setQ_reg_date(rs.getTimestamp("r_reg_date"));
				QnADto.setQ_id(rs.getString("r_id"));
				articles.add(QnADto);
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
	
	public int insertArticle(HKK_qna QnADto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = null;
			sql = "insert into HKK_qna(q_connum, q_title, q_pw, q_content, q_reg_date, q_id)"
				  +"values(qna_connum_seq.NEXTVAL,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, QnADto.getQ_title());
			pstmt.setString(2, QnADto.getQ_pw());
			pstmt.setString(3, QnADto.getQ_content());
			pstmt.setTimestamp(4, QnADto.getQ_reg_date());
			pstmt.setString(5, QnADto.getQ_id());
			pstmt.executeUpdate();
			result = 1;
			System.out.println(result+"결과1");
			
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
	
	public int getpwart(String q_pw, int q_connum, String q_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultcheck = 0;
		try {
			con = getConnection();
			String sql = "select * from HKK_qna where q_id=? and q_connum=?"; 
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, q_id);
			pstmt.setInt(2, q_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("q_pw").equals(q_pw)) {
					resultcheck = 1;
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
		return resultcheck;
	}
	
	public HKK_qna getArticle(int q_connum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HKK_qna QnADto = new HKK_qna();
		try {
			con = getConnection();
			String sql = "select * from HKK_qna where q_connum=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, q_connum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do{
				QnADto.setQ_connum(rs.getInt("q_connum"));
				QnADto.setQ_title(rs.getString("q_title"));
				QnADto.setQ_pw(rs.getString("q_pw"));
				QnADto.setQ_content(rs.getString("q_content"));
				QnADto.setQ_reg_date(rs.getTimestamp("q_reg_date"));
				QnADto.setQ_id(rs.getString("q_id"));
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
		return QnADto;
	}
	
	public int checkreply(int q_connum)
	{
		int checkreply = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_q_reply where q_r_connum=? order by q_r_reg_date desc";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, q_connum);
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
	
	public ArrayList<HKK_q_reply> getRecomReply(int q_connum){
		ArrayList<HKK_q_reply> articles = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_q_reply where q_r_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_connum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articles = new ArrayList<HKK_q_reply>();
				do{
					HKK_q_reply QnAReDto = new HKK_q_reply();
					
					QnAReDto.setQ_renum(rs.getInt("q_renum"));
					QnAReDto.setQ_r_id(rs.getString("q_r_id"));
					QnAReDto.setQ_recontent(rs.getString("q_recontent"));
					QnAReDto.setQ_r_reg_date(rs.getTimestamp("q_r_reg_date"));
					QnAReDto.setQ_r_connum(rs.getInt("q_r_connum"));
					articles.add(QnAReDto);
					
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
	
	public int check(String q_id)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_member where id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, q_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("memcode")!=3) {
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
	
	public int deleteAticle(int q_connum, String q_pw) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from HKK_qna where q_connum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_connum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("q_pw").equals(q_pw)){
				sql = "delete from HKK_q_reply where q_q_connum=?";
				pstmt.setInt(1, q_connum);
				pstmt.executeUpdate();
				pstmt.close();
				sql = "delete from HKK_qna where q_connum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, q_connum);
				result = pstmt.executeUpdate();
				}
			}
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
	
	public int insertHanKKI(HKK_q_reply QnAReDto){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			
			String sql = null;
			
			sql = "insert into HKK_q_reply(q_renum, q_recontent, q_r_reg_date, q_r_id, q_r_connum)"
				+ " values(qna_renum_seq.NEXTVAL,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, QnAReDto.getQ_recontent());
			pstmt.setTimestamp(2, QnAReDto.getQ_r_reg_date());
			pstmt.setString(3, QnAReDto.getQ_r_id());
			pstmt.setInt(4,QnAReDto.getQ_r_connum());
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
	
	public int RecomReDel(int q_connum, String q_r_id, int q_renum) {
		int replydel = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from HKK_q_reply where q_r_connum=? and q_r_id=? and q_renum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_connum);
			pstmt.setString(2, q_r_id);
			pstmt.setInt(3, q_renum);
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
