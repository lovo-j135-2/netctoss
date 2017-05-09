package lovo.j135_2.netctoss.pojos;

public class Messager {
	private boolean status;
	private String msg;
	
	public Messager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Messager(boolean status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Messager [status=" + status + ", msg=" + msg + "]";
	}
	
	
	
	
	
}
