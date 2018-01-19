package handler.scrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;



public class HKK_scrapFormHandler  implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int s_connum = Integer.parseInt(request.getParameter("s_connum"));
		String s_img_path = request.getParameter("s_img_path");
		String s_r_title = request.getParameter("s_r_title");
		String s_r_id = request.getParameter("s_r_id");
		int food_code = Integer.parseInt(request.getParameter("food_code"));
		
		request.setAttribute("s_connum", s_connum);
		request.setAttribute("s_img_path", s_img_path);
		request.setAttribute("s_r_title", s_r_title);
		request.setAttribute("s_r_id", s_r_id);
		request.setAttribute("food_code", food_code);

		return "/HKK_Scrap/HKK_scrapForm.jsp";
	}	
}

