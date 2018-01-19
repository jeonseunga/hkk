package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import handler.CommandHandler;
import member.LogonDBBean;

public class SendEmailHandler implements CommandHandler{

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
      
      
      String email = request.getParameter("email");
      String authNum = "";
      String content = "";
   
      //인증번호 생성
      for(int i =0; i <= 6; i++){
         authNum += Integer.toString((int)(Math.random()*10));
      }
      content =  authNum;  
   
      LogonDBBean memberDao = LogonDBBean.getInstance();
      
      int result = memberDao.sendEmail(email, content);
      
      System.out.println(result);
      
      request.setAttribute("result", result);
      request.setAttribute("authNum", authNum);
   
      
      
      
      return "/HKK_member/sendEmail.jsp";
   }

}
