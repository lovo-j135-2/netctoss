package lovo.j135_2.netctoss.accoutmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.accoutmag.beans.MonthBusiness;
import lovo.j135_2.netctoss.accoutmag.dao.MonthBusinessDao;
import lovo.j135_2.netctoss.accoutmag.service.MonthBusinessService;
@Service
public class MonthBusinessServiceImpl implements MonthBusinessService {

	@Resource
	private MonthBusinessDao monthBusinessDaoImpl;
	
	@Override
	public List<MonthBusiness> findAllBusinessCostByAccountId(Long id,int month) {
		// TODO Auto-generated method stub
		return monthBusinessDaoImpl.findAllBusinessCostByAccountId(id,month);
	}

	@Override
	public List<MonthBusiness> findAllBusinessByAccountId(Long id) {
		// TODO Auto-generated method stub
		return monthBusinessDaoImpl.findAllBusinessByAccountId(id);
	}

	@Override
	public List<MonthBusiness> findAllBusinessByAccountIdAndYear(Long id, int year) {
		// TODO Auto-generated method stub
		return monthBusinessDaoImpl.findAllBusinessByAccountIdAndYear(id, year);
	}

}
