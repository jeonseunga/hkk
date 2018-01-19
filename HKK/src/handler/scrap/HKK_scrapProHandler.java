package handler.scrap;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import recommend.HKK_recommendcontent;
import recommend.RecommendDBBean;
import recommend.RecommendDataBean;
import scrap.HKK_scrap;
import scrap.scrapDBBean;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


public class HKK_scrapProHandler  implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		System.out.println("스크립");
		String path = request.getSession().getServletContext().getRealPath("/upload");
		String s_id = (String)request.getSession().getAttribute("memId");
		int foodcode = Integer.parseInt(request.getParameter("food_code"));
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}

		int s_connum = Integer.parseInt(request.getParameter("s_connum"));
		String r_image_path = request.getParameter("s_img_path");
		
		HKK_scrap scrapDto = new HKK_scrap();	
		scrapDto.setS_connum(s_connum);
		scrapDto.setS_r_title(request.getParameter("s_r_title"));
		scrapDto.setS_id(s_id);
		scrapDto.setS_r_id(request.getParameter("s_r_id"));
		scrapDto.setS_img_path(r_image_path);
		scrapDto.setS_foodcode(foodcode);
		scrapDBBean scrapDao = scrapDBBean.getInstance();
		int result = scrapDao.insertArticle(scrapDto); 
		
		request.setAttribute("result", result);
		request.setAttribute("s_connum", s_connum);
		request.setAttribute("foodcode", foodcode);
	
		return "/HKK_Scrap/HKK_scrapPro.jsp";
	}	
}

