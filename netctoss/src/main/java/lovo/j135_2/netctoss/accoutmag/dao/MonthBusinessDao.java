package lovo.j135_2.netctoss.accoutmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.accoutmag.beans.MonthBusiness;

public interface MonthBusinessDao {

	public List<MonthBusiness> findAllBusinessCostByAccountId(Long id,int month);
	
	public List<MonthBusiness> findAllBusinessByAccountId(Long id);
	
	public List<MonthBusiness> findAllBusinessByAccountIdAndYear(Long id,int year);
}
