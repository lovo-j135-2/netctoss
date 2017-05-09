package lovo.j135_2.netctoss.labmag.bean;

import java.io.Serializable;

public class DayTimeFiles implements Serializable {

	private Long id;
	private Long accountId;
	private int year;
	private int month;
	private int day;
	private int time;//分钟数
	private String ip;
	public DayTimeFiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DayTimeFiles(Long accountId, int year, int month, int day, int time, String ip) {
		super();
		accountId = accountId;
		this.year = year;
		this.month = month;
		this.day = day;
		this.time = time;
		this.ip = ip;
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "DayTimeFiles [id=" + id + ", accountId=" + accountId + ", year=" + year + ", month=" + month + ", day="
				+ day + ", time=" + time + ", ip=" + ip + "]";
	}
}
