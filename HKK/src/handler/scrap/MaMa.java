package handler.scrap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;

public class MaMa implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int s_renum = Integer.parseInt(request.getParameter("s_renum"));
		
		request.setAttribute("s_renum", s_renum);

		
		return "/HKK_Scrap/rkrkrk.jsp";
	}
}
