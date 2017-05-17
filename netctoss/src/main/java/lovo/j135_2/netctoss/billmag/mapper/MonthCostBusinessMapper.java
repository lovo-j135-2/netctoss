package lovo.j135_2.netctoss.billmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;

public interface MonthCostBusinessMapper {

	public int insertMonthCostBusinessBatch(@Param("list") List<MonthCostBussiness> list) throws Exception;

	public List<MonthCostAccount> findMonthCostAccountMesByYearAndMonth(@Param("year") int year,
			@Param("month") int month) throws Exception;

	public List<MonthCostBussiness> findMonthCostBussinessByAccountIDAndYearAndMonth(@Param("year") int year,
			@Param("month") int month, @Param("id")Long id,@Param("page")int page,@Param("rows")int rows) throws Exception;
	
	public int findMonthCostBussinessCountByAccountIDAndYearAndMonth(@Param("year") int year,
			@Param("month") int month, @Param("id")Long id)
			throws Exception;
}
