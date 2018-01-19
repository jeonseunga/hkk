package handler.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import market.HKK_m_reply;
import market.HKK_market_write;
import market.HKK_marketcontent;
import market.marketDBBean;
import member.LogonDBBean;

import java.util.ArrayList;
import recommend.HKK_r_reply;
import recommend.HKK_recommendcontent;
import recommend.RecommendDBBean;
import recommend.RecommendDataBean;

public class HKK_content implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum");
		int m_connum = Integer.parseInt(request.getParameter("m_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		String find = request.getParameter("find");
		
		if(find!=null) {
			String findfind = request.getParameter("findfind");
			request.setAttribute("find", find);
			request.setAttribute("findfind", findfind);
		}
		
		LogonDBBean memberDao = new LogonDBBean();
		String id = (String)request.getSession().getAttribute("memId");
		int memcode = memberDao.getcode(id);
		 
		marketDBBean MkDao = marketDBBean.getInstance();
		MkDao.addCount(m_connum);
		ArrayList<HKK_marketcontent> MkcontentDto = MkDao.getArticle(m_connum);
		HKK_market_write marketDto = MkDao.getarticle(m_connum);
		
		int checkreply = MkDao.checkreply(m_connum);
		ArrayList <HKK_m_reply> articles = MkDao.getRecomReply(m_connum);
		
		request.setAttribute("number", number);
		request.setAttribute("MkcontentDto", MkcontentDto);
		request.setAttribute("marketDto", marketDto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("articles", articles);
		request.setAttribute("checkreply", checkreply);
		request.setAttribute("memcode", memcode);
	
		return "/HKK_MarketFile/content.jsp";
	}
}
