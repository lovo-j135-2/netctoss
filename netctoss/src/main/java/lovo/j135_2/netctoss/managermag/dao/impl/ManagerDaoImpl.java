package lovo.j135_2.netctoss.managermag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.managermag.beans.Manager;
import lovo.j135_2.netctoss.managermag.beans.PageManager;
import lovo.j135_2.netctoss.managermag.dao.ManagerDao;
import lovo.j135_2.netctoss.managermag.mapper.ManagerMapper;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	
	@Resource
	private ManagerMapper managerMapper;
	@Override
	public int saveManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerMapper.saveManager(manager);
	}

	@Override
	public int updateManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerMapper.updateManager(manager);
	}

	@Override
	public List<Manager> getAllManager(PageManager pageManager) throws Exception {
		// TODO Auto-generated method stub
		return managerMapper.getAllManager(pageManager);
	}

	@Override
	public Manager getManager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return managerMapper.getManager(id);
	}

	@Override
	public int deleteManager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return managerMapper.deleteManager(id);
	}

	@Override
	public int getManagerCount() throws Exception {
		// TODO Auto-generated method stub
		return managerMapper.getManagerCount();
	}

}