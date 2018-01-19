package handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class DeleteFormHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		//컨텐트에서 페이지 넘길때 pageNum 하고 num 2개 넘겼음
			String pageNum = request.getParameter("pageNum");
			int num = Integer.parseInt(request.getParameter("num"));
	
			
			request.setAttribute("num", num);
			request.setAttribute("pageNum", pageNum);
		
		return "/HKK_Notice/NoticedeleteForm.jsp";
	}

}
