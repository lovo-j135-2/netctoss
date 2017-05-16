package lovo.j135_2.netctoss.usermag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.usermag.beans.Lab;
import lovo.j135_2.netctoss.usermag.dao.LabDao;
import lovo.j135_2.netctoss.usermag.mapper.LabMapper;

@Repository
public class LabDaoImpl implements LabDao {
	
	@Resource
	private LabMapper lm;

	@Override
	public List<Lab> findAllLab() {
		// TODO Auto-generated method stub
		return lm.findAllLab();
	}

}
