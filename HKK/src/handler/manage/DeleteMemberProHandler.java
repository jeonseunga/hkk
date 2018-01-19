package handler.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;

public class DeleteMemberProHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = (String)request.getParameter("id");
		
		LogonDBBean memberDao = LogonDBBean.getInstance();
		int result = memberDao.deleteMember(id);
		
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		return "/manage/deleteMemberPro.jsp";
	}
}
