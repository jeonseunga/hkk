package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class HKK_QnADelFormHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("q_connum", q_connum);
		request.setAttribute("number", number);
		
		return "/HKK_QnA/HKK_QnADelForm.jsp";
	}
}
