package lovo.j135_2.netctoss.logmag.beans;

import java.io.Serializable;
import java.util.Date;

public class OperateLogBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5379813669020927753L;
	
	private Long id;
	private String account;
	private String operateType;
	private String operateClass;
	private String operateMethod;
	private String operateParam;
	private String operateOldValue;
	private Date operateTime;
	private LoginLogBean loginLog;
	
	public OperateLogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperateLogBean(Long id, String account, String operateType, String operateClass, String operateMethod,
			String operateParam, String operateOldValue, Date operateTime, LoginLogBean loginLog) {
		super();
		this.id = id;
		this.account = account;
		this.operateType = operateType;
		this.operateClass = operateClass;
		this.operateMethod = operateMethod;
		this.operateParam = operateParam;
		this.operateOldValue = operateOldValue;
		this.operateTime = operateTime;
		this.loginLog = loginLog;
	}
	@Override
	public String toString() {
		return "OperateLogBean [id=" + id + ", account=" + account + ", operateType=" + operateType + ", operateClass="
				+ operateClass + ", operateMethod=" + operateMethod + ", operateParam=" + operateParam
				+ ", operateOldValue=" + operateOldValue + ", operateTime=" + operateTime + ", loginLog=" + loginLog
				+ "]";
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
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getOperateClass() {
		return operateClass;
	}
	public void setOperateClass(String operateClass) {
		this.operateClass = operateClass;
	}
	public String getOperateMethod() {
		return operateMethod;
	}
	public void setOperateMethod(String operateMethod) {
		this.operateMethod = operateMethod;
	}
	public String getOperateParam() {
		return operateParam;
	}
	public void setOperateParam(String operateParam) {
		this.operateParam = operateParam;
	}
	public String getOperateOldValue() {
		return operateOldValue;
	}
	public void setOperateOldValue(String operateOldValue) {
		this.operateOldValue = operateOldValue;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public LoginLogBean getLoginLog() {
		return loginLog;
	}
	public void setLoginLog(LoginLogBean loginLog) {
		this.loginLog = loginLog;
	}
	
	
}
