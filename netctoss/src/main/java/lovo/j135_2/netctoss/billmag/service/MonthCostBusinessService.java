package lovo.j135_2.netctoss.billmag.service;

import java.util.List;

import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostBusiness;

public interface MonthCostBusinessService {

	/**
	 * 批量添加月费用账单明细
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int insertMonthCostBusinessBatch() throws Exception;
	
	/**
	 * 通过账号id查询本月内所有业务账号的消费情况，附带资费类型
	 * 
	 * @param year
	 * @param month
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PageMonthCostBusiness findMonthCostBussinessByAccountIDAndYearAndMonth(int year, int month, Long id,PageMonthCostBusiness page)
			throws Exception;
}
