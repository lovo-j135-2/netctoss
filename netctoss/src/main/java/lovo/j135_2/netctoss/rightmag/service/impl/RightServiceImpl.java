package lovo.j135_2.netctoss.rightmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.rightmag.beans.Page;
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
	public Page getRights(Page page) {
		// TODO Auto-generated method stub
		int total=rightDaoImpl.getRightsCount();
		System.out.println(total);
		List<Right> list=rightDaoImpl.getRights(page);
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@Override
	public List<Right> getRights() {
		// TODO Auto-generated method stub
		return rightDaoImpl.getRights();
	}

	@Override
	public Right findRightBeanById(long id) {
		// TODO Auto-generated method stub
		return rightDaoImpl.findRightBeanById(id);
	}

}
