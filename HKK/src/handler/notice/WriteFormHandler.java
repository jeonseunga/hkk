package handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class WriteFormHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//제목글
		int num = 0;	//제목글 / 답변글
		int ref = 1;	//그룹화 아이디
		int re_step = 0; //글순서
		int re_level = 0; //글레벨
		
		
		
		if(request.getParameter("num") != null){
			//답변글 num값이 null이 안오면 즉, 넘어오면(글번호가 있기 때문)
			//content에서 넘어오는 값들
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
		
		request.setAttribute("num", num);
		
		
		
		
		return "/HKK_Notice/NoticewriteForm.jsp";
	}

}
