package lovo.j135_2.netctoss.billmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostBusiness;
import lovo.j135_2.netctoss.billmag.dao.MonthCostBusinessDao;
import lovo.j135_2.netctoss.billmag.mapper.MonthCostBusinessMapper;

@Repository
public class MonthCostBusinessDaoImpl implements MonthCostBusinessDao {

	@Resource
	private MonthCostBusinessMapper msb;

	@Override
	public int insertMonthCostBusinessBatch(List<MonthCostBussiness> list) throws Exception {
		// TODO Auto-generated method stub
		return msb.insertMonthCostBusinessBatch(list);
	}

	@Override
	public List<MonthCostAccount> findMonthCostAccountMesByYearAndMonth(int year, int month) throws Exception {
		// TODO Auto-generated method stub
		return msb.findMonthCostAccountMesByYearAndMonth(year, month);
	}

	@Override
	public List<MonthCostBussiness> findMonthCostBussinessByAccountIDAndYearAndMonth(int year, int month, Long id,
			PageMonthCostBusiness page) throws Exception {
		// TODO Auto-generated method stub
		return msb.findMonthCostBussinessByAccountIDAndYearAndMonth(year, month, id,page.getFromLine(),page.getLines());
	}

	@Override
	public int findMonthCostBussinessCountByAccountIDAndYearAndMonth(int year, int month, Long id) throws Exception {
		// TODO Auto-generated method stub
		return msb.findMonthCostBussinessCountByAccountIDAndYearAndMonth(year, month, id);
	}

}
