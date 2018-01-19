package handler.member;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;
import member.LogonDataBean;

public class InputProHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
	
		System.out.println("11111");
		
		LogonDataBean memberDto = new LogonDataBean();
		memberDto.setId(request.getParameter("id"));
		memberDto.setPw(request.getParameter("pw"));
		
		memberDto.setGender(request.getParameter("gender"));
		memberDto.setEmail(request.getParameter("email"));
	

	
	
	
		LogonDBBean memberDao = LogonDBBean.getInstance();
		int result = memberDao.insertMember(memberDto);

		request.setAttribute("result", result);
		
		
		return "/HKK_member/inputPro.jsp";
	}

	
}
