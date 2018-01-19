package receipe;

import java.sql.Timestamp;

public class FoodWriteDataBean {
	private int food_connum = 0;
	private String food_title = null;
	private Timestamp food_reg_date = null;
	private int food_readcount = 0;
	private String food_id = null;
	private int food_code = 0;
	
	public int getFood_connum() {
		return food_connum;
	}
	public void setFood_connum(int food_connum) {
		this.food_connum = food_connum;
	}
	
	public String getFood_title() {
		return food_title;
	}
	public void setFood_title(String food_title) {
		this.food_title = food_title;
	}
	
	public Timestamp getFood_reg_date() {
		return food_reg_date;
	}
	public void setFood_reg_date(Timestamp food_reg_date) {
		this.food_reg_date = food_reg_date;
	}
	
	public int getFood_readcount() {
		return food_readcount;
	}
	public void setFood_readcount(int food_readcount) {
		this.food_readcount = food_readcount;
	}
	
	public String getFood_id() {
		return food_id;
	}
	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}
	
	public int getFood_code() {
		return food_code;
	}
	public void setFood_code(int food_code) {
		this.food_code = food_code;
	}
}
