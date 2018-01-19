package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;






public class NoticeDBBean {
    private static NoticeDBBean instance = new NoticeDBBean();
      public static NoticeDBBean getInstance() {
         return instance;
      }
      // 커넥션풀
      public Connection getConnection() throws NamingException, SQLException {
         Context initCtx = new InitialContext();
         Context envCtx = (Context) initCtx.lookup( "java:comp/env" );
         DataSource ds = (DataSource) envCtx.lookup( "jdbc/kh" );
         return ds.getConnection();
      }
      
      public int getCount() {
         int count = 0;
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            con = getConnection();
            String sql =  "select count(*) from hkk_notice";
            pstmt = con.prepareStatement( sql );
            rs = pstmt.executeQuery();
            if( rs.next() ) {
            count = rs.getInt( 1 );   //괄호안에 결과 테이블의 컬럼명을 써야하는데,  컬럼명이 하나밖에 없을때는 번호(index)를 써도 된다. ( DB는 0번이 아닌 1번부터 시작하는 것 주의!! )
            }
            
         } catch (NamingException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            try {
               if( rs != null ) rs.close();
               if( pstmt != null ) pstmt.close();
               if( con != null ) con.close();
            } catch ( SQLException e ) {
               e.printStackTrace();
            }
         }
         return count;
      }
      
      public int getCountt() {
            int count = 0;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
               con = getConnection();
               String sql= "select count(*) "
                      + "from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID, r from "
                      + "(select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from hkk_notice where N_level=1)) where r >=1  and r <=4";
               pstmt = con.prepareStatement( sql );
               rs = pstmt.executeQuery();
               if( rs.next() ) {
               count = rs.getInt("count(*)");   //괄호안에 결과 테이블의 컬럼명을 써야하는데,  컬럼명이 하나밖에 없을때는 번호(index)를 써도 된다. ( DB는 0번이 아닌 1번부터 시작하는 것 주의!! )
               }
               
            } catch (NamingException e) {
               e.printStackTrace();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  if( rs != null ) rs.close();
                  if( pstmt != null ) pstmt.close();
                  if( con != null ) con.close();
               } catch ( SQLException e ) {
                  e.printStackTrace();
               }
            }
            return count;
         }
      
      public int getIdCount(String n_id) {
         int count = 0;
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            con = getConnection();
            String sql = "select count(*) from HKK_notice where n_id=?"; // 테이블에 count(*)열 만들어 목록수 반환
            pstmt= con.prepareStatement(sql);
            pstmt.setString(1, n_id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
               count = rs.getInt(1);
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
      
      
      
      
      public int getTiCount(String n_title) {
         int count = 0;
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            con = getConnection();
            String sql = "select count(*) from HKK_notice where n_title like '%' || ? || '%'"; // 테이블에 count(*)열 만들어 목록수 반환
            pstmt= con.prepareStatement(sql);
            pstmt.setString(1, n_title);
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
      

      
      public int insertArticle( NoticeDataBean boardDto ) {
            int result = 0;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
               con = getConnection();
               
              
              
               String sql = "insert into hkk_notice values(notice_seq.NEXTVAL, ?, ?, ?, ?, ?)";      // num값만 시퀀스에서 준다
               
               pstmt = con.prepareStatement( sql );

               pstmt.setString(1, boardDto.getN_title());
               pstmt.setString(2, boardDto.getN_content());
               pstmt.setTimestamp(3, boardDto.getN_reg_date());
               pstmt.setInt(4, boardDto.getN_level());
               pstmt.setString(5, boardDto.getN_id());
                  
               result = pstmt.executeUpdate();
               
            } catch (NamingException e) {
               e.printStackTrace();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  if( rs != null ) rs.close();
                  if( pstmt != null ) pstmt.close();
                  if( con != null ) con.close();
               } catch ( SQLException e ) {
                  e.printStackTrace();
               }
            }
            
            return result;
         }
      
     
      public NoticeDataBean getArticle( int num ) {
           NoticeDataBean article = null;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
               con = getConnection();
               String sql = "select * from hkk_notice where n_listnum=?";
               pstmt = con.prepareStatement( sql );
               pstmt.setInt(1, num);
               
               rs = pstmt.executeQuery();
               if( rs.next() ) {
                  article = new NoticeDataBean();
                  
                  article.setN_listnum(rs.getInt("n_listnum"));
                  article.setN_title(rs.getString("n_title"));
                  article.setN_content(rs.getString("n_content"));
                  article.setN_reg_date(rs.getTimestamp("n_reg_date"));
                  article.setN_id(rs.getString("n_id"));
                  
                 
                  
                
                  
               }//글을 보고왔기 때문에 else는 필요없다.
               
            } catch (NamingException e) {
               e.printStackTrace();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  if( rs != null ) rs.close();
                  if( pstmt != null ) pstmt.close();
                  if( con != null ) con.close();
               } catch ( SQLException e ) {
                  e.printStackTrace();
               }
            }      
            
            return article;
         }
      
      
      
      public int memcheck(String id, int a) {
        
            int checkresult = 0;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;      
            try {
               con = getConnection();
               String sql = "select * from hkk_member where id=?";
               pstmt = con.prepareStatement( sql );
               pstmt.setString(1, id);
               rs = pstmt.executeQuery();
             
               if( rs.next() ) {
                 if(a == Integer.parseInt(rs.getString("memcode"))){
                    checkresult = 1;
                    
                 }else{
                    checkresult = 0;
                    
                 }
                    
                  
               }
                  
                  
               
            } catch (NamingException e) {
               e.printStackTrace();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  if( rs != null ) rs.close();
                  if( pstmt != null ) pstmt.close();
                  if( con != null ) con.close();
               } catch ( SQLException e ) {
                  e.printStackTrace();
               }
            }
            return checkresult;
            
         }
      
      public int deleteArticle(int num){
         int result = 0;
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
                 
         try {
               con = getConnection();
              NoticeDataBean boardDto = getArticle(num);
             
              
              String sql = "delete from hkk_notice where n_listnum=?";
                       
              pstmt = con.prepareStatement(sql);
          
              pstmt.setInt(1, num);
            
              result = pstmt.executeUpdate();
           
              
            
               
            } catch (NamingException e) {
               e.printStackTrace();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  if( pstmt != null ) pstmt.close();
                  if( con != null ) con.close();
               } catch ( SQLException e ) {
                  e.printStackTrace();
               }
            }      
  
         return result;
      }
      
      
   public int getSearchCount(String noticechoice, String search){
         int count =0;
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            con = getConnection();
            String sql =null;
            
            if(noticechoice.equals("n_content") ){
               sql = "select count(*) from hkk_notice where n_title like ?";   
               pstmt = con.prepareStatement(sql);
               pstmt.setString(1, "%"+   search +"%");
            }else if(noticechoice.equals("n_id")){
               sql = "select count(*) from hkk_notice where n_id = ?";
               pstmt = con.prepareStatement(sql);
               pstmt.setString(1, search);
            }
            rs = pstmt.executeQuery();
            
            if( rs.next() ) {
               //rs.getInt("count(*)"); //어차피 하나만 나오니까 그냥 숫자 1을 입력함.
               count = rs.getInt( 1 ); //DB는 1번부터 시작한다.
            }
            
         } catch (NamingException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            try{
               if(pstmt != null) pstmt.close();
               if(con != null) con.close();
            }catch(SQLException e){
               e.printStackTrace();
            }         
         }      
         return count;
      }
      
        
   public ArrayList<NoticeDataBean> getArticles( int start, int end ) {
    ArrayList<NoticeDataBean> articles = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
       con = getConnection();    
      
       String sql = "select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,r from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r "
                + "from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID from hkk_notice where n_level = 2 order by N_LISTNUM desc) order by N_LISTNUM desc) where r >=?  and r <= ?";
             
             /*"select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,r "
             + "from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from "
             + "(select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID from hkk_notice order by N_LISTNUM desc) order by N_LISTNUM desc) where r >=?  and r <= ?";*/
       
       //쿼리해석 select * from (select A.*,rownum r from (select * from board orderby ref 내림, re_step 오름) where r 보다 크고 rnum 보다 작거나 같음
       // ref(부모글)내림차순 desc, re_step(답글+1된것들 1,2,3,4 순) 을 정렬시켜 논 후 (db에 있는것들) 그 정렬 된걸 이름을 r로
       pstmt = con.prepareStatement( sql );
       pstmt.setInt(1, start);
       pstmt.setInt(2, end);
       
       rs = pstmt.executeQuery();
       
       if( rs.next() ) {
          articles = new ArrayList <NoticeDataBean>();
          do {
             NoticeDataBean article = new NoticeDataBean();
            
             
             article.setN_listnum(rs.getInt("N_LISTNUM"));
             article.setN_id(rs.getString("N_ID"));
             article.setN_content(rs.getString("N_CONTENT"));
             article.setN_reg_date(rs.getTimestamp("N_REG_DATE"));
             article.setN_title(rs.getString("N_TITLE"));
             article.setN_level(rs.getInt("N_LEVEL"));
             
     
            
             articles.add( article );      // 10개를 바구니 배열에 묶는다
         
             
          } while( rs.next() );
       }
       
       
    } catch (NamingException e) {
       e.printStackTrace();
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       try {
          if( rs != null ) rs.close();
          if( pstmt != null ) pstmt.close();
          if( con != null ) con.close();
       } catch ( SQLException e ) {
          e.printStackTrace();
       }
    }
    
    return articles;

}
   
   public ArrayList<NoticeDataBean> getArtiCles( int start, int end ) {
       ArrayList<NoticeDataBean> articles = null;
       Connection con = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       try {
          con = getConnection();    
          String sql="select * from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID, r from "
                + "(select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from hkk_notice where N_level=1 )) where r >=? and r <=?";
          pstmt = con.prepareStatement( sql );
          pstmt.setInt(1, start);
          pstmt.setInt(2, end);
          
          rs = pstmt.executeQuery();
          
          if( rs.next() ) {
             articles = new ArrayList <NoticeDataBean>();
             do {
                NoticeDataBean article = new NoticeDataBean();              
                article.setN_listnum(rs.getInt("N_LISTNUM"));
                article.setN_id(rs.getString("N_ID"));
                article.setN_content(rs.getString("N_CONTENT"));
                article.setN_reg_date(rs.getTimestamp("N_REG_DATE"));
                article.setN_title(rs.getString("N_TITLE"));
                article.setN_level(rs.getInt("N_LEVEL"));                                      
                articles.add( article );                 
             } while( rs.next() );
          }
          
          
       } catch (NamingException e) {
          e.printStackTrace();
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          try {
             if( rs != null ) rs.close();
             if( pstmt != null ) pstmt.close();
             if( con != null ) con.close();
          } catch ( SQLException e ) {
             e.printStackTrace();
          }
       }
       
       return articles;

   }
        
   public ArrayList<NoticeDataBean> getIdArticles( int start, int end, String id ) {
       ArrayList<NoticeDataBean> articles = null;
       Connection con = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       try {
          con = getConnection();    
  
          String sql= "select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,r "
                + "from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from "
                + "(select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID from hkk_notice where n_id = ? order by N_LISTNUM desc) order by N_LISTNUM desc) where r >=?  and r <= ?";
          
          //쿼리해석 select * from (select A.*,rownum r from (select * from board orderby ref 내림, re_step 오름) where r 보다 크고 rnum 보다 작거나 같음
          // ref(부모글)내림차순 desc, re_step(답글+1된것들 1,2,3,4 순) 을 정렬시켜 논 후 (db에 있는것들) 그 정렬 된걸 이름을 r로
          pstmt = con.prepareStatement( sql );
         
          pstmt.setString(1, id);
          pstmt.setInt(2, start);
          pstmt.setInt(3, end);
          
         
         
          rs = pstmt.executeQuery();
          
          
          
          if(rs.next()){
          
             articles = new ArrayList <NoticeDataBean>();
             do {
                NoticeDataBean article = new NoticeDataBean();
               
                
                article.setN_listnum(rs.getInt("N_LISTNUM"));
                article.setN_id(rs.getString("N_ID"));
                article.setN_content(rs.getString("N_CONTENT"));
                article.setN_reg_date(rs.getTimestamp("N_REG_DATE"));
                article.setN_title(rs.getString("N_TITLE"));
                article.setN_level(rs.getInt("N_LEVEL"));
               
        
               
                articles.add( article );      // 10개를 바구니 배열에 묶는다
            
                
             } while( rs.next() );
          }
          
          
       } catch (NamingException e) {
          e.printStackTrace();
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          try {
             if( rs != null ) rs.close();
             if( pstmt != null ) pstmt.close();
             if( con != null ) con.close();
          } catch ( SQLException e ) {
             e.printStackTrace();
          }
       }
       
       return articles;

   }        
   

   public ArrayList<NoticeDataBean> getTiArticles( int start, int end, String title ) {
       ArrayList<NoticeDataBean> articles = null;
       Connection con = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       try {
          con = getConnection();    
         
          String sql = "select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,r from "
                   + "(select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from "
                   + "(select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID from hkk_notice "
                   + "where n_title like '%' || ? || '%' order by N_LISTNUM desc) order by N_LISTNUM desc) "
                   + "where r >= ? and r <= ?";
          
          //쿼리해석 select * from (select A.*,rownum r from (select * from board orderby ref 내림, re_step 오름) where r 보다 크고 rnum 보다 작거나 같음
          // ref(부모글)내림차순 desc, re_step(답글+1된것들 1,2,3,4 순) 을 정렬시켜 논 후 (db에 있는것들) 그 정렬 된걸 이름을 r로
          pstmt = con.prepareStatement( sql );
      
          pstmt.setString(1, title);
          pstmt.setInt(2, start);
          pstmt.setInt(3, end);
        
          
          rs = pstmt.executeQuery();
          
          if( rs.next() ) {
             articles = new ArrayList <NoticeDataBean>();
          
             do {
                NoticeDataBean article = new NoticeDataBean();
               
                
                article.setN_listnum(rs.getInt("N_LISTNUM"));
                article.setN_id(rs.getString("N_ID"));
                article.setN_content(rs.getString("N_CONTENT"));
                article.setN_reg_date(rs.getTimestamp("N_REG_DATE"));
                article.setN_title(rs.getString("N_TITLE"));
                article.setN_level(rs.getInt("N_LEVEL"));
                
        
               
                articles.add( article );      // 10개를 바구니 배열에 묶는다
             
             } while( rs.next() );
          }
          
          
       } catch (NamingException e) {
          e.printStackTrace();
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          try {
             if( rs != null ) rs.close();
             if( pstmt != null ) pstmt.close();
             if( con != null ) con.close();
          } catch ( SQLException e ) {
             e.printStackTrace();
          }
       }
       
       return articles;

   }        







        
}        
        
        







        
        
        
      
//      public ArrayList <NoticeDataBean> getsearchArticle (int start, int end, String search ,String noticechoice)
//      {
//         
//         
//         NoticeDataBean articles = null;
//         Connection con = null;
//         PreparedStatement pstmt = null;
//         ResultSet rs = null;
//         
//         ArrayList<NoticeDataBean> list = new ArrayList<NoticeDataBean>();
//      
//         try {
//            con = getConnection();
//            
//            if(noticechoice.equals("n_content")){      
////               String sql = "select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,r from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID from hkk_notice order by N_LEVEL asc) order by N_LEVEL asc) where r >= ?  and r <= ? and n_title like '%'||?||'%'";
//               String sql = "select * from hkk_notice where n_title like '%'||?||'%' order by n_level asc,n_listnum desc";
//               pstmt = con.prepareStatement(sql);
//               pstmt.setString(1, search);
//               
//               rs = pstmt.executeQuery();
//            
//               
//               while(rs.next()){
//                  //바구니를 채워줘야됨
//                  //순서는 상관없음    
//               
//                  articles = new NoticeDataBean();                  
//                                 
//                     articles.setN_listnum(rs.getInt("n_listnum"));
//                     articles.setN_title(rs.getString("n_title"));
//                     articles.setN_content(rs.getString("n_content"));
//                     articles.setN_reg_date(rs.getTimestamp("n_reg_date"));
//                     articles.setN_id(rs.getString("n_id"));
//                     articles.setN_level(rs.getInt("n_level"));
//                  
//                  list.add(articles);
//               
//                  
//               }
//               
//               
//               //데이터 가져오는거 or 가져왔을떄 true false 값도 가져올 수 있음
//               
//            }else if(noticechoice.equals("n_id")){
////               String sql = "select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,r from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID,rownum r from (select N_LISTNUM,N_TITLE,N_level,N_CONTENT,N_REG_DATE,N_ID from hkk_notice order by N_LEVEL asc) order by N_LEVEL asc) where r >=?  and r <= ? and n_id = ?";
//               String sql = "select * from hkk_notice where n_id=? order by n_level asc, n_listnum desc";
//               pstmt = con.prepareStatement(sql);
//               pstmt.setString(1, search);
//               rs = pstmt.executeQuery();
//               while(rs.next() ){
//                  //바구니를 채워줘야됨
//                  //순서는 상관없음 
//                  
//                  
//                    articles = new NoticeDataBean();
//                   
//                  
//                   
//                   *  article 들을 담아야한다 검색한 결과를 통해서 (아이디,내용 검색을 통해서)
//                   *  
//                   *  article = new NoticeDataBean();
//                     
//               
//                     articles.setN_listnum(rs.getInt("n_listnum"));
//                     articles.setN_title(rs.getString("n_title"));
//                     articles.setN_content(rs.getString("n_content"));
//                     articles.setN_reg_date(rs.getTimestamp("n_reg_date"));
//                     articles.setN_id(rs.getString("n_id"));
//                     articles.setN_level(rs.getInt("n_level"));                        
//                  list.add(articles);
//               }
//            }
//         } catch (NamingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         }
//         return list ;
//      }
//      
//    
//      
//      
//      
//}   */