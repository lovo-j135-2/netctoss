package lovo.j135_2.netctoss.rightmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.dao.RightDao;
import lovo.j135_2.netctoss.rightmag.service.RightService;

@Service
public class RightServiceImpl implements RightService{
	
	@Resource
	private RightDao rightDaoImpl;
	@Override
	public void saveRight(Right right) {
		// TODO Auto-generated method stub
		rightDaoImpl.saveRight(right);
	}

	@Override
	public void deleteRight(long id) {
		// TODO Auto-generated method stub
		rightDaoImpl.deleteRight(id);
	}

	@Override
	public void updateRight(Right right) {
		// TODO Auto-generated method stub
		rightDaoImpl.updateRight(right);
	}

	@Override
	public List<Right> getRights() {
		// TODO Auto-generated method stub
		return rightDaoImpl.getRights();
	}

}
