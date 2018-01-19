package QnA;

import java.sql.Timestamp;

public class HKK_q_reply {
	private int q_renum;
	private String q_recontent;
	private Timestamp q_r_reg_date;
	private String q_r_id;
	private int q_r_connum;
	public int getQ_renum() {
		return q_renum;
	}
	public void setQ_renum(int q_renum) {
		this.q_renum = q_renum;
	}
	public String getQ_recontent() {
		return q_recontent;
	}
	public void setQ_recontent(String q_recontent) {
		this.q_recontent = q_recontent;
	}
	public Timestamp getQ_r_reg_date() {
		return q_r_reg_date;
	}
	public void setQ_r_reg_date(Timestamp q_r_reg_date) {
		this.q_r_reg_date = q_r_reg_date;
	}
	public String getQ_r_id() {
		return q_r_id;
	}
	public void setQ_r_id(String q_r_id) {
		this.q_r_id = q_r_id;
	}
	public int getQ_r_connum() {
		return q_r_connum;
	}
	public void setQ_r_connum(int q_r_connum) {
		this.q_r_connum = q_r_connum;
	}
	
}
