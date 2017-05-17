package lovo.j135_2.netctoss.billmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.billmag.beans.DayCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;

public interface DayCostBusinessDao {

	/**
	 * 批量添加每日账单明细
	 * 
	 * @param dayCostBusiness
	 * @return
	 * @throws Exception
	 */
	public int addDayCostBusiness(List<DayCostBussiness> list) throws Exception;

	/**
	 * 通过年月来查询汇总每月明细
	 * @param year
	 * @param month
	 * @return 每月总费用，包含年月，套餐类型、业务号id
	 * @throws Exception
	 */
	public List<MonthCostBussiness> findMonthTotalMesInDayCostBusinessByYearAndMonth(int year, int month,int[] days)
			throws Exception;
	
	/**
	 * 通过年月来查询汇总每月的增费用
	 * @param year
	 * @param month
	 * @param days
	 * @return 包含业务id，总费用
	 * @throws Exception
	 */
	public List<MonthCostBussiness> findMonthTotalCostMesInDayCostBusinessByYearAndMonth(int year, int month,int[] days)
			throws Exception;
}
