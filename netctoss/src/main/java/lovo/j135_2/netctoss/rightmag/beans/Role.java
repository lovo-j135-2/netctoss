package lovo.j135_2.netctoss.rightmag.beans;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String roleType;
	private List<Right>rights;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(long id, String name, String roleType, List<Right> rights) {
		super();
		this.id = id;
		this.name = name;
		this.roleType = roleType;
		this.rights = rights;
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
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public List<Right> getRights() {
		return rights;
	}
	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", roleType=" + roleType + ", rights=" + rights + "]";
	}
	
	
}
