package handler.todayHKK;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.CommandHandler;
import todayhkk.TodayHKKDBBean;
import todayhkk.TodayHKKDataBean;

public class TodayhkkproHandler implements CommandHandler{
public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		

		request.setCharacterEncoding("utf-8");
		
		TodayHKKDataBean todayhkkDto = new TodayHKKDataBean();
		
		//String t_content = request.getParameter("t_content");
		//t_content = new String(t_content.getBytes("8859_1"),"utf-8");
		//�̹���
		
		String path = request.getSession().getServletContext().getRealPath("/upload");
		String id = (String)request.getSession().getAttribute("memId");
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		
		MultipartRequest multi = new MultipartRequest(
				request, path, 1*1024*1024, "utf-8", new DefaultFileRenamePolicy()); //1MB = 1000KB ���� ũ�� ���� 
		//�̹��� ũ�� ū�� ������ ���â �����

		String filename = multi.getOriginalFileName("image");
		String systemname = multi.getFilesystemName("image");
		
		if( multi.getFile("image") == null ){
			
			todayhkkDto.setT_image_path("");
			
		}else{
			
			String oname = path + "/" + systemname;
			String tname = path + "/s" + systemname;
			
			RenderedOp op = JAI.create("fileload", oname);
			BufferedImage obuffer = op.getAsBufferedImage();
			int width = obuffer.getWidth();
			int height = obuffer.getHeight();
			int SIZE = 4 ;
			int twidth = width / SIZE;
			int theight = height / SIZE;
			
			BufferedImage tbuffer = new BufferedImage(twidth, theight, BufferedImage.TYPE_INT_RGB);//�̹��� �о��
			Graphics2D g = (Graphics2D) tbuffer.getGraphics(); // �氡���ͼ�
			g.drawImage(obuffer, 0, 0, twidth, theight, null );//���� �׷���!!
			
			ImageIO.write(tbuffer, "jpg", new File(tname));//����� �̹��� �������
			
			todayhkkDto.setT_image_path("/s"+systemname);
			
		}
		//System.out.println(t_content +"����");
		
		//todayhkkDto.setT_content(t_content);
		
		todayhkkDto.setT_id(id);
		todayhkkDto.setT_content(multi.getParameter("t_content"));
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String date = sdf.format(d);
		todayhkkDto.setT_reg_date(date);
		
		//todayhkkDto.setT_reg_date(new Timestamp(System.currentTimeMillis()));
	
		TodayHKKDBBean todayhkkDao = TodayHKKDBBean.getInstance();
		int result = todayhkkDao.insertHanKKI(todayhkkDto);
		
		request.setAttribute("result", result);
		
		

		
		return "/todayHKK/todayHKKPro.jsp";
	}
}
