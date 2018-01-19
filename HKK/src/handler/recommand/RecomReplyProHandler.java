package handler.recommand;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import recommend.HKK_r_reply;
import recommend.RecommendDBBean;

public class RecomReplyProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum");
		int r_connum = Integer.parseInt(request.getParameter("r_connum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		RecommendDBBean RecomDao = new RecommendDBBean();
		HKK_r_reply RecomReDto = new HKK_r_reply();
		RecomReDto.setR_r_connum(r_connum);
		RecomReDto.setR_r_id((String)request.getSession().getAttribute("memId"));
		String r_reply_content = request.getParameter("r_reply_content");
		r_reply_content = new String(r_reply_content.getBytes("8859_1"),"utf-8");
		RecomReDto.setR_r_recontent(r_reply_content);
		RecomReDto.setR_r_reg_date(new Timestamp(System.currentTimeMillis()));
		int result = RecomDao.insertHanKKI(RecomReDto);
		
		request.setAttribute("number", number);
		request.setAttribute("r_connum", r_connum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		return "/RecommendFile/RecomReplyPro.jsp";
	}
}