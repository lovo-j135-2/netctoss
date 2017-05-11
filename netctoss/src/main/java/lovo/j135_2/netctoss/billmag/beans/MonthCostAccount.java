package lovo.j135_2.netctoss.billmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class MonthCostAccount implements Serializable {
	private Long id;
	private Long accountId;
	private int year;
	private int month;
	private BigDecimal cost;
	private int payStatus;
	private int payWay;
	public MonthCostAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
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
				+ ", cost=" + cost + ", payStatus=" + payStatus + ", payWay=" + payWay + "]";
	}
}
