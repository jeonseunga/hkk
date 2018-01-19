package handler.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;

public class MemberGrantProHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		int memcode = Integer.parseInt(request.getParameter("mem"));
		int memcode2 = Integer.parseInt(request.getParameter("memcode"));
		
		LogonDBBean memberDao = LogonDBBean.getInstance();
		int result = memberDao.updateMemcode(id,memcode,memcode2);
		
		request.setAttribute("result", result);
		
		return "/manage/memberGrantPro.jsp";
	}
}
