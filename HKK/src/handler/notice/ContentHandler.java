package handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import handler.CommandHandler;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class ContentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		//글 하나만 가져와야 됨
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		int number = Integer.parseInt(request.getParameter("number"));
		String noticechoice = request.getParameter("noticechoice");
		if(noticechoice!=null) {
			String search = request.getParameter("search");
			request.setAttribute("noticechoice", noticechoice);
			request.setAttribute("search", search);
		}

	
		
		NoticeDBBean boardDao = NoticeDBBean.getInstance();
		NoticeDataBean boardDto = boardDao.getArticle(num); //글 하나 가져와서 뿌려야됨
		//한칸 위에 넣으면 들어올때 증가하고 여기에 작성하면 나갈때 조회수가 1증가
				
		
		
		
	
		request.setAttribute("number", number);
		request.setAttribute("boardDto", boardDto);
		request.setAttribute("pageNum", pageNum);

	   
		
		
		return "/HKK_Notice/Noticecontent.jsp";
	}

}
