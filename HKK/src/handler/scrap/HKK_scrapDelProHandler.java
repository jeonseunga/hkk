package handler.scrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import recommend.RecommendDBBean;
import scrap.scrapDBBean;

public class HKK_scrapDelProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		int s_renum = Integer.parseInt(request.getParameter("s_renum"));

		scrapDBBean scrapDao = scrapDBBean.getInstance();
		int result = scrapDao.deleteAticle(s_renum);
		request.setAttribute("result", result);
		
		return "/HKK_Scrap/HKK_scrapDelPro.jsp";
	}
}

