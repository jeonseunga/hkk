package handler.receipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.LogonDBBean;
import receipe.FoodContentDBBean;
import receipe.FoodReplyDBBean;
import receipe.FoodReplyDataBean;
import receipe.FoodWriteDBBean;
import scrap.scrapDBBean;

public class ReceipeDeleteProHandler implements CommandHandler{

   public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
      
      request.setCharacterEncoding("utf-8");
      
      String id = (String)request.getSession().getAttribute("memId");
      int connum = Integer.parseInt(request.getParameter("food_connum"));
      int foodcode = Integer.parseInt(request.getParameter("food_code"));
      LogonDBBean memberDao = LogonDBBean.getInstance();
      int memcode = memberDao.checkmemcode(id);
      FoodReplyDBBean replyDao = FoodReplyDBBean.getInstance();
      FoodContentDBBean contentDao = FoodContentDBBean.getInstance();
      FoodWriteDBBean writeDao = FoodWriteDBBean.getInstance();
      scrapDBBean scrapDao = scrapDBBean.getInstance();
      int result = 0;
      if(memcode == 3) {
    	 scrapDao.delete(connum);
         replyDao.delete(connum);
         contentDao.delete(connum);
         result = writeDao.delete(connum);
         
         request.setAttribute("result", result);
         request.setAttribute("foodcode", foodcode);
         
         return "/HKK_receipe/receipedeletePro.jsp";
      }else {
         if(id == null || id.equals("")) {
            return "/HKK_receipe/receipeView.jsp?food_connum="+connum+"&foodcode="+foodcode;
         }else {
            result = writeDao.check(id,connum);
            if(result == 1) {
               scrapDao.delete(connum);
               replyDao.delete(connum);
               contentDao.delete(connum);
               writeDao.delete(connum);
            }
            request.setAttribute("connum", connum);
            request.setAttribute("result", result);
            request.setAttribute("foodcode", foodcode);
            
            return "/HKK_receipe/receipedeletePro.jsp";
         }
      }
   }
}