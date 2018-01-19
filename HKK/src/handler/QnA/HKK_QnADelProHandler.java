package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.QnADBBean;
import handler.CommandHandler;
import recommend.RecommendDBBean;

public class HKK_QnADelProHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		String q_pw = request.getParameter("q_pw");
		String q_id = (String)request.getSession().getAttribute("memId");

		QnADBBean QnADao = QnADBBean.getInstance();
		int resultcheck = QnADao.check(q_id);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("q_connum", q_connum);
		
		if(resultcheck!=0) {
			 int result = QnADao.deleteAticle(q_connum, q_pw);
			 request.setAttribute("result", result);
		}
		
		return "/HKK_QnA/HKK_QnADelPro.jsp";
	}
}
