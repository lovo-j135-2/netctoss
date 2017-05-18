package lovo.j135_2.netctoss.accoutmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.accoutmag.beans.DayCost;
import lovo.j135_2.netctoss.accoutmag.dao.DayCostDao;
import lovo.j135_2.netctoss.accoutmag.mapper.DayCostMapper;
@Repository
public class DayCostDaoImpl implements DayCostDao {

	@Resource
	private DayCostMapper dayCostMapper;
	
	@Override
	public List<DayCost> findAllDayCostByBusinessIdAndAccountId(Long businessId, Long accountId, int month) {
		// TODO Auto-generated method stub
		return dayCostMapper.findAllDayCostByBusinessIdAndAccountId(businessId, accountId, month);
	}

}
