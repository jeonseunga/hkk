package member;

import java.sql.Timestamp;

public class LogonDataBean {
	
	private String id;
	private String pw;
	private String gender;
	private String email;
	private int memcode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMemcode() {
		return memcode;
	}
	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}
}
