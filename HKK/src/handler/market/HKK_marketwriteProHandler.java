package handler.market;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.CommandHandler;
import market.HKK_market_write;
import market.HKK_marketcontent;
import market.marketDBBean;
import recommend.HKK_recommendcontent;
import recommend.RecommendDBBean;
import recommend.RecommendDataBean;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


public class HKK_marketwriteProHandler implements CommandHandler{

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

		ArrayList<String> m_image_path = new ArrayList<String>();
		ArrayList<String> m_content = new ArrayList<String>();
		
		HKK_market_write MarketDto = new HKK_market_write();	
		MarketDto.setM_connum(Integer.parseInt(multi.getParameter("m_connum")));
		MarketDto.setM_title(multi.getParameter("m_title"));
		MarketDto.setM_reg_date(new Timestamp(System.currentTimeMillis()));
		MarketDto.setM_id(id);
		marketDBBean MKDao = marketDBBean.getInstance();
		int result = MKDao.insertArticle(MarketDto); 
		
		int count = Integer.parseInt(multi.getParameter("count"));

		if(result == 1) {
			int resultcheck = MKDao.getconnum(MarketDto);

			int check = 0;
			HKK_marketcontent MKcontentDto = new HKK_marketcontent();
			for(int i =0; i < count; i++) {
				String systemname = multi.getFilesystemName("image_"+i);
				if(systemname == null || systemname.equals("")) {
					m_image_path.add("");
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
						m_image_path.add("s"+systemname);
				} 
				m_content.add(multi.getParameter("content_" + i));
				MKcontentDto.setM_listnum(i);
				MKcontentDto.setM_content(m_content.get(i));
				MKcontentDto.setM_c_connum(resultcheck);
				MKcontentDto.setM_image_path(m_image_path.get(i));
				check = MKDao.insertArticle(MKcontentDto);
				request.setAttribute("check", check);
			}
		}
		return "/HKK_MarketFile/HKK_marketwritePro.jsp";
	}	
}

