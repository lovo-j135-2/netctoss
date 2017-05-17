package lovo.j135_2.netctoss.billmag.service;

import java.util.List;

import lovo.j135_2.netctoss.billmag.beans.DayCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;

public interface DayCostBusinessService {

	/**
	 * 批量添加每日账单明细
	 * @param dayCostBusiness
	 * @return
	 * @throws Exception
	 */
	public int addDayCostBusiness() throws Exception;
	
	/**
	 * 通过年月来查询汇总每月总费用
	 * @param year
	 * @param month
	 * @return 每月总费用，包含年月，套餐类型、业务号id
	 * @throws Exception
	 */
	public List<MonthCostBussiness> findMonthTotalMesInDayCostBusinessByYearAndMonth()
			throws Exception;
}
