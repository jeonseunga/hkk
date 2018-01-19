package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.QnADBBean;
import handler.CommandHandler;

public class HKK_QnAconPWProHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		
		String q_pw = request.getParameter("q_pw");
		System.out.println("QnA"+q_pw);
		int number = Integer.parseInt(request.getParameter("number"));
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String q_id = (String)request.getSession().getAttribute("memId");
		
		String find = request.getParameter("find");
		if(find!=null) {
			String findfind = request.getParameter("findfind");
			request.setAttribute("find", find);
			request.setAttribute("findfind", findfind);
		}
		
		QnADBBean QnADao = QnADBBean.getInstance();
		int result = QnADao.getpwart(q_pw, q_connum, q_id);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		request.setAttribute("number", number);
		request.setAttribute("q_connum", q_connum);
		
		return "/HKK_QnA/HKK_QnAcontentPWPro.jsp";
	}
}
