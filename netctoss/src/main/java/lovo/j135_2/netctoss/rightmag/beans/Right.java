package lovo.j135_2.netctoss.rightmag.beans;

import java.io.Serializable;

public class Right implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2573857924089706307L;

	private long id;
	private String name;
	private String discription;
	private String url;
	private long parentId;
	public Right() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Right(long id, String name, String discription, String url, long parentId) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.url = url;
		this.parentId = parentId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Right [id=" + id + ", name=" + name + ", discription=" + discription + ", url=" + url + ", parentId="
				+ parentId + "]";
	}
	
	
}
