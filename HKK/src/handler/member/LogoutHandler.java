package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//세션을 가져옴
		request.getSession().removeAttribute("memId");
		
		return "HKK_main.jsp";
	}

}
