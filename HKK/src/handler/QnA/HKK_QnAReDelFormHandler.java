package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class HKK_QnAReDelFormHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int q_renum = Integer.parseInt(request.getParameter("q_renum"));
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("q_connum", q_connum);
		request.setAttribute("number", number);
		request.setAttribute("q_renum", q_renum);
	
		return "/HKK_QnA/HKK_QnAReDelForm.jsp";
	}
}
