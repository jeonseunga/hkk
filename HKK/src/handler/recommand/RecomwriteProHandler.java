package handler.recommand;

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
import com.oreilly.servlet.MultipartRequest;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


public class RecomwriteProHandler  implements CommandHandler{

	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		String path = request.getSession().getServletContext().getRealPath("/upload");
		String id = (String)request.getSession().getAttribute("memId");
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}

		MultipartRequest multi = new MultipartRequest(
		request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());

		ArrayList<String> r_image_path = new ArrayList<String>();
		ArrayList<String> r_content = new ArrayList<String>();
		
		RecommendDataBean RecomDto = new RecommendDataBean();	
		RecomDto.setR_connum(Integer.parseInt(multi.getParameter("r_connum")));
		RecomDto.setR_title(multi.getParameter("r_title"));
		RecomDto.setR_reg_date(new Timestamp(System.currentTimeMillis()));
		RecomDto.setR_id(id);
		RecommendDBBean RecomDao = RecommendDBBean.getInstance();
		int result = RecomDao.insertArticle(RecomDto); 
		
		int count = Integer.parseInt(multi.getParameter("count"));
		if(result == 1) {
			int resultcheck = RecomDao.getconnum(RecomDto);
			int check = 0;
			HKK_recommendcontent RecomContentDto = new HKK_recommendcontent();
			for(int i =0; i < count; i++) {
				String systemname = multi.getFilesystemName("image_"+i);
				if(systemname == null || systemname.equals("")) {
					r_image_path.add("");
				} else {
					String oname = path + "/" + systemname; // 원본 이미지 경로 설정
					String tname = path + "/s" + systemname; // 섬네일 이미지 경로 설정
					RenderedOp op = JAI.create("fileload",oname);

					BufferedImage obuffer = op.getAsBufferedImage(); // 원본 이미지 읽어오기
					int width = obuffer.getWidth(); // 원본 이미지 가로길이 반환
					int height = obuffer.getHeight(); // 원본 이미지 세로 길이 반환
					int size = 4; // 비율 설정 숫자
					int twidth = width / size;
					int theight = height / size;
					
					BufferedImage tbuffer = new BufferedImage(twidth, theight, BufferedImage.TYPE_INT_RGB); // 섬네일 이미지 읽어오기
					
					Graphics2D g = (Graphics2D)tbuffer.getGraphics(); // 이미지 그리기위한 객체 생성
					g.drawImage(obuffer, 0, 0, twidth, theight, null); // 이미지 그리기 즉 이미지를 해당 비율로 줄이기
					ImageIO.write(tbuffer, "jpg", new File(tname));
					r_image_path.add("s"+systemname);
				} 
				r_content.add(multi.getParameter("content_" + i));
				RecomContentDto.setR_content(r_content.get(i));
				RecomContentDto.setR_c_connum(resultcheck);
				RecomContentDto.setR_image_path(r_image_path.get(i));
				check = RecomDao.insertArticle(RecomContentDto);
				request.setAttribute("check", check);
			}
		}
		return "/RecommendFile/RecomwritePro.jsp";
	}	
}

