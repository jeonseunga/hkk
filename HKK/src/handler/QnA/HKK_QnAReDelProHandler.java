package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.QnADBBean;
import handler.CommandHandler;
import recommend.RecommendDBBean;

public class HKK_QnAReDelProHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String q_r_id = (String)request.getSession().getAttribute("memId");
		int q_renum = Integer.parseInt(request.getParameter("q_renum"));
		
		QnADBBean QnADao = QnADBBean.getInstance();
		int replydel = QnADao.RecomReDel(q_connum, q_r_id, q_renum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("q_connum", q_connum);
		request.setAttribute("number", number);
		request.setAttribute("replydel", replydel);
		
		return "/HKK_QnA/HKK_QnAReDelPro.jsp";
	}
}
