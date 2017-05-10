package lovo.j135_2.netctoss.rightmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.rightmag.beans.Role;
import lovo.j135_2.netctoss.rightmag.dao.RoleDao;
import lovo.j135_2.netctoss.rightmag.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDaoImpl;
	
	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
//		System.out.println("name="+role.getName()+"     type="+role.getRoleType());
//		System.out.println(roleDaoImpl);
		
		roleDaoImpl.saveRole(role);
	}

	@Override
	public void deleteRole(long id) {
		// TODO Auto-generated method stub
		roleDaoImpl.deleteRole(id);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		roleDaoImpl.updateRole(role);
	}

	@Override
	public List<Role> getRole(String roleName, String roleType) {
		// TODO Auto-generated method stub
		return roleDaoImpl.getRole(roleName, roleType);
	}

}
