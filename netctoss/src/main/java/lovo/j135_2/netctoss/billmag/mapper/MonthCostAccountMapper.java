package lovo.j135_2.netctoss.billmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Update;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public interface MonthCostAccountMapper {

	public int insertMonthCostAccountBatch(@Param("list") List<MonthCostAccount> list) throws Exception;

	public List<MonthCostAccount> findMonthCostAccountByIdOrAccountMesOrYearAndMonth(@Param("user") AcconutUser user,
			@Param("time") MonthCostAccount time, @Param("page") int page, @Param("rows") int rows) throws Exception;
	
	
	public int findMonthCostAccountCountByIdOrAccountMesOrYearAndMonth(@Param("user") AcconutUser user,
			@Param("time") MonthCostAccount time) throws Exception;
	
	
	@Update(value="update t_monthcost_account set pay_status=#{cost.payStatus}, pay_way=1 where year=#{cost.year} and month=#{cost.month} and account_id=#{cost.accountId}")
	@ResultType(Integer.class)
	public int updatePayStatusByIdAndYearAndMonth(@Param("cost")MonthCostAccount cost) throws Exception;
}
