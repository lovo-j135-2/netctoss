package lovo.j135_2.netctoss.accoutmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.accoutmag.beans.DayCost;
import lovo.j135_2.netctoss.accoutmag.dao.DayCostDao;
import lovo.j135_2.netctoss.accoutmag.service.DayCostService;
@Service
public class DayCostServiceImpl implements DayCostService {

	@Resource
	private DayCostDao dayCostDaoImpl;
	
	@Override
	public List<DayCost> findAllDayCostByBusinessIdAndAccountId(Long businessId, Long accountId, int month) {
		// TODO Auto-generated method stub
		return dayCostDaoImpl.findAllDayCostByBusinessIdAndAccountId(businessId, accountId, month);
	}

}
