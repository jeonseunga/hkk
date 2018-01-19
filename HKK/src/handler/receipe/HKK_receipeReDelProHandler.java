package handler.receipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import receipe.FoodReplyDBBean;

public class HKK_receipeReDelProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		int food_r_connum = Integer.parseInt(request.getParameter("food_r_connum"));
		String r_id = (String)request.getSession().getAttribute("memId");
		int food_renum = Integer.parseInt(request.getParameter("food_renum"));
		int food_r_code = Integer.parseInt(request.getParameter("food_r_code"));
		
		FoodReplyDBBean FoReDao = FoodReplyDBBean.getInstance();
		int replydel = FoReDao.RecomReDel(food_r_connum, r_id, food_renum, food_r_code);

		request.setAttribute("food_r_code", food_r_code);
		request.setAttribute("food_r_connum", food_r_connum);
		request.setAttribute("replydel", replydel);
		
		return "/HKK_receipe/HKK_receipeReDelPro.jsp";
	}
}