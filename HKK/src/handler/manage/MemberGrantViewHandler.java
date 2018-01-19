package handler.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;

public class MemberGrantViewHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		LogonDBBean memberDao = LogonDBBean.getInstance();
		
		int memcode = memberDao.checkmemcode(id);
		
		request.setAttribute("id", id);
		request.setAttribute("memcode", memcode);
		
		return "/manage/memberGrantView.jsp";
	}
}
