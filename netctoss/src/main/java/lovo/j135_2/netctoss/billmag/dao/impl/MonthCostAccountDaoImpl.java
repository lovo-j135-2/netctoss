package lovo.j135_2.netctoss.billmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostAccount;
import lovo.j135_2.netctoss.billmag.dao.MonthCostAccountDao;
import lovo.j135_2.netctoss.billmag.mapper.MonthCostAccountMapper;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@Repository
public class MonthCostAccountDaoImpl implements MonthCostAccountDao {
	
	@Resource
	private MonthCostAccountMapper mam;

	@Override
	public int insertMonthCostAccountBatch(List<MonthCostAccount> list) throws Exception {
		// TODO Auto-generated method stub
		return mam.insertMonthCostAccountBatch(list);
	}

	@Override
	public List<MonthCostAccount> findMonthCostAccountByIdOrAccountMesOrYearAndMonth(AcconutUser user,
			MonthCostAccount time,PageMonthCostAccount page) throws Exception {
		// TODO Auto-generated method stub
		return mam.findMonthCostAccountByIdOrAccountMesOrYearAndMonth(user, time,page.getFromLine(),page.getLines());
	}

	@Override
	public int findMonthCostAccountCountByIdOrAccountMesOrYearAndMonth(AcconutUser user, MonthCostAccount time)
			throws Exception {
		// TODO Auto-generated method stub
		return mam.findMonthCostAccountCountByIdOrAccountMesOrYearAndMonth(user, time);
	}

}
