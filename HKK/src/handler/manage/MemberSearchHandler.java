package handler.manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;
import member.LogonDataBean;

public class MemberSearchHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		ArrayList<LogonDataBean> memberList = new ArrayList<LogonDataBean>();
		LogonDataBean memberDto = new LogonDataBean();
		LogonDataBean memberlistDto = new LogonDataBean();
		LogonDBBean memberDao = LogonDBBean.getInstance();
		String id = (String)request.getSession().getAttribute("memId");
		String search = request.getParameter("id");
		int memcode = memberDao.checkmemcode(id);
		memberList = memberDao.getmember(memcode);
		memberDto = memberDao.getMyinfo(id);
		memberlistDto = memberDao.getMyinfo(search);
		
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("search", search);
		request.setAttribute("memberlistDto", memberlistDto);
		
		return "/manage/manage.jsp";
	}
}
