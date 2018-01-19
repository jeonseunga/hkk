package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;
import member.LogonDataBean;

public class LoginProHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
			
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		LogonDBBean memberDao = LogonDBBean.getInstance();
		
		LogonDataBean memberDto = new LogonDataBean();
				
		int result = memberDao.check(id,pw);
		
		System.out.println(result);
		
		request.setAttribute("result", result);
		
		request.setAttribute("id", id);
		
		request.setAttribute("pw", pw);
		
				

		
		return "/HKK_member/loginPro.jsp";
	}

}
