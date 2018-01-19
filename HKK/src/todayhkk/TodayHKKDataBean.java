package todayhkk;

import java.sql.Timestamp;

public class TodayHKKDataBean {
	private int t_listnum = 0;
	private String t_content = null;
	private String t_image_path = null;
	private String t_reg_date = null;
	private String t_id = null;
	
	public int getT_listnum() {
		return t_listnum;
	}
	public void setT_listnum(int t_listnum) {
		this.t_listnum = t_listnum;
	}
	
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	
	public String getT_image_path() {
		return t_image_path;
	}
	public void setT_image_path(String t_image_path) {
		this.t_image_path = t_image_path;
	}
	
	public String getT_reg_date() {
		return t_reg_date;
	}
	public void setT_reg_date(String t_reg_date) {
		this.t_reg_date = t_reg_date;
	}
	
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
}
