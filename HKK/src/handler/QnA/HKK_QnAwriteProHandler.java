package handler.QnA;

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
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import QnA.HKK_qna;
import QnA.QnADBBean;

import com.oreilly.servlet.MultipartRequest;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


public class HKK_QnAwriteProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		HKK_qna QnADto = new HKK_qna();	
		QnADto.setQ_connum(Integer.parseInt(request.getParameter("q_connum")));
		QnADto.setQ_title(request.getParameter("q_title"));
		QnADto.setQ_pw(request.getParameter("pw"));
		QnADto.setQ_content(request.getParameter("q_content"));
		QnADto.setQ_reg_date(new Timestamp(System.currentTimeMillis()));
		QnADto.setQ_id((String)request.getSession().getAttribute("memId"));
		QnADBBean QnADao = QnADBBean.getInstance();
		int result = QnADao.insertArticle(QnADto);
		request.setAttribute("result", result);
		
		return "/HKK_QnA/HKK_QnAwritePro.jsp";
	}	
}

