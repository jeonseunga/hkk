package QnA;

import java.sql.Timestamp;

public class HKK_qna {
	private int q_connum;
	private String q_title;
	private String q_pw;
	private String q_content;
	private Timestamp q_reg_date;
	private String q_id;
	public int getQ_connum() {
		return q_connum;
	}
	public void setQ_connum(int q_connum) {
		this.q_connum = q_connum;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_pw() {
		return q_pw;
	}
	public void setQ_pw(String q_pw) {
		this.q_pw = q_pw;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public Timestamp getQ_reg_date() {
		return q_reg_date;
	}
	public void setQ_reg_date(Timestamp q_reg_date) {
		this.q_reg_date = q_reg_date;
	}
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}
	
}
