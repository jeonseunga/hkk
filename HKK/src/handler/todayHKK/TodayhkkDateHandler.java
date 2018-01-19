package handler.todayHKK;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import todayhkk.TodayHKKDBBean;
import todayhkk.TodayHKKDataBean;

public class TodayhkkDateHandler implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		

		return "/todayHKK/HKK_hkkdate.jsp";
	}

}
