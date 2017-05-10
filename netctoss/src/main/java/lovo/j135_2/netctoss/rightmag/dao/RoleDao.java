package lovo.j135_2.netctoss.rightmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.rightmag.beans.Role;

public interface RoleDao {
	/**
	 * 增加角色
	 */
	public void saveRole(Role role);
	
	/**
	 * 删除角色
	 */
	public void deleteRole(long id);
	
	/**
	 * 修改角色
	 * （如果修改了权限，那么对应的中间表的数据应该是先删除，然后重新添加修改之后选中的权限
	 */
	public void updateRole(Role role);
	
	/**
	 * 查询角色
	 */
	public List<Role> getRole(String roleName,String roleType);
}
