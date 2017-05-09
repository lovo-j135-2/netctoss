package lovo.j135_2.netctoss.billmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lovo.j135_2.netctoss.usermag.beans.Business;

public class DayCostBussiness implements Serializable {

	private Long id;
	private int year;
	private int month;
	private int time;
	private int day;
	private BigDecimal cost;
	private String payType;
	private Date beginTime;
	private Date endTime;
	private MonthCostBussiness monthBussiness;
	private Business bussiness;
	public DayCostBussiness() {
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
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
	public MonthCostBussiness getMonthBussiness() {
		return monthBussiness;
	}
	public void setMonthBussiness(MonthCostBussiness monthBussiness) {
		this.monthBussiness = monthBussiness;
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
				+ ", cost=" + cost + ", payType=" + payType + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", monthBussiness=" + monthBussiness + "]";
	}
	
}
