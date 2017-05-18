package lovo.j135_2.netctoss.accoutmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.accoutmag.beans.MonthAccount;
import lovo.j135_2.netctoss.accoutmag.beans.PageMonthAccount;
import lovo.j135_2.netctoss.accoutmag.dao.MonthAccountDao;
import lovo.j135_2.netctoss.accoutmag.service.MonthAccountService;
@Service
public class MonthAccountServiceImpl implements MonthAccountService {

	@Resource
	private MonthAccountDao monthAccountDaoImpl;
	
	@Override
	public List<MonthAccount> findMonthCostAccountById(Long id) {
		// TODO Auto-generated method stub
		return monthAccountDaoImpl.findMonthCostAccountById(id);
	}

	@Override
	public List<MonthAccount> findMonthCostAccountBydate(int year, int month,Long id) {
		// TODO Auto-generated method stub
		return monthAccountDaoImpl.findMonthCostAccountBydate(year, month,id);
	}

	@Override
	public List<MonthAccount> findAccountByYear(Long id, int year) {
		// TODO Auto-generated method stub
		return monthAccountDaoImpl.findAccountByYear(id, year);
	}

	@Override
	public PageMonthAccount findMonthCostAccountByIdToPage(Long id, PageMonthAccount page) {
		// TODO Auto-generated method stub
		int total = monthAccountDaoImpl.findMonthCostAccountById(id).size();
		page.setTotal(total);
		page.setIndex((page.getPage()-1)*page.getLines());
		List<MonthAccount> list = monthAccountDaoImpl.findMonthCostAccountByIdToPage(id, page);
		page.setRows(list);
		return page;
	}

}
