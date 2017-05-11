package lovo.j135_2.netctoss.billmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostBusiness;

public interface MonthCostBusinessDao {

	/**
	 * 批量添加月费用账单明细
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int insertMonthCostBusinessBatch(List<MonthCostBussiness> list) throws Exception;

	/**
	 * 通过年月来查询所有账户的本月的账单信息
	 * 
	 * @param year
	 * @param month
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public List<MonthCostAccount> findMonthCostAccountMesByYearAndMonth(int year, int month) throws Exception;

	/**
	 * 通过账号id查询本月内所有业务账号的消费情况，附带资费类型
	 * 
	 * @param year
	 * @param month
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<MonthCostBussiness> findMonthCostBussinessByAccountIDAndYearAndMonth(int year, int month, Long id,
			PageMonthCostBusiness page)
			throws Exception;
	
	/**
	 * 通过账号id查询本月内所有业务账号的消费情况，附带资费类型
	 * 
	 * @param year
	 * @param month
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int findMonthCostBussinessCountByAccountIDAndYearAndMonth(int year, int month, Long id)
			throws Exception;
}
