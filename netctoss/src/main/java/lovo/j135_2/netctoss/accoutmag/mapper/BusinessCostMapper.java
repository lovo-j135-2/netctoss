package lovo.j135_2.netctoss.accoutmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.accoutmag.beans.MonthBusiness;

public interface BusinessCostMapper {

	public List<MonthBusiness> findAllBusinessCostByAccountId(@Param("id")Long id,@Param("month")int month);
	
	public List<MonthBusiness> findAllBusinessByAccountId(@Param("id")Long id);
	
	public List<MonthBusiness> findAllBusinessByAccountIdAndYear(@Param("id")Long id,@Param("year")int year);
}
