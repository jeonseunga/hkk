package handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import handler.CommandHandler;

import notice.NoticeDBBean;

public class DeleteProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		
		String id = (String)request.getSession().getAttribute("memId");	
		
		String contentid = request.getParameter("writer");
		
		System.out.println(contentid);
		System.out.println(id);
		
	
		NoticeDBBean boardDao = NoticeDBBean.getInstance();
		
		
		if(contentid.equals(id))
		{
			int result = boardDao.deleteArticle(num);
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
		}else
		{
			System.out.println("11111");
			int deletecheck = 1;
			request.setAttribute("deletecheck", deletecheck);
		}
		return "/HKK_Notice/NoticedeletePro.jsp";
	}

}
