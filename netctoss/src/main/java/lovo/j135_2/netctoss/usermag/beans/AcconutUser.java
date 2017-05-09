package lovo.j135_2.netctoss.usermag.beans;

import java.io.Serializable;

public class AcconutUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7318226809198610976L;
	
	private Long id;
	private String real_name;
	private String id_num;
	private String password;
	private int gender;
	private String account_name;
	private String phone;
	private String address;
	private String postcode;
	private String qq;
	private int status;
	public AcconutUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AcconutUser(String real_name, String id_num, String password, int gender, String account_name, String phone,
			String address, String postcode, String qq, int status) {
		super();
		this.real_name = real_name;
		this.id_num = id_num;
		this.password = password;
		this.gender = gender;
		this.account_name = account_name;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		this.qq = qq;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AcconutUser [real_name=" + real_name + ", id_num=" + id_num + ", password=" + password + ", gender="
				+ gender + ", account_name=" + account_name + ", phone=" + phone + ", address=" + address
				+ ", postcode=" + postcode + ", qq=" + qq + ", status=" + status + "]";
	}
}
