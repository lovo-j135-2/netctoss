package lovo.j135_2.netctoss.accoutmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.accoutmag.beans.MonthAccount;
import lovo.j135_2.netctoss.accoutmag.beans.PageMonthAccount;

public interface AccoutMapper {

	
	public List<MonthAccount> findMonthCostAccountById(Long id);
	
	public List<MonthAccount> findMonthCostAccountByIdToPage(@Param("id")Long id,@Param("pageAccount")PageMonthAccount page);
	
	public List<MonthAccount> findMonthCostAccountBydate(@Param("year")int year,@Param("month")int month,@Param("id")Long id);
	
	public List<MonthAccount> findAccountByYear(@Param("id")Long id,@Param("year")int year);
	
}
