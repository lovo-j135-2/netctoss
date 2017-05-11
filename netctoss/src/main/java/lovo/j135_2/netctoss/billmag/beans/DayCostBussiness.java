package lovo.j135_2.netctoss.billmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Business;

public class DayCostBussiness implements Serializable {

	private Long id;
	private int year;
	private int month;
	private int time;
	private int day;
	private BigDecimal unitCost;
	private String payType;
	private Date beginTime;
	private Date endTime;
	private Long accountId;
	private Business bussiness;
	private String ip;
	
	public DayCostBussiness() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DayCostBussiness(int year, int month, int time, int day, BigDecimal unitCost, String payType, Date beginTime,
			Date endTime, Long accountId, String ip) {
		super();
		this.year = year;
		this.month = month;
		this.time = time;
		this.day = day;
		this.unitCost = unitCost;
		this.payType = payType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.accountId = accountId;
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
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
	
	public Long getAccountId() {
		return accountId;
	}



	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}



	public Business getBussiness() {
		return bussiness;
	}
	public void setBussiness(Business bussiness) {
		this.bussiness = bussiness;
	}

	@Override
	public String toString() {
		return "DayCostBussiness [id=" + id + ", year=" + year + ", month=" + month + ", time=" + time + ", day=" + day
				+ ", unitCost=" + unitCost + ", payType=" + payType + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", accountId=" + accountId + ", bussiness=" + bussiness + ", ip=" + ip + "]";
	}
}
