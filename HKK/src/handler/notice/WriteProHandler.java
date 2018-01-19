package handler.notice;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import notice.NoticeDataBean;
import notice.NoticeDBBean;

public class WriteProHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		request.setCharacterEncoding("utf-8");
	
		NoticeDataBean boardDto = new NoticeDataBean();//풀어써야됨
		

		boardDto.setN_listnum(Integer.parseInt(request.getParameter("num")));
		
		boardDto.setN_title(request.getParameter("subject"));
		boardDto.setN_content(request.getParameter("content"));
				
		boardDto.setN_id((String)request.getSession().getAttribute("memId"));
		
		String id = (String)request.getSession().getAttribute("memId");	
		
		boardDto.setN_level(Integer.parseInt(request.getParameter("noticechoice")));
		
		
		int a = 3;
			
		//readcount(조회수)
		
		//reg_date
		boardDto.setN_reg_date(new Timestamp(System.currentTimeMillis()));
		
		
	
		
		NoticeDBBean boardDao = NoticeDBBean.getInstance();
		
		int checkresult = boardDao.memcheck(id,a);
	
		request.setAttribute("checkresult", checkresult);
		
		if(checkresult == 1){
			int result = boardDao.insertArticle(boardDto);
			request.setAttribute("result", result);
		}
		
		//dto 파라미터 값과 동일해야 하는 form에서 받아온 것들을 전부 dto에 실은 상태로 insertArticle 쪽에 넣어줌
	
		
		
		
		
		
		return "/HKK_Notice/NoticewritePro.jsp";
	}

}
