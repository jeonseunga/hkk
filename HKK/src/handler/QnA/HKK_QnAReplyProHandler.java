package handler.QnA;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.HKK_q_reply;
import QnA.QnADBBean;
import handler.CommandHandler;
import recommend.HKK_r_reply;
import recommend.RecommendDBBean;

public class HKK_QnAReplyProHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum");
		int q_connum = Integer.parseInt(request.getParameter("q_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		QnADBBean QnADao = new QnADBBean();
		HKK_q_reply QnAReDto = new HKK_q_reply();
		QnAReDto.setQ_r_connum(q_connum);
		QnAReDto.setQ_r_id((String)request.getSession().getAttribute("memId"));
		String q_recontent = request.getParameter("r_reply_content");
		q_recontent = new String(q_recontent.getBytes("8859_1"),"utf-8");
		QnAReDto.setQ_recontent(q_recontent);
		QnAReDto.setQ_r_reg_date(new Timestamp(System.currentTimeMillis()));
		int result = QnADao.insertHanKKI(QnAReDto);
		
		request.setAttribute("number", number);
		request.setAttribute("q_connum", q_connum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		return "/HKK_QnA/HKK_QnAReplyPro.jsp";
	}
}
