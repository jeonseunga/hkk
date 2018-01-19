package handler.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import market.marketDBBean;
import recommend.RecommendDBBean;

public class HKK_marketDelProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");
		int m_connum = Integer.parseInt(request.getParameter("m_connum"));
		int memcode = Integer.parseInt(request.getParameter("memcode"));
		String m_id = (String)request.getSession().getAttribute("memId");

		marketDBBean MKDao = marketDBBean.getInstance();
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("m_connum", m_connum);
		request.setAttribute("MKDao", MKDao);
		
		if(memcode!=3) {
			 int result = MKDao.deleteAticle(m_id, m_connum);
			 request.setAttribute("result", result);
		} else {
			int result = MKDao.deleteAticle(m_connum);
			 request.setAttribute("result", result);
		}
		
		return "/HKK_MarketFile/HKK_marketdeletePro.jsp";
	}
}

