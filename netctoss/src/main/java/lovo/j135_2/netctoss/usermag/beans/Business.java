package lovo.j135_2.netctoss.usermag.beans;

import java.io.Serializable;

import lovo.j135_2.netctoss.paymag.beans.Pay;


public class Business implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7392409259437254963L;
	
	private Long id;
	private String business_name;
	private String password;
	private AcconutUser fk_accountuser_id;
	private Pay pay;
	private Lab lab;
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Business(String business_name, String password, AcconutUser fk_accountuser_id, Pay pay, Lab lab) {
		super();
		this.business_name = business_name;
		this.password = password;
		this.fk_accountuser_id = fk_accountuser_id;
		this.pay = pay;
		this.lab = lab;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AcconutUser getFk_accountuser_id() {
		return fk_accountuser_id;
	}
	public void setFk_accountuser_id(AcconutUser fk_accountuser_id) {
		this.fk_accountuser_id = fk_accountuser_id;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public Lab getLab() {
		return lab;
	}
	public void setLab(Lab lab) {
		this.lab = lab;
	}
	@Override
	public String toString() {
		return "Business [id=" + id + ", business_name=" + business_name + ", password=" + password
				+ ", fk_accountuser_id=" + fk_accountuser_id + ", pay=" + pay + ", lab=" + lab + "]";
	}
//	@Override
//	public String toString() {
//		return "Business [id=" + id + ", business_name=" + business_name + ", password=" + password + "]";
//	}
	
	
}
