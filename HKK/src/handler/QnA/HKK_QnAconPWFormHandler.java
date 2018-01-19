package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.QnADBBean;
import handler.CommandHandler;

public class HKK_QnAconPWFormHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		
		int number = Integer.parseInt(request.getParameter("number"));
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String find = request.getParameter("find");
		if(find!=null) {
			String findfind = request.getParameter("findfind");
			request.setAttribute("find", find);
			request.setAttribute("findfind", findfind);
		}
	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("q_connum", q_connum);
		request.setAttribute("number", number);
		
		return "/HKK_QnA/HKK_QnAcontentPWForm.jsp";
	}
}
