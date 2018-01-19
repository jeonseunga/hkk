package notice;

import java.sql.Timestamp;

public class NoticeDataBean {
	private int n_listnum = 0;
	private String n_title;
	private String n_content;
	private int n_level;
	private Timestamp n_reg_date;
	private String n_id;

	public int getN_level() {
		return n_level;
	}
	public void setN_level(int n_level) {
		this.n_level = n_level;
	}
	
	public int getN_listnum() {
		return n_listnum;
	}
	public void setN_listnum(int n_listnum) {
		this.n_listnum = n_listnum;
	}
	
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	
	public Timestamp getN_reg_date() {
		return n_reg_date;
	}
	public void setN_reg_date(Timestamp n_reg_date) {
		this.n_reg_date = n_reg_date;
	}
	
	public String getN_id() {
		return n_id;
	}
	public void setN_id(String n_id) {
		this.n_id = n_id;
	}
}
