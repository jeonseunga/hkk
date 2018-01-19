package handler.manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import handler.CommandHandler;
import member.LogonDBBean;
import member.LogonDataBean;

public class ManageViewHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		ArrayList<LogonDataBean> memberList = new ArrayList<LogonDataBean>();
		LogonDataBean memberDto = new LogonDataBean();
		LogonDBBean memberDao = LogonDBBean.getInstance();
		String id = (String)request.getSession().getAttribute("memId");
		String search = null;
		int memcode = memberDao.checkmemcode(id);
		if(memcode == 3){
			memberList = memberDao.getmember(memcode);
			memberDto = memberDao.getMyinfo(id);
			
			request.setAttribute("memberDto", memberDto);
			request.setAttribute("search", search);
			
			return "/manage/manage.jsp";
		}else{
			memberDto = memberDao.getMyinfo(id);
			
			request.setAttribute("memberDto", memberDto);
			
			return "/manage/mypage.jsp";
		}
		
	}
}
