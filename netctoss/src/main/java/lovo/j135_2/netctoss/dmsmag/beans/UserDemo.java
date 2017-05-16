package lovo.j135_2.netctoss.dmsmag.beans;

import java.io.Serializable;

public class UserDemo implements Serializable {
	
	private Long businessName;
	private String password;
	public UserDemo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDemo(Long businessName, String password) {
		super();
		this.businessName = businessName;
		this.password = password;
	}
	public Long getBusinessName() {
		return businessName;
	}
	public void setBusinessName(Long businessName) {
		this.businessName = businessName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDemo [businessName=" + businessName + ", password=" + password + "]";
	}
	
}
