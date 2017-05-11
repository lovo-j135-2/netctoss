package lovo.j135_2.netctoss.billmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.billmag.beans.DayCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;

public interface DayCostBusinessMapper {

	public int addDayCostBusiness(@Param("list") List<DayCostBussiness> list) throws Exception;

	public List<MonthCostBussiness> findMonthTotalMesInDayCostBusinessByYearAndMonth(@Param("year") int year,
			@Param("month") int month,@Param("days")int[] days) throws Exception;
	
	public List<MonthCostBussiness> findMonthTotalCostMesInDayCostBusinessByYearAndMonth(@Param("year") int year,
			@Param("month") int month,@Param("days")int[] days) throws Exception;
}
