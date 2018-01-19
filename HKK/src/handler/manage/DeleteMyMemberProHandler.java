package handler.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;

public class DeleteMyMemberProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		LogonDBBean memberDao = LogonDBBean.getInstance();
		int result = memberDao.check(id, pw);
		if(result == 1) {
			result = memberDao.deleteMember(id);
		}
		
		request.setAttribute("result", result);
		
		return "/manage/deleteMymemberPro.jsp";
	}
}
