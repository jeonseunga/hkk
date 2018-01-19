package member;
//�뵒鍮꾩쿂由� �뼐媛� �떎 �븿

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class LogonDBBean {
	//�떛湲��넠 �쑝濡� �빐�꽌 �븿�닔 濡� �씤�뒪�꽩�뒪 �깮�꽦 紐삵븯寃� �걫 �븯湲� �쐞�빐
	private static LogonDBBean instance = new LogonDBBean();
	//媛앹껜 �뾾�씠 �젒洹� 媛��뒫�븯寃뚮걫 吏�媛� �옄湲곕�� �깮�꽦�븯�뒗�븷�엫
	public static LogonDBBean getInstance()
	{
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException
	{
		//finally �븳�뿉 �뼱李⑦뵾 �뜕�졇�빞�맖 try/catch 媛� �븘�땶 throw濡� �뜕吏�
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/kh");
		return ds.getConnection();
	}
	public int insertMember(LogonDataBean memberDto)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into hkk_member values(?, ?, ?, ?, 1)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPw());
			pstmt.setString(3, memberDto.getEmail());
			pstmt.setString(4, memberDto.getGender());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try
			{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
			}catch(SQLException e)
			{
				
			}
			
		}
		
		return result;
	}
	//以묐났�솗�씤
	public int check(String id)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from hkk_member where id=?";
	
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, id);
			   rs = pstmt.executeQuery();
			
			   
			 if (rs.next())
			{
				 result = 1;
			} else{
				 result = 0;
			}
			 
			 
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
				
			}catch(SQLException e)
			{
				
			}
			
		}
		return result;
	}
	 public int sendEmail(String to, String content){
	      int result = 0;
	      System.out.println(to + content);
	      String sResult = "OK"; 
	      //String code = "111";
	   try{ 
	      String st = to; // 받는 사람
	      String sbj = "이메일 테스트 인증번호입니다."; 
	      String sf = "jsasendtest@gmail.com"; // 보내는 사람(인증 정보와 동일한 email 주소여야 함!!) 
	      String sMsg = "인증번호["+content+"] - 인증번호확인란에 입력해주세요"; 
	      Properties p = new Properties(); // 정보를 담을 객체 
	      p.put("mail.smtp.user", "jsasendtest@gmail.com"); 
	      p.put("mail.smtp.host", "smtp.gmail.com"); 
	      p.put("mail.smtp.port", "465"); 
	      p.put("mail.smtp.starttls.enable","true"); // 반드시 true 
	      p.put("mail.smtp.auth", "true"); 
	      p.put("mail.smtp.debug", "true"); 
	      p.put("mail.smtp.socketFactory.port", "465"); 
	      p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
	      p.put("mail.smtp.socketFactory.fallback", "false"); // SMTP 서버에 접속하기 위한 정보들
	   
	      try { 
	         Session mailSession = Session.getInstance(p, new javax.mail.Authenticator() { 
	            protected PasswordAuthentication getPasswordAuthentication() { 
	               return new PasswordAuthentication("jsasendtest@gmail.com","sendtest"); // gmail 메일 ID / PWD 
	                     } }); 
	         mailSession.setDebug(true); // Create a default MimeMessage object. 
	         Message message = new MimeMessage(mailSession); // Set From: header field of the header. 
	         message.setFrom(new InternetAddress(sf)); // Set To: header field of the header. 
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(st)); // Set Subject: header field 
	         message.setSubject(sbj); // Now set the actual message 
	         message.setContent(sMsg, "text/html;charset=utf-8"); // 내용과 인코딩 // Send message 
	         Transport.send(message); 
	         // System.out.println("Sent message successfully...."); 
	         // sResult = "Sent message successfully...."; 
	         } catch (MessagingException e) {
	            e.printStackTrace(); 
	         
	            sResult = "ERR"; 
	         } 
	         }catch (Exception err){ 
	         
	            sResult = "ERR"; 
	         }finally { 
	            // dbhandle.close(dbhandle.con);
	            
	         }
	         return result = 1;
	         }

	public int check(String id, String pw)
	{
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(id +"db");
		System.out.println(pw);
		
		try
		{
			 con = getConnection();
			 String sql = "select * from hkk_member where id=?";

			  pstmt = con.prepareStatement(sql);
			  pstmt.setString(1, id);
			
			  rs = pstmt.executeQuery();
			
			  if(rs.next()){
				//아이디가 있는데
				if(pw.equals(rs.getString("pw"))){
					//비밀번호가 맞음
				     result =1;   
				}else{
				   result = -1;	
				}
			}else{//아이디 없음
				result = 0;
			}
			
			
		}catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
				
			}catch(SQLException e)
			{
				
			}
			
		}
		return result;
	}
	
	public ArrayList<LogonDataBean> getmember(int memcode){
		LogonDataBean memberDto = null;
		ArrayList<LogonDataBean> list = new ArrayList<LogonDataBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			String sql = "select * from hkk_member where memcode != 3";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				memberDto = new LogonDataBean();
				
				memberDto.setId(rs.getString("id"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setGender(rs.getString("gender"));
				memberDto.setMemcode(rs.getInt("memcode"));
				
				list.add(memberDto);
			}
			
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	public LogonDataBean getMyinfo(String id){
		LogonDataBean memberDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			String sql = "select * from hkk_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				memberDto = new LogonDataBean();
				
				memberDto.setId(rs.getString("id"));
				memberDto.setPw(rs.getString("pw"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setGender(rs.getString("gender"));
				memberDto.setMemcode(rs.getInt("memcode"));
			}
			
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return memberDto;
	}
	
	public int checkmemcode(String id){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			String sql = "select memcode from hkk_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getInt(1);
			}
			
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteMember(String id){
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try
		{
			con = getConnection();
			
			//스크랩 삭제
			sql = "delete from hkk_scrap where s_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//마켓 삭제
			sql = "delete from hkk_m_reply where m_r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "select * from hkk_market_write where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sql = "delete from hkk_marketcontent where m_c_connum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rs.getInt("m_connum"));
				pstmt.executeUpdate();
				pstmt.close();
			}
			sql = "delete from hkk_market_write where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//recommend 삭제
			sql = "delete from hkk_r_reply where r_r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "select * from hkk_recommend where r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sql = "delete from hkk_recommendcontent where r_c_connum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rs.getInt("r_connum"));
				pstmt.executeUpdate();
				pstmt.close();
			}
			sql = "delete from hkk_recommend where r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//오늘의한끼 삭제
			sql = "delete from hkk_todayhkk where t_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//공지사항 삭제
			sql = "delete from hkk_notice where n_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//Q&A 삭제
			sql = "select * from hkk_qna where q_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sql = "delete from hkk_q_reply where q_r_connum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rs.getInt("q_connum"));
				pstmt.executeUpdate();
				pstmt.close();
			}
			sql = "delete from hkk_qna where q_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//레시피 삭제
			sql = "delete from hkk_f_reply where food_r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "select * from hkk_food_write where food_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sql = "delete from hkk_foodcontent where food_c_connum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rs.getInt("food_connum"));
				pstmt.executeUpdate();
				pstmt.close();
			}
			sql = "delete from hkk_food_write where food_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			//회원정보 삭제
			sql = "delete from hkk_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			pstmt.close();
			
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMemcode(String id, int memcode, int memcode2) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try
		{	
			if(memcode != memcode2){
				con = getConnection();
				sql = "update hkk_member set memcode=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, memcode2);
				pstmt.setString(2, id);
				result = pstmt.executeUpdate();
			}else {
				result = 1;
			}
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMemberPw(String id, String pw) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try
		{	
			con = getConnection();
			sql = "update hkk_member set pw=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();

		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getcode(String id)
	{
		int memcode = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from hkk_member where id=?";
	
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, id);
			   rs = pstmt.executeQuery();
			 if (rs.next())
			{
				 memcode = rs.getInt("memcode");
			} 
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
				
			}catch(SQLException e)
			{
				
			}
			
		}
		return memcode;
	}
	
	public String getpw(String id)
	{
		String pw = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from hkk_member where id=?";
	
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, id);
			   rs = pstmt.executeQuery();
			 if (rs.next())
			{
				 pw = rs.getString("pw");
			} 
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
				
			}catch(SQLException e)
			{
				
			}
			
		}
		return pw;
	}
	
	
}

