package lovo.j135_2.netctoss.managermag.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.managermag.beans.Manager;
import lovo.j135_2.netctoss.managermag.beans.PageManager;
import lovo.j135_2.netctoss.managermag.dao.ManagerDao;
import lovo.j135_2.netctoss.managermag.service.ManagerService;
import lovo.j135_2.netctoss.rightmag.beans.Role;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private ManagerDao managerDaoImpl;
	
	@Override
	public int saveManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerDaoImpl.saveManager(manager);
	}

	@Override
	public int updateManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerDaoImpl.updateManager(manager);
	}

	@Override
	public PageManager getAllManager(PageManager pageManager) throws Exception {
		// TODO Auto-generated method stub
		pageManager. setRows(managerDaoImpl.getAllManager(pageManager));
		pageManager.setTotal(managerDaoImpl.getManagerCount());
		pageManager.setFromLine((pageManager.getPage()-1)*pageManager.getLines());
		
		return pageManager;
	}

	@Override
	public Manager getManager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return managerDaoImpl.getManager(id);
	}

	@Override
	public int deleteManager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return managerDaoImpl.deleteManager(id);
	}

	@Override
	public int getManagerCount()throws Exception {
		// TODO Auto-generated method stub
		return managerDaoImpl.getManagerCount();
	}

	@Override
	public List<Role> getAllRole() throws Exception {
		// TODO Auto-generated method stub
	
		return managerDaoImpl.getAllRole();
	}

	@Override
	public Manager getManagerByManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerDaoImpl.getManagerByManager(manager);
	}

	@Override
	public PageManager getManagerByManagerInfo(PageManager pageManager,Manager manager) throws Exception {
		// TODO Auto-generated method stub
		
		List<Manager> maList = managerDaoImpl.getManagerByManagerInfo(pageManager, manager);
		
		pageManager. setRows(maList);
		pageManager.setTotal(managerDaoImpl.getFuzzyManagerCount(manager));
		pageManager.setFromLine((pageManager.getPage()-1)*pageManager.getLines());
		System.out.println("service:"+pageManager);
		return pageManager;
	}

}
