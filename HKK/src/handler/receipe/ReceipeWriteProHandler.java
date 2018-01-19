package handler.receipe;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.CommandHandler;
import receipe.FoodContentDBBean;
import receipe.FoodContentDataBean;
import receipe.FoodWriteDBBean;
import receipe.FoodWriteDataBean;

public class ReceipeWriteProHandler implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String path = request.getSession().getServletContext().getRealPath("/upload");
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		MultipartRequest multi = new MultipartRequest(
		request, path, 1024*1024*50, "utf-8", new DefaultFileRenamePolicy());
		
		int count = Integer.parseInt(multi.getParameter("count"));
		ArrayList<String> image_path = new ArrayList<String>();
		ArrayList<String> content = new ArrayList<String>();
		
		FoodWriteDataBean writeDto = new FoodWriteDataBean();
		writeDto.setFood_title(multi.getParameter("food_title"));
		writeDto.setFood_reg_date(new Timestamp(System.currentTimeMillis()));
		writeDto.setFood_readcount(Integer.parseInt(multi.getParameter("food_readcount")));
		writeDto.setFood_id((String)request.getSession().getAttribute("memId"));
		writeDto.setFood_code(Integer.parseInt(multi.getParameter("foodcode")));
		int food_code = Integer.parseInt(multi.getParameter("foodcode"));
		
		FoodWriteDBBean writeDao = FoodWriteDBBean.getInstance();
		FoodContentDBBean contentDao = FoodContentDBBean.getInstance();
		int result = writeDao.insertArticle(writeDto);
		int connum = 0;
		FoodContentDataBean contentDto = null;
		if(result == 1) {
			connum = writeDao.getArticle(writeDto);
			for(int i=0; i < count; i++) {
				contentDto = new FoodContentDataBean();
				image_path.add(multi.getFilesystemName("image_"+ i));
				content.add(multi.getParameter("content_" + i));
				contentDto.setFood_content(content.get(i));
				contentDto.setFood_image_path(image_path.get(i));
				String video = multi.getParameter("food_video_path");
				String video_path = null;
				if(video.length() > 11) {
		               video_path = video.substring(video.length()-11, video.length());
		            }else {
		               video_path = video;
		        }
				contentDto.setFood_video_path(video_path);
				contentDto.setFood_c_connum(connum);
				contentDao = FoodContentDBBean.getInstance();
				result = contentDao.insertArticle(contentDto);
			}
		}
		/* 이미지 작게 만들기
		if(result == 1) {
			int resultCheck = writeDao.getArticle(writeDto);

			FoodContentDataBean contentDto = new FoodContentDataBean();
			for(int i=0; i < count; i++) {
			//	String filename = multi.getOriginalFileName("image_"+i); �썝蹂몄궗吏꾨챸
				String systemname = multi.getFilesystemName("image_"+i);

				String oname = path + "\\" + systemname; // �썝蹂� �씠誘몄� 寃쎈줈 �꽕�젙
				String tname = path + "\\s" + systemname; // �꽟�꽕�씪 �씠誘몄� 寃쎈줈 �꽕�젙
				//�궗吏꾪겕湲� �썝蹂몃낫�떎 以꾩씠湲�
				RenderedOp op = JAI.create("fileload",oname);

				BufferedImage obuffer = op.getAsBufferedImage(); // �썝蹂� �씠誘몄� �씫�뼱�삤湲�
				int width = obuffer.getWidth(); // �썝蹂� �씠誘몄� 媛�濡쒓만�씠 諛섑솚
				int height = obuffer.getHeight(); // �썝蹂� �씠誘몄� �꽭濡� 湲몄씠 諛섑솚
				int size = 4; // 鍮꾩쑉 �꽕�젙 �닽�옄
				int twidth = width / size;
				int theight = height / size;
				
				BufferedImage tbuffer = new BufferedImage(twidth, theight, BufferedImage.TYPE_INT_RGB); // �꽟�꽕�씪 �씠誘몄� �씫�뼱�삤湲�
				
				Graphics2D g = (Graphics2D)tbuffer.getGraphics(); // �씠誘몄� 洹몃━湲곗쐞�븳 媛앹껜 �깮�꽦
				g.drawImage(obuffer, 0, 0, twidth, theight, null); // �씠誘몄� 洹몃━湲� 利� �씠誘몄�瑜� �빐�떦 鍮꾩쑉濡� 以꾩씠湲�
				
				ImageIO.write(tbuffer, "jpg", new File(tname));
				
				image_path.add("s"+systemname);
				content.add(multi.getParameter("content_" + i));

				contentDto.setFood_content(content.get(i));
				contentDto.setFood_image_path(image_path.get(i));
				contentDto.setFood_video_path(multi.getParameter("food_video_path"));
				contentDto.setFood_c_connum(resultCheck);
				
				FoodContentDBBean contentDao = FoodContentDBBean.getInstance();
				result = contentDao.insertArticle(contentDto);
				
				request.setAttribute("result", result);
			}
		}
		*/
		request.setAttribute("result", result);
		request.setAttribute("connum", connum);
		request.setAttribute("food_code", food_code);
		
		return "/HKK_receipe/receipewritePro.jsp";
	}
}
