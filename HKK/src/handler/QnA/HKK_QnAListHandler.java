package handler.QnA;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnA.HKK_qna;
import QnA.QnADBBean;
import handler.CommandHandler;
import member.LogonDBBean;
import member.LogonDataBean;
import recommend.HKK_recommendcontent;
import recommend.RecommendDBBean;
import recommend.RecommendDataBean;

public class HKK_QnAListHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int count = 0;
		String pageNum = null;	// 현재 페이지
		int currentPage = 0;	// 현재 페이지
		int start = 0;			// 현재 페이지 시작 rownum
		int end = 0;			// 현재 페이지 끝 rownum
		int number = 0;			// 글 번호 계산
		int pageSize = 5;		// 한 페이지에 출력하는 글 수 
		int pageBlock = 3;		// 한번에 보여줄 페이지 수
		int pageCount = 0;		// 전체페이지 수
		int startPage = 0; 		// 보여줄 첫 페이지
		int endPage = 0;		// 보여줄 끝 페이지
		request.setCharacterEncoding("utf-8");
		
		QnADBBean QnADao = QnADBBean.getInstance();

		String find = request.getParameter("find");
		String findfind = request.getParameter("findfind");
		
			if(find==null){
				count = QnADao.getCount(); 
			} else if(find.equals("1")) {
				count = QnADao.getIdCount(findfind); 
			} else {
				count = QnADao.getTiCount(findfind); 
			}
			if(count > 0) {
				pageNum = request.getParameter("pageNum");
				if(pageNum==null) {
					pageNum = "1";
				}
				currentPage = Integer.parseInt(pageNum);
				start = (currentPage - 1) * pageSize + 1;
				end = start + pageSize - 1;
				if(end > count) {
					end = count;
				}
				number = count -(currentPage - 1) * pageSize;
				pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0);
				startPage = (currentPage / pageBlock ) * pageBlock + 1;
				if(currentPage % pageBlock == 0) {
					startPage -= pageBlock;
				}
				endPage = startPage + pageBlock - 1;
				if(endPage>pageCount) {
					endPage=pageCount;
				}
			}
		
		LogonDBBean memberDao = new LogonDBBean();
		String id = (String)request.getSession().getAttribute("memId");
		int memcode = memberDao.getcode(id);
		
		if(memcode != 3) {
			String pw = memberDao.getpw(id);
			request.setAttribute("pw", pw);
		}
		
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("number", number);
		request.setAttribute("memcode", memcode);
		request.setAttribute("find", find);
		request.setAttribute("findfind", findfind);

		//디비가져오기
		if(count!=0) {
			if(find==null){
				ArrayList<HKK_qna> articles = QnADao.getArticles(start,end);
				request.setAttribute("articles", articles);
			} else if(find.equals("1")) {
				ArrayList<HKK_qna> articles = QnADao.getIdArticles(start,end,findfind);
				request.setAttribute("articles", articles);
			} else {
				System.out.println("타이틀 검색");
				ArrayList<HKK_qna> articles = QnADao.getTiArticles(start,end,findfind);
				request.setAttribute("articles", articles);
			}
		}
		return "/HKK_QnA/HKK_QnAList.jsp";
	}
}
