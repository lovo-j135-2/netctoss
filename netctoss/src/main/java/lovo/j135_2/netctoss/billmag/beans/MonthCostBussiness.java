package lovo.j135_2.netctoss.billmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import lovo.j135_2.netctoss.accoutmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.usermag.beans.Business;

public class MonthCostBussiness implements Serializable {

	private Long id;
	private int year;
	private int month;
	private int time;
	private BigDecimal cost;
	private String ip;
	private String payType;
	private MonthCostAccount accout;
	private Business bussiness;
	public MonthCostBussiness() {
		super();
		// TODO Auto-generated constructor stub
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
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public MonthCostAccount getAccout() {
		return accout;
	}
	public void setAccout(MonthCostAccount accout) {
		this.accout = accout;
	}
	
	public Business getBussiness() {
		return bussiness;
	}
	public void setBussiness(Business bussiness) {
		this.bussiness = bussiness;
	}
	@Override
	public String toString() {
		return "MonthCostBussiness [id=" + id + ", year=" + year + ", month=" + month + ", time=" + time + ", cost="
				+ cost + ", ip=" + ip + ", payType=" + payType + ", accout=" + accout + "]";
	}
}
