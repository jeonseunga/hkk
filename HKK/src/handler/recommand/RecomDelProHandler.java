package handler.recommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import recommend.RecommendDBBean;

public class RecomDelProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");
		int r_connum = Integer.parseInt(request.getParameter("r_connum"));
		String r_id = (String)request.getSession().getAttribute("memId");

		RecommendDBBean RecomDao = RecommendDBBean.getInstance();
		
		request.setAttribute("pageNum", pageNum);
		int result = RecomDao.deleteAticle(r_id, r_connum);
		System.out.println(r_connum+result+"삭제");
		request.setAttribute("result", result);
		
		return "/RecommendFile/RecomdeletePro.jsp";
	}
}

