package handler.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;

public class ModifyMyMemberProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		LogonDBBean memberDao = LogonDBBean.getInstance();
		int result = memberDao.updateMemberPw(id, pw);
		
		request.setAttribute("result", result);
		
		return "/manage/modifyMymemberPro.jsp";
	}
}
