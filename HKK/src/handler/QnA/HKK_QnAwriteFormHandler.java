package handler.QnA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;

public class HKK_QnAwriteFormHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int q_connum = 0;		// num이 0인경우 제목글 & 답변글
		String pw = request.getParameter("pw");
		
		if(request.getParameter("q_connum")!=null) {
			q_connum = Integer.parseInt(request.getParameter("q_connum"));
		}
		request.setAttribute("q_connum", q_connum);
		request.setAttribute("pw", pw);
		
		return "/HKK_QnA/HKK_QnAwriteForm.jsp";
	}
}
