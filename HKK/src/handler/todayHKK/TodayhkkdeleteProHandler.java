package handler.todayHKK;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import todayhkk.TodayHKKDBBean;
 
public class TodayhkkdeleteProHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String session_id = (String)request.getSession().getAttribute("memId");
		//String t_id = request.getParameter("t_id");
		int t_listnum = Integer.parseInt(request.getParameter("t_listnum"));
		TodayHKKDBBean todayhkkDao = TodayHKKDBBean.getInstance();
		
		
		int membercode = todayhkkDao.checkmembercode(session_id);
		int result = 0;
		
		if(membercode == 3){
			//memcode가 관리자 3일때
			result = todayhkkDao.deleteArticle_manager(t_listnum);
			request.setAttribute("result", result);
			
		}else{
			//memcode가 일반 1 or 2일때
			int resultcheck = todayhkkDao.check(session_id,t_listnum);
			if(resultcheck == 1){
				result = todayhkkDao.deleteArticle(session_id, t_listnum);
				request.setAttribute("result", result);
			}
			request.setAttribute("resultcheck", resultcheck);
		}
		
		
		return "/todayHKK/todayHKKdeletePro.jsp";
	}
		
}
