package handler.market;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import market.marketDBBean;
import recommend.HKK_r_reply;
import recommend.RecommendDBBean;

public class HKK_marketReDelProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		int m_connum = Integer.parseInt(request.getParameter("m_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String m_id = (String)request.getSession().getAttribute("memId");
		int m_r_renum = Integer.parseInt(request.getParameter("renum"));
		System.out.println(m_connum+m_id+ m_r_renum);
		marketDBBean MkDao = new marketDBBean();
		int replydel = MkDao.RecomReDel(m_connum, m_id, m_r_renum);
		System.out.println(replydel+"댓글 삭제 1이어야함");
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("m_connum", m_connum);
		request.setAttribute("number", number);
		request.setAttribute("replydel", replydel);
		
		return "/HKK_MarketFile/HKK_marketReDelPro.jsp";
	}
}