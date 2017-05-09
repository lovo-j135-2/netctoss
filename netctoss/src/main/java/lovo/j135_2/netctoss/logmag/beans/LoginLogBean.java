package lovo.j135_2.netctoss.logmag.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LoginLogBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6998560412601630540L;
	
	private Long id;
	private String account;
	private Date loginTime;
	private List<OperateLogBean> operateLogs;
	
	public LoginLogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginLogBean(Long id, String account, Date loginTime, List<OperateLogBean> operateLogs) {
		super();
		this.id = id;
		this.account = account;
		this.loginTime = loginTime;
		this.operateLogs = operateLogs;
	}
	@Override
	public String toString() {
		return "LoginLogBean [id=" + id + ", account=" + account + ", loginTime=" + loginTime + ", operateLogs="
				+ operateLogs + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public List<OperateLogBean> getOperateLogs() {
		return operateLogs;
	}
	public void setOperateLogs(List<OperateLogBean> operateLogs) {
		this.operateLogs = operateLogs;
	}	
	
}
