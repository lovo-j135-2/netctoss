package lovo.j135_2.netctoss.accoutmag.service;

import java.util.List;

import lovo.j135_2.netctoss.accoutmag.beans.MonthBusiness;

public interface MonthBusinessService {

	public List<MonthBusiness> findAllBusinessCostByAccountId(Long id,int month);
	
	public List<MonthBusiness> findAllBusinessByAccountId(Long id);
	
	public List<MonthBusiness> findAllBusinessByAccountIdAndYear(Long id,int year);
}
