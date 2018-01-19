package receipe;

public class FoodContentDataBean {
	private int food_listnum = 0;
	private String food_content = null;
	private String food_image_path = null;
	private String food_video_path = null;
	private int food_c_connum = 0;
	
	public int getFood_listnum() {
		return food_listnum;
	}
	public void setFood_listnum(int food_listnum) {
		this.food_listnum = food_listnum;
	}
	
	public String getFood_content() {
		return food_content;
	}
	public void setFood_content(String food_content) {
		this.food_content = food_content;
	}
	
	public String getFood_image_path() {
		return food_image_path;
	}
	public void setFood_image_path(String food_image_path) {
		this.food_image_path = food_image_path;
	}
	
	public String getFood_video_path() {
		return food_video_path;
	}
	public void setFood_video_path(String food_video_path) {
		this.food_video_path = food_video_path;
	}
	
	public int getFood_c_connum() {
		return food_c_connum;
	}
	public void setFood_c_connum(int food_c_connum) {
		this.food_c_connum = food_c_connum;
	}
}
