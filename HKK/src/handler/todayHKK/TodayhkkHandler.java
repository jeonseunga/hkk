package handler.todayHKK;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import todayhkk.TodayHKKDBBean;
import todayhkk.TodayHKKDataBean;

public class TodayhkkHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		TodayHKKDBBean todayhkkDao = TodayHKKDBBean.getInstance();
		
		
		String search_id = request.getParameter("t_id");
		System.out.println("search_id" + search_id);
		
		if(search_id != null){
			//아이디받은것 있으면
			Date day = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String t_leg_date = sdf.format(day);
			request.setAttribute("date", t_leg_date);
			
			int search_count = todayhkkDao.getsearch_Count(search_id);
			request.setAttribute("search_count", search_count);
			if(search_count != 0){
				ArrayList<TodayHKKDataBean> articles = todayhkkDao.getsearchHanKKi(search_id);
				request.setAttribute("articles", articles);
			}
			
		}else{
			//아이디 받은것 없으면
			int count = todayhkkDao.getCount();
			request.setAttribute("count", count);
			String today = request.getParameter("t_date");
			System.out.println("today" + today);
			
			if(today != null){
				//날짜받은것있으면
				request.setAttribute("date", today);
				if(count != 0){
					ArrayList<TodayHKKDataBean> articles = todayhkkDao.getHanKKi(today);
					request.setAttribute("articles", articles);
				}
				
			}else{
				//날짜받은것 없으면
				Date day = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String t_leg_date = sdf.format(day);
				request.setAttribute("date", t_leg_date);
				
					if(count != 0){
						ArrayList<TodayHKKDataBean> articles = todayhkkDao.getHanKKi(t_leg_date);
						request.setAttribute("articles", articles);
					}
				
			}
		}
		

		return "/todayHKK/todayHKK.jsp";
	}

}
