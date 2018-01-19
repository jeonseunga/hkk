package handler.market;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import market.HKK_m_reply;
import market.marketDBBean;
import recommend.HKK_r_reply;
import recommend.RecommendDBBean;

public class HKK_marketReplyProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum");
		int m_connum = Integer.parseInt(request.getParameter("m_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		marketDBBean RecomDao = new marketDBBean();
		HKK_m_reply MkReDto = new HKK_m_reply();
		MkReDto.setM_r_connum(m_connum);
		MkReDto.setM_r_id((String)request.getSession().getAttribute("memId"));
		String r_reply_content = request.getParameter("r_reply_content");
		r_reply_content = new String(r_reply_content.getBytes("8859_1"),"utf-8");
		MkReDto.setM_r_recontent(r_reply_content);
		MkReDto.setM_r_reg_date(new Timestamp(System.currentTimeMillis()));
		int result = RecomDao.insertHanKKI(MkReDto);
		
		request.setAttribute("number", number);
		request.setAttribute("m_connum", m_connum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		return "/HKK_MarketFile/HKK_marketReplyPro.jsp";
	}
}