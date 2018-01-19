package handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import receipe.FoodContentDBBean;
import receipe.FoodWriteDBBean;
import receipe.FoodWriteDataBean;

public class HKK_MainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
	      
	    //각 카테고리 최신순 3개 리스트 가져오기
	    ArrayList<FoodWriteDataBean> hansik = new ArrayList<FoodWriteDataBean>();
	    ArrayList<FoodWriteDataBean> yangsik = new ArrayList<FoodWriteDataBean>();
	    ArrayList<FoodWriteDataBean> ilsik = new ArrayList<FoodWriteDataBean>();
	    ArrayList<FoodWriteDataBean> joongsik = new ArrayList<FoodWriteDataBean>();
	    ArrayList<FoodWriteDataBean> dessert = new ArrayList<FoodWriteDataBean>();
	    FoodWriteDBBean writeDao = FoodWriteDBBean.getInstance();
	    hansik = writeDao.getMainList(1);
	    yangsik = writeDao.getMainList(2);
	    ilsik = writeDao.getMainList(3);
	    joongsik = writeDao.getMainList(4);
	    dessert = writeDao.getMainList(5);
	    
	    //각 카테고리 최신순 3개 내용 가져오기
	    ArrayList<String> Hcontent = new ArrayList<String>();
	    ArrayList<String> Ycontent = new ArrayList<String>();
	    ArrayList<String> Icontent = new ArrayList<String>();
	    ArrayList<String> Jcontent = new ArrayList<String>();
	    ArrayList<String> Dcontent = new ArrayList<String>();
	    FoodContentDBBean contentDao = FoodContentDBBean.getInstance();
	    for(int i=0; i < hansik.size(); i++) {
	       Hcontent.add(contentDao.getPath(hansik.get(i).getFood_connum()));
	    }
	    for(int i=0; i < yangsik.size(); i++) {
	       Ycontent.add(contentDao.getPath(yangsik.get(i).getFood_connum()));
	    }
	    for(int i=0; i < ilsik.size(); i++) {
	       Icontent.add(contentDao.getPath(ilsik.get(i).getFood_connum()));
	    }
	    for(int i=0; i < joongsik.size(); i++) {
	       Jcontent.add(contentDao.getPath(joongsik.get(i).getFood_connum()));
	    }
	    for(int i=0; i < dessert.size(); i++) {
	       Dcontent.add(contentDao.getPath(dessert.get(i).getFood_connum()));
	    }
	    //한식
	    request.setAttribute("hansik", hansik);
	    request.setAttribute("Hcontent", Hcontent);
	    //양식
	    request.setAttribute("yangsik", yangsik);
	    request.setAttribute("Ycontent", Ycontent);
	    //일식
	    request.setAttribute("ilsik", ilsik);
	    request.setAttribute("Icontent", Icontent);
	    //중식
	    request.setAttribute("joongsik", joongsik);
	    request.setAttribute("Jcontent", Jcontent);
	    //디저트
	    request.setAttribute("dessert", dessert);
	    request.setAttribute("Dcontent", Dcontent);
		
		return "HKK_main.jsp";
	}

}
