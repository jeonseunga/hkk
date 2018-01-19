package handler.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import handler.CommandHandler;
import member.LogonDBBean;
import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class ListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int pageBlock = 3;      //한 번에 보여줄 페이지 수
		int pageSize = 6; 	   //한 페이지에 출력할 글의 수
		int count = 0;
		String pageNum = null; //현재 페이지(jsp 넘기는용)
		int currentPage = 0;   //현재페이지 (연산용 페이지 넘버 페이지Num이 스트링이라)
		int start = 0;		   //현재페이지의 시작 rownum
		int end = 0;		   //현재페이지의 끝 rownum
		int number = 0;		   //글번호 계산
		int pageCount = 0;		//전체 페이지수
		int startPage = 0;		//보여줄 첫 페이지
		int endPage = 0;		//보여줄 끝 페이지
		int NTcount = 0;
		
		NoticeDBBean boardDao = NoticeDBBean.getInstance();
		
		String noticechoice = request.getParameter("noticechoice");
		String search = request.getParameter("search");
		LogonDBBean memberDao = new LogonDBBean();
		String id = (String)request.getSession().getAttribute("memId");
		int memcode = memberDao.getcode(id);
		
		NTcount = boardDao.getCountt();
		
		if(NTcount!=0) {
			ArrayList<NoticeDataBean> ArtiCles = boardDao.getArtiCles(1,4);
			request.setAttribute("ArtiCles", ArtiCles);
		}
		
		if(noticechoice==null){
			count = boardDao.getCount();
		}else {
			count = boardDao.getTiCount(search);
		}
		
		if(count > 0){
			
			pageNum = request.getParameter("pageNum");
			if(pageNum == null){
				pageNum = "1"; 
			}
			currentPage = Integer.parseInt(pageNum);
			start = (currentPage - 1) * pageSize + 1;
			end = start + pageSize -1;
			if(end > count)	end = count;	
			number = count - (currentPage - 1) * pageSize;		
			pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0) ;
			startPage = (currentPage / pageBlock) * pageBlock + 1;
			if(currentPage % pageBlock == 0) startPage -= pageBlock;		
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) endPage = pageCount ;
		}
		
		request.setAttribute("count", count);
		request.setAttribute("NTcount", NTcount);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("number", number);
		request.setAttribute("memcode", memcode);
		request.setAttribute("noticechoice", noticechoice);
		request.setAttribute("search", search);		
		if(count != 0){
		
			if(noticechoice==null){
				ArrayList<NoticeDataBean> articles = boardDao.getArticles(start,end);
				request.setAttribute("articles", articles);
			} else {
				ArrayList<NoticeDataBean> articles = boardDao.getTiArticles(start,end,search);
				request.setAttribute("articles", articles);
			}
			
		}
	

	
					
		return "/HKK_Notice/NoticeList.jsp";
	}

}
