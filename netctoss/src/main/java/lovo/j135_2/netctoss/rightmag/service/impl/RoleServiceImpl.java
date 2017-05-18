package lovo.j135_2.netctoss.rightmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;
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
		roleDaoImpl.saveBatchRightToRole(role);
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
		roleDaoImpl.deleteRightOfRole(role.getId());
		roleDaoImpl.saveBatchRightToRole(role);
	}

	@Override
	public Page searchRole(String roleName, String roleType,Page page) {
		// TODO Auto-generated method stub
		int total=roleDaoImpl.searchRoleCount(roleName, roleType, page);
		List<?>list=roleDaoImpl.searchRole(roleName, roleType, page);
		page.setRows(list);
		page.setTotal(total);
		return page;
	}

//	@Override
//	public void saveBatchRightToRole(Role role) {
//		// TODO Auto-generated method stub
//		roleDaoImpl.saveBatchRightToRole(role);
//	}

	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleDaoImpl.getRole();
	}

	@Override
	public List<Long> idList(long id) {
		// TODO Auto-generated method stub
		return roleDaoImpl.idList(id);
	}

	@Override
	public Role findRoleBeanById(long id) {
		// TODO Auto-generated method stub
		return roleDaoImpl.findRoleBeanById(id);
	}

	

	

}
