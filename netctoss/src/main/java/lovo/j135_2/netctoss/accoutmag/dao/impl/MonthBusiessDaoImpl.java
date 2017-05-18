package lovo.j135_2.netctoss.accoutmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.accoutmag.beans.MonthBusiness;
import lovo.j135_2.netctoss.accoutmag.dao.MonthBusinessDao;
import lovo.j135_2.netctoss.accoutmag.mapper.BusinessCostMapper;
@Repository
public class MonthBusiessDaoImpl implements MonthBusinessDao {

	@Resource
	private BusinessCostMapper businessCostMapper;
	
	@Override
	public List<MonthBusiness> findAllBusinessCostByAccountId(Long id,int month) {
		// TODO Auto-generated method stub
		return businessCostMapper.findAllBusinessCostByAccountId(id,month);
	}

	@Override
	public List<MonthBusiness> findAllBusinessByAccountId(Long id) {
		// TODO Auto-generated method stub
		return businessCostMapper.findAllBusinessByAccountId(id);
	}

	@Override
	public List<MonthBusiness> findAllBusinessByAccountIdAndYear(Long id, int year) {
		// TODO Auto-generated method stub
		return businessCostMapper.findAllBusinessByAccountIdAndYear(id, year);
	}

}
