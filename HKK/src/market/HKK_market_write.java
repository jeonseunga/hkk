package market;

import java.sql.Timestamp;

public class HKK_market_write {
	private int m_connum;
	private String m_title;
	private Timestamp m_reg_date;
	private int m_readcount;
	private String m_id;
	public int getM_connum() {
		return m_connum;
	}
	public void setM_connum(int m_connum) {
		this.m_connum = m_connum;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public Timestamp getM_reg_date() {
		return m_reg_date;
	}
	public void setM_reg_date(Timestamp m_reg_date) {
		this.m_reg_date = m_reg_date;
	}
	public int getM_readcount() {
		return m_readcount;
	}
	public void setM_readcount(int m_readcount) {
		this.m_readcount = m_readcount;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
}
