package lovo.j135_2.netctoss.billmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostBusiness;
import lovo.j135_2.netctoss.billmag.dao.MonthCostBusinessDao;
import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.billmag.service.MonthCostBusinessService;

@Service
public class MonthCostBusinessServiceImpl implements MonthCostBusinessService {

	@Resource
	private  DayCostBusinessService dayCostBuisnessServiceImpl;
	
	@Resource
	private MonthCostBusinessDao monthCostBusinessDaoImpl;
	
	@Override
	public int insertMonthCostBusinessBatch() throws Exception {
		// TODO Auto-generated method stub
		List<MonthCostBussiness> list=dayCostBuisnessServiceImpl.findMonthTotalMesInDayCostBusinessByYearAndMonth();
		return monthCostBusinessDaoImpl.insertMonthCostBusinessBatch(list);
	}

	@Override
	public PageMonthCostBusiness findMonthCostBussinessByAccountIDAndYearAndMonth(int year, int month, Long id,
			PageMonthCostBusiness page) throws Exception {
		// TODO Auto-generated method stub
		page.setFromLine((page.getPage()-1)*page.getLines());
		page.setTotal(monthCostBusinessDaoImpl.findMonthCostBussinessCountByAccountIDAndYearAndMonth(year, month, id));
		page.setRows(monthCostBusinessDaoImpl.findMonthCostBussinessByAccountIDAndYearAndMonth(year, month, id, page));
		return page;
	}

}
