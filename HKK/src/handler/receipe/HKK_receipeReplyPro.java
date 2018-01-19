package handler.receipe;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import receipe.FoodReplyDBBean;
import receipe.FoodReplyDataBean;

public class HKK_receipeReplyPro implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int food_r_connum = Integer.parseInt(request.getParameter("food_r_connum"));
		int food_r_code = Integer.parseInt(request.getParameter("food_r_code"));
		
		FoodReplyDBBean FoReDao = FoodReplyDBBean.getInstance();
		FoodReplyDataBean FoReDto = new FoodReplyDataBean();
		FoReDto.setFood_r_connum(food_r_connum);
		FoReDto.setFood_r_id((String)request.getSession().getAttribute("memId"));
		String r_reply_content = request.getParameter("r_reply_content");
		r_reply_content = new String(r_reply_content.getBytes("8859_1"),"utf-8");
		FoReDto.setFood_recontent(r_reply_content);
		FoReDto.setFood_r_reg_date(new Timestamp(System.currentTimeMillis()));
		FoReDto.setFood_r_code(food_r_code);
		
		int result = FoReDao.insertHanKKI(FoReDto);
		
		request.setAttribute("food_r_code", food_r_code);
		request.setAttribute("food_r_connum", food_r_connum);
		request.setAttribute("result", result);
		
		return "/HKK_receipe/HKK_receipeReplyPro.jsp";
	}
}
