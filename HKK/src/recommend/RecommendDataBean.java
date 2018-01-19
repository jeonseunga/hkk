package recommend;

import java.sql.Timestamp;

public class RecommendDataBean {
	private int r_connum;
	private Timestamp r_reg_date;
	private int r_readcount;
	private String r_title;
	private String r_id;
	public int getR_connum() {
		return r_connum;
	}
	public void setR_connum(int r_connum) {
		this.r_connum = r_connum;
	}
	public Timestamp getR_reg_date() {
		return r_reg_date;
	}
	public void setR_reg_date(Timestamp r_reg_date) {
		this.r_reg_date = r_reg_date;
	}
	public int getR_readcount() {
		return r_readcount;
	}
	public void setR_readcount(int r_readcount) {
		this.r_readcount = r_readcount;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	
}
