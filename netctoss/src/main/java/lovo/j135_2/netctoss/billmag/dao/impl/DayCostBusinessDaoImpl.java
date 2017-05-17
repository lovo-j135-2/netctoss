package lovo.j135_2.netctoss.billmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.billmag.beans.DayCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.dao.DayCostBusinessDao;
import lovo.j135_2.netctoss.billmag.mapper.DayCostBusinessMapper;
import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;
import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.service.BusinessService;
import lovo.j135_2.netctoss.util.MyDate;

@Repository
public class DayCostBusinessDaoImpl implements DayCostBusinessDao {
	
	@Resource
	private DayCostBusinessMapper dm;
	
	@Override
	public int addDayCostBusiness(List<DayCostBussiness> list) throws Exception {
		// TODO Auto-generated method stub
		return dm.addDayCostBusiness(list);
	}

	@Override
	public List<MonthCostBussiness> findMonthTotalMesInDayCostBusinessByYearAndMonth(int year, int month, int[] days)
			throws Exception {
		// TODO Auto-generated method stub
		return dm.findMonthTotalMesInDayCostBusinessByYearAndMonth(year, month, days);
	}

	@Override
	public List<MonthCostBussiness> findMonthTotalCostMesInDayCostBusinessByYearAndMonth(int year, int month,
			int[] days) throws Exception {
		// TODO Auto-generated method stub
		return dm.findMonthTotalCostMesInDayCostBusinessByYearAndMonth(year, month, days);
	}

}
