package handler.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;

public class HKK_marketwriteFormHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int m_connum = 0;		// num이 0인경우 제목글 & 답변글
		
		if(request.getParameter("m_connum")!=null) {
			m_connum = Integer.parseInt(request.getParameter("m_connum"));
			System.out.println(m_connum+"m_cunnum");
		}
		request.setAttribute("m_connum", m_connum);
		
		return "/HKK_MarketFile/HKK_marketwriteForm.jsp";
	}
}
