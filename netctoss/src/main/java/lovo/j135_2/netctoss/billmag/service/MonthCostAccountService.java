package lovo.j135_2.netctoss.billmag.service;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostAccount;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public interface MonthCostAccountService {

	/**
	 * 批量增加每月用户账单
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int insertMonthCostAccountBatch() throws Exception;

	/**
	 * 通过账务账号id或身份证id或用户名或年月来查询符合条件的月用户账单
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageMonthCostAccount findMonthCostAccountByIdOrAccountMesOrYearAndMonth(AcconutUser user,
			MonthCostAccount time,PageMonthCostAccount page) throws Exception;
	
	public int updatePayStatusByIdAndYearAndMonth(MonthCostAccount cost) throws Exception;
}
