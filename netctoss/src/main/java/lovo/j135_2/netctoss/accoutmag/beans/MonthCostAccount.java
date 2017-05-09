package lovo.j135_2.netctoss.accoutmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class MonthCostAccount implements Serializable {
	private Long id;
	private Long accountId;
	private int year;
	private int month;
	private int time;
	private BigDecimal cost;
	private int payStatus;
	public MonthCostAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	@Override
	public String toString() {
		return "MonthCostAccount [id=" + id + ", accountId=" + accountId + ", year=" + year + ", month=" + month
				+ ", time=" + time + ", cost=" + cost + ", payStatus=" + payStatus + "]";
	}
	
}
