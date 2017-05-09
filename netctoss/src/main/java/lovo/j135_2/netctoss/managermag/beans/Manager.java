package lovo.j135_2.netctoss.managermag.beans;

import java.io.Serializable;

import lovo.j135_2.netctoss.rightmag.beans.Role;

public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5569045374448835336L;

	private Long id;
	//管理员名称
	private String name;
	
	//管理员账号
	private String accounts;
	
	//管理员密码
	private String password;
	
	//管理员电话
	private String phone;
	
	//管理员邮箱
	private String postcode;
	
	//管理员角色
	private Role role;
	
	
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(Long id, String name, String accounts, String password, String phone, String postcode, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
		this.password = password;
		this.phone = phone;
		this.postcode = postcode;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", accounts=" + accounts + ", password=" + password + ", phone="
				+ phone + ", postcode=" + postcode + ", role=" + role + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
