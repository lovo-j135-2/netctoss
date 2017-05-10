package lovo.j135_2.netctoss.rightmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.rightmag.beans.Role;
import lovo.j135_2.netctoss.rightmag.dao.RoleDao;
import lovo.j135_2.netctoss.rightmag.mapper.RoleMapper;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Resource
	private RoleMapper rolemapper;
	
	
	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		rolemapper.saveRole(role);
	}

	@Override
	public void deleteRole(long id) {
		// TODO Auto-generated method stub
		rolemapper.deleteRole(id);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		rolemapper.updateRole(role);
	}

	@Override
	public List<Role> getRole(String roleName, String roleType) {
		// TODO Auto-generated method stub
		return rolemapper.getRole(roleName, roleType);
	}

}
