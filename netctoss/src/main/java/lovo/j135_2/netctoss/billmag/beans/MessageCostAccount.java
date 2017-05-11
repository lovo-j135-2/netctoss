package lovo.j135_2.netctoss.billmag.beans;

import java.io.Serializable;

public class MessageCostAccount implements Serializable {

	private String message;
	private boolean flag;
	public MessageCostAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageCostAccount(String message, boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "MessagePay [message=" + message + ", flag=" + flag + "]";
	}
	
}
