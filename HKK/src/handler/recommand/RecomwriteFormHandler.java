package handler.recommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class RecomwriteFormHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int r_connum = 0;		// num이 0인경우 제목글 & 답변글
		
		if(request.getParameter("r_connum")!=null) {
			r_connum = Integer.parseInt(request.getParameter("r_connum"));
		}
		request.setAttribute("r_connum", r_connum);
		
		return "/RecommendFile/RecomwriteForm.jsp";
	}
}
