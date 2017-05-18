package lovo.j135_2.netctoss.accoutmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import lovo.j135_2.netctoss.usermag.beans.Business;

public class MonthBusiness implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 910696932431768524L;

	private Long id;
	private int year;
	private int month;
	private int time;
	private BigDecimal cost;
	private String ip;
	private String payType;
	private Long monthCostAccoutId;
	private Long bussinessId;
	public MonthBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthBusiness(Long id, int year, int month, int time, BigDecimal cost, String ip, String payType,
			Long monthCostAccoutId, Long bussinessId) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.time = time;
		this.cost = cost;
		this.ip = ip;
		this.payType = payType;
		this.monthCostAccoutId = monthCostAccoutId;
		this.bussinessId = bussinessId;
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
	public Long getMonthCostAccoutId() {
		return monthCostAccoutId;
	}
	public void setMonthCostAccoutId(Long monthCostAccoutId) {
		this.monthCostAccoutId = monthCostAccoutId;
	}
	public Long getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(Long bussinessId) {
		this.bussinessId = bussinessId;
	}
	@Override
	public String toString() {
		return "MonthCostBusiness [id=" + id + ", year=" + year + ", month=" + month + ", time=" + time + ", cost="
				+ cost + ", ip=" + ip + ", payType=" + payType + ", monthCostAccoutId=" + monthCostAccoutId
				+ ", bussinessId=" + bussinessId + "]";
	}
	
	
}
