package lovo.j135_2.netctoss.billmag.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostAccount;
import lovo.j135_2.netctoss.billmag.dao.MonthCostAccountDao;
import lovo.j135_2.netctoss.billmag.dao.MonthCostBusinessDao;
import lovo.j135_2.netctoss.billmag.service.MonthCostAccountService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.util.MyDate;

@Service
public class MonthCostAccountServiceImpl implements MonthCostAccountService {
	
	@Resource
	private MonthCostAccountDao monthCostAccountDaoImpl;
	
	@Resource
	private MonthCostBusinessDao monthCostBusinessDaoImpl;

	@Override
	public int insertMonthCostAccountBatch() throws Exception {
		// TODO Auto-generated method stub
		Date date=MyDate.getDate();
		String time=date.toString();
		String[] times=time.split("-");
		int year=Integer.parseInt(times[0]);
		int month=Integer.parseInt(times[1]);
		List<MonthCostAccount> list=monthCostBusinessDaoImpl.findMonthCostAccountMesByYearAndMonth(year, month);
		return monthCostAccountDaoImpl.insertMonthCostAccountBatch(list);
	}

	@Override
	public PageMonthCostAccount findMonthCostAccountByIdOrAccountMesOrYearAndMonth(AcconutUser user,
			MonthCostAccount time,PageMonthCostAccount page) throws Exception {
		// TODO Auto-generated method stub
		page.setFromLine((page.getPage()-1)*page.getLines());
		page.setTotal(monthCostAccountDaoImpl.findMonthCostAccountCountByIdOrAccountMesOrYearAndMonth(user, time));
		page.setRows(monthCostAccountDaoImpl.findMonthCostAccountByIdOrAccountMesOrYearAndMonth(user, time,page));
		return page;
	}

}
