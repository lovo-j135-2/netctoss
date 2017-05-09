package lovo.j135_2.netctoss.paymag.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Pay implements Serializable {
	private Long id;
	private String payName;
	private String payType;
	private int payTime;
	private BigDecimal basicCost;
	private BigDecimal unitCost;
	private String costDiscrip;
	private int payStatus;
	private Date createTime;
	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pay(String payName, String payType, int payTime, BigDecimal basicCost, BigDecimal unitCost,
			String costDiscrip, int payStatus) {
		super();
		this.payName = payName;
		this.payType = payType;
		this.payTime = payTime;
		this.basicCost = basicCost;
		this.unitCost = unitCost;
		this.costDiscrip = costDiscrip;
		this.payStatus = payStatus;
	}

	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public int getPayTime() {
		return payTime;
	}
	public void setPayTime(int payTime) {
		this.payTime = payTime;
	}
	public BigDecimal getBasicCost() {
		return basicCost;
	}
	public void setBasicCost(BigDecimal basicCost) {
		this.basicCost = basicCost;
	}
	public BigDecimal getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
	public String getCostDiscrip() {
		return costDiscrip;
	}
	public void setCostDiscrip(String costDiscrip) {
		this.costDiscrip = costDiscrip;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	@Override
	public String toString() {
		return "Pay [id=" + id + ", payName=" + payName + ", payType=" + payType + ", payTime=" + payTime
				+ ", basicCost=" + basicCost + ", unitCost=" + unitCost + ", costDiscrip=" + costDiscrip
				+ ", payStatus=" + payStatus + ", createTime=" + createTime + "]";
	}
	
}
