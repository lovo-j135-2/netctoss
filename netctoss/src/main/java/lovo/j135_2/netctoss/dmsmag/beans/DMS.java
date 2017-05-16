package lovo.j135_2.netctoss.dmsmag.beans;

import java.io.Serializable;
import java.util.Date;

public class DMS implements Serializable {

	private Long id;
	private Date beginTime;
	private Date endTime;
	private Long businessId;
	private String ip;
	private Long accountId;
	public DMS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DMS(Date beginTime, Date endTime, Long businessId, String ip, Long accountId) {
		super();
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.businessId = businessId;
		this.ip = ip;
		this.accountId = accountId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "DMS [id=" + id + ", beginTime=" + beginTime + ", endTime=" + endTime + ", businessId=" + businessId
				+ ", ip=" + ip + ", accountId=" + accountId + "]";
	}
}
