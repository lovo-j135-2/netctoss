package lovo.j135_2.netctoss.accoutmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.accoutmag.beans.MonthAccount;
import lovo.j135_2.netctoss.accoutmag.beans.PageMonthAccount;
import lovo.j135_2.netctoss.accoutmag.dao.MonthAccountDao;
import lovo.j135_2.netctoss.accoutmag.mapper.AccoutMapper;
@Repository
public class MonthAccountDaoImpl implements MonthAccountDao {

	@Resource
	private AccoutMapper accountMapper;
	
	@Override
	public List<MonthAccount> findMonthCostAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountMapper.findMonthCostAccountById(id);
	}

	@Override
	public List<MonthAccount> findMonthCostAccountBydate(int year, int month,Long id) {
		// TODO Auto-generated method stub
		return accountMapper.findMonthCostAccountBydate(year, month,id);
	}

	@Override
	public List<MonthAccount> findAccountByYear(Long id, int year) {
		// TODO Auto-generated method stub
		return accountMapper.findAccountByYear(id, year);
	}

	@Override
	public List<MonthAccount> findMonthCostAccountByIdToPage(Long id, PageMonthAccount page) {
		// TODO Auto-generated method stub
		return accountMapper.findMonthCostAccountByIdToPage(id, page);
	}

}
