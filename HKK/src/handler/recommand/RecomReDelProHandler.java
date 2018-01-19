package handler.recommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import recommend.HKK_r_reply;
import recommend.RecommendDBBean;

public class RecomReDelProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		int r_connum = Integer.parseInt(request.getParameter("r_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String r_id = (String)request.getSession().getAttribute("memId");
		int r_r_renum = Integer.parseInt(request.getParameter("renum"));
		
		RecommendDBBean RecomDao = new RecommendDBBean();
		int replydel = RecomDao.RecomReDel(r_connum, r_id, r_r_renum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("r_connum", r_connum);
		request.setAttribute("number", number);
		request.setAttribute("replydel", replydel);
		
		return "/RecommendFile/RecomReDelPro.jsp";
	}
}