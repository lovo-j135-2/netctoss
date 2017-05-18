package lovo.j135_2.netctoss.rightmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.chainsaw.Main;
import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.dao.RightDao;
import lovo.j135_2.netctoss.rightmag.mapper.RightMapper;

@Repository
public class RightDaoImpl implements RightDao {

	@Resource
	private RightMapper rightMapper;
	@Override
	public void saveRight(Right right) {
		// TODO Auto-generated method stub
		rightMapper.saveRight(right);
	}

	@Override
	public void deleteRight(long id) {
		// TODO Auto-generated method stub
		rightMapper.deleteRight(id);
	}

	@Override
	public void updateRight(Right right) {
		// TODO Auto-generated method stub
		rightMapper.updateRight(right);
	}

	@Override
	public List<Right> getRights(Page page) {
		// TODO Auto-generated method stub
		return rightMapper.getRights(page);
	}

	@Override
	public int getRightsCount() {
		// TODO Auto-generated method stub
		return rightMapper.findRightsCount();
	}

	@Override
	public List<Right> getRights() {
		// TODO Auto-generated method stub
		return rightMapper.getRights();
	}

	@Override
	public Right findRightBeanById(long id) {
		// TODO Auto-generated method stub
		return rightMapper.findRightBeanById(id);
	}
}
