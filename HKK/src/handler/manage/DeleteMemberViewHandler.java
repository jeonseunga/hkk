package handler.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class DeleteMemberViewHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		
		return "/manage/deleteMemberView.jsp";
	}
}
