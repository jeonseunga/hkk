package handler.center;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import receipe.FoodContentDBBean;
import receipe.FoodWriteDBBean;
import receipe.FoodWriteDataBean;

public class SearchHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int count = 0;
		String pageNum = null;	// 현재 페이지
		int currentPage = 0;	// 현재 페이지
		int start = 0;			// 현재 페이지 시작 rownum
		int end = 0;			// 현재 페이지 끝 rownum
		int number = 0;			// 글 번호 계산
		int pageSize = 8;		// 한 페이지에 출력하는 글 수 
		int pageBlock = 3;		// 한번에 보여줄 페이지 수
		int pageCount = 0;		// 전체페이지 수
		int startPage = 0; 		// 보여줄 첫 페이지
		int endPage = 0;		// 보여줄 끝 페이지
		
		request.setCharacterEncoding("utf-8");
		
		int foodcode = Integer.parseInt(request.getParameter("foodcode"));
		
		FoodWriteDBBean writeDao = FoodWriteDBBean.getInstance();
		FoodContentDBBean contentDao = FoodContentDBBean.getInstance();
		
		count = writeDao.getCount(foodcode);
		
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
		
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("number", number);
		
		String search = request.getParameter("search");
		String serch = request.getParameter("serch");
		
		ArrayList<FoodWriteDataBean> write = new ArrayList<FoodWriteDataBean>();
		writeDao = FoodWriteDBBean.getInstance();
		write = writeDao.getSearchList(search,serch,foodcode);
		
		ArrayList<String> content = new ArrayList<String>();
		contentDao = FoodContentDBBean.getInstance();
		for(int i=0; i < write.size(); i++) {
			content.add(contentDao.getPath(write.get(i).getFood_connum()));
		}
		request.setAttribute("write", write);
		request.setAttribute("content", content);
		
		if(foodcode == 1){
			return "/HKK_receipe/hansik.jsp";
		}else if(foodcode == 2){
			return "/HKK_receipe/yangsik.jsp";
		}else if(foodcode == 3){
			return "/HKK_receipe/ilsik.jsp";
		}else if(foodcode == 4){
			return "/HKK_receipe/joongsik.jsp";
		}else if(foodcode == 5){
			return "/HKK_receipe/dessert.jsp";
		}else{
			return "/HKK_receipe/hansik.jsp";
		}
	}
}
