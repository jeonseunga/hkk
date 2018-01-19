package handler.receipe;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import receipe.FoodCodeDataBean;
import receipe.FoodContentDBBean;
import receipe.FoodContentDataBean;
import receipe.FoodReplyDBBean;
import receipe.FoodReplyDataBean;
import receipe.FoodWriteDBBean;
import receipe.FoodWriteDataBean;
import recommend.HKK_r_reply;

public class ReceipeViewHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int food_connum = Integer.parseInt(request.getParameter("food_connum"));
		FoodContentDBBean contentDao = FoodContentDBBean.getInstance();
		FoodWriteDBBean writeDao = FoodWriteDBBean.getInstance();
		FoodReplyDBBean FoReDao = FoodReplyDBBean.getInstance();

		FoodWriteDataBean writeDto = writeDao.getArticle(food_connum);
		ArrayList<FoodContentDataBean> contentlist = contentDao.getContent(food_connum);
		
		int checkreply = FoReDao.checkreply(food_connum);
		ArrayList <FoodReplyDataBean> articles = FoReDao.getRecomReply(food_connum);
		
		request.setAttribute("food_connum", food_connum);
		request.setAttribute("writeDto", writeDto);
		request.setAttribute("contentlist", contentlist);
		request.setAttribute("checkreply", checkreply);
		request.setAttribute("articles", articles);
		
		return "/HKK_receipe/receipeView.jsp";
	}
}