package lovo.j135_2.netctoss.accoutmag.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class DayCost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -756326681721318176L;

	private Long id;;
	private Date sqlBeginTime;
	private String beginTime;
	private Date sqlEndTime;
	private String endTime;
	private int year;
	private int month;
	private int time;
	private BigDecimal cost;
	private String payType;
	
	public DayCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DayCost(Long id, Date sqlBeginTime, String beginTime, Date sqlEndTime, String endTime, int year,
			int month, int time, BigDecimal cost, String payType) {
		super();
		this.id = id;
		this.sqlBeginTime = sqlBeginTime;
		this.beginTime = beginTime;
		this.sqlEndTime = sqlEndTime;
		this.endTime = endTime;
		this.year = year;
		this.month = month;
		this.time = time;
		this.cost = cost;
		this.payType = payType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSqlBeginTime() {
		return sqlBeginTime;
	}

	public void setSqlBeginTime(Date sqlBeginTime) {
		this.sqlBeginTime = sqlBeginTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public Date getSqlEndTime() {
		return sqlEndTime;
	}

	public void setSqlEndTime(Date sqlEndTime) {
		this.sqlEndTime = sqlEndTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Override
	public String toString() {
		return "DayCostAccount [id=" + id + ", sqlBeginTime=" + sqlBeginTime + ", beginTime=" + beginTime
				+ ", sqlEndTime=" + sqlEndTime + ", endTime=" + endTime + ", year=" + year + ", month=" + month
				+ ", time=" + time + ", cost=" + cost + ", payType=" + payType + "]";
	}
	
	
}
