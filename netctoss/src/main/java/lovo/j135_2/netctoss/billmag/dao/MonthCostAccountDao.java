package lovo.j135_2.netctoss.billmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostAccount;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public interface MonthCostAccountDao {

	/**
	 * 批量增加每月用户账单
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int insertMonthCostAccountBatch(List<MonthCostAccount> list) throws Exception;
	
	/**
	 * 通过账务账号id或身份证id或用户名或年月来查询符合条件的月用户账单
	 * @return
	 * @throws Exception
	 */
	public List<MonthCostAccount> findMonthCostAccountByIdOrAccountMesOrYearAndMonth(AcconutUser user,MonthCostAccount time,PageMonthCostAccount page) throws Exception;
	
	/**
	 * 通过账务账号id或身份证id或用户名或年月来查询符合条件的月用户账单的总条数
	 * @param user
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public int findMonthCostAccountCountByIdOrAccountMesOrYearAndMonth(AcconutUser user,MonthCostAccount time) throws Exception;
	
	
}
