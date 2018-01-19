package handler.recommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import member.LogonDBBean;
import recommend.HKK_r_reply;
import recommend.HKK_recommendcontent;
import recommend.RecommendDBBean;
import recommend.RecommendDataBean;

public class RecomcontentHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum");
		int r_connum = Integer.parseInt(request.getParameter("r_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		String find = request.getParameter("find");
		
		if(find!=null) {
			String findfind = request.getParameter("findfind");
			request.setAttribute("find", find);
			request.setAttribute("findfind", findfind);
		}
	
		RecommendDBBean RecomDao = RecommendDBBean.getInstance();
		RecomDao.addCount(r_connum);
		ArrayList<HKK_recommendcontent> RecomCon = RecomDao.getArticle(r_connum);
		RecommendDataBean RecomDto = RecomDao.getarticle(r_connum);
		
		int checkreply = RecomDao.checkreply(r_connum);
		ArrayList <HKK_r_reply> articles = RecomDao.getRecomReply(r_connum);
		
		request.setAttribute("number", number);
		request.setAttribute("RecomCon", RecomCon);
		request.setAttribute("RecomDto", RecomDto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("articles", articles);
		request.setAttribute("checkreply", checkreply);
	
		return "/RecommendFile/Recomcontent.jsp";
	}
}
