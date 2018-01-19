package handler.QnA;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.HKK_q_reply;
import QnA.HKK_qna;
import QnA.QnADBBean;
import handler.CommandHandler;
import member.LogonDBBean;
import recommend.HKK_r_reply;
import recommend.HKK_recommendcontent;
import recommend.RecommendDBBean;
import recommend.RecommendDataBean;

public class HKK_QnAcontentHandler implements CommandHandler{
public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum");
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		String find = request.getParameter("find");
		if(find!=null) {
			String findfind = request.getParameter("findfind");
			request.setAttribute("find", find);
			request.setAttribute("findfind", findfind);
		}
	
		QnADBBean QnADao = QnADBBean.getInstance();
		HKK_qna QnADto = QnADao.getArticle(q_connum);
		
		int checkreply = QnADao.checkreply(q_connum);
		ArrayList <HKK_q_reply> articles = QnADao.getRecomReply(q_connum);
		
		LogonDBBean memberDao = new LogonDBBean();
		String id = (String)request.getSession().getAttribute("memId");
		int memcode = memberDao.getcode(id);
		System.out.println(memcode+"멤코드");
		
		request.setAttribute("memcode", memcode);
		request.setAttribute("number", number);
		request.setAttribute("QnADto", QnADto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("articles", articles);
		request.setAttribute("checkreply", checkreply);
	
		return "/HKK_QnA/HKK_QnAcontent.jsp";
	}
}
