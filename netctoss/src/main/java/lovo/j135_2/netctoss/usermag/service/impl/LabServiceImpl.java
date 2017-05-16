package lovo.j135_2.netctoss.usermag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.usermag.beans.Lab;
import lovo.j135_2.netctoss.usermag.dao.LabDao;
import lovo.j135_2.netctoss.usermag.dao.impl.LabDaoImpl;
import lovo.j135_2.netctoss.usermag.service.LabService;

@Service
public class LabServiceImpl implements LabService{
	
	@Resource
	private LabDao labDaoImpl;

	@Override
	public List<Lab> findAllLab() {
		// TODO Auto-generated method stub
		return labDaoImpl.findAllLab();
	}
	
}
