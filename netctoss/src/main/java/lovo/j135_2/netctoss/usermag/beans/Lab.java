package lovo.j135_2.netctoss.usermag.beans;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
public class Lab implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5175219634764550172L;
	
	private Long id;
	private String ip_num;
	public Lab() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lab(Long id, String ip_num) {
		super();
		this.id = id;
		this.ip_num = ip_num;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp_num() {
		return ip_num;
	}
	public void setIp_num(String ip_num) {
		this.ip_num = ip_num;
	}
	@Override
	public String toString() {
		return "Lab [id=" + id + ", ip_num=" + ip_num + "]";
	}
	
	
	
}
