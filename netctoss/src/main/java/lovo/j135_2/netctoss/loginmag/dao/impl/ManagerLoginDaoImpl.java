package lovo.j135_2.netctoss.loginmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.loginmag.dao.IManagerLoginDao;
import lovo.j135_2.netctoss.loginmag.mapper.ManagerLoginMapper;
import lovo.j135_2.netctoss.managermag.beans.Manager;

@Repository
public class ManagerLoginDaoImpl implements IManagerLoginDao {
	@Resource
	private ManagerLoginMapper managerLoginMapper;
	
	@Override
	public List<Manager> queryManagerByaccountsAndPassword(Manager manager)throws Exception {
		// TODO Auto-generated method stub
		return managerLoginMapper.queryManagerByaccountsAndPassword(manager);
	}

	@Override
	public Manager getManagerById(Long id)throws Exception {
		// TODO Auto-generated method stub
		return managerLoginMapper.getManagerById(id);
	}
	@Override
	public int updateManager(Manager manager)throws Exception {
		// TODO Auto-generated method stub
		return managerLoginMapper.updateManager(manager);
	}

}
