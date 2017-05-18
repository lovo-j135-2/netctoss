package lovo.j135_2.netctoss.accoutmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.accoutmag.beans.MonthAccount;
import lovo.j135_2.netctoss.accoutmag.beans.PageMonthAccount;

public interface MonthAccountDao {

	public List<MonthAccount> findMonthCostAccountById(Long id);
	
	public List<MonthAccount> findMonthCostAccountByIdToPage(Long id,PageMonthAccount page);
	
	public List<MonthAccount> findMonthCostAccountBydate(int year,int month,Long id);
	
	public List<MonthAccount> findAccountByYear(Long id,int year);
}
