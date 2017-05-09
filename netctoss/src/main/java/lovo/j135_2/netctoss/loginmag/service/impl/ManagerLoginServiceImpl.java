package lovo.j135_2.netctoss.loginmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.loginmag.dao.IManagerLoginDao;
import lovo.j135_2.netctoss.loginmag.service.IManagerLoginService;
import lovo.j135_2.netctoss.managermag.beans.Manager;

@Service
public class ManagerLoginServiceImpl implements IManagerLoginService {
	
	@Resource
	private IManagerLoginDao managerLoginDaoImpl;
	
	@Override
	public List<Manager> queryManagerByaccountsAndPassword(Manager manager)throws Exception {
		// TODO Auto-generated method stub
		return managerLoginDaoImpl.queryManagerByaccountsAndPassword(manager);
	}

	@Override
	public Manager getManagerById(Long id)throws Exception {
		// TODO Auto-generated method stub
		return managerLoginDaoImpl.getManagerById(id);
	}

	@Override
	public int updateManager(Manager manager)throws Exception {
		// TODO Auto-generated method stub
		return managerLoginDaoImpl.updateManager(manager);
	}

}
