package receipe;

import java.sql.Timestamp;

public class FoodReplyDataBean {
	private int food_renum = 0;
	private String food_recontent = null;
	private Timestamp food_r_reg_date = null;
	private String food_r_id = null;
	private int food_r_connum = 0;
	private int food_r_code = 0;
	
	public int getFood_r_code() {
		return food_r_code;
	}
	public void setFood_r_code(int food_r_code) {
		this.food_r_code = food_r_code;
	}
	public int getFood_renum() {
		return food_renum;
	}
	public void setFood_renum(int food_renum) {
		this.food_renum = food_renum;
	}
	
	public String getFood_recontent() {
		return food_recontent;
	}
	public void setFood_recontent(String food_recontent) {
		this.food_recontent = food_recontent;
	}
	
	public Timestamp getFood_r_reg_date() {
		return food_r_reg_date;
	}
	public void setFood_r_reg_date(Timestamp food_r_reg_date) {
		this.food_r_reg_date = food_r_reg_date;
	}
	
	public String getFood_r_id() {
		return food_r_id;
	}
	public void setFood_r_id(String food_r_id) {
		this.food_r_id = food_r_id;
	}
	
	public int getFood_r_connum() {
		return food_r_connum;
	}
	public void setFood_r_connum(int food_r_connum) {
		this.food_r_connum = food_r_connum;
	}
}
