package lovo.j135_2.netctoss.accoutmag.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.accoutmag.beans.DayCost;
import lovo.j135_2.netctoss.accoutmag.beans.MonthAccount;
import lovo.j135_2.netctoss.accoutmag.beans.MonthBusiness;
import lovo.j135_2.netctoss.accoutmag.beans.PageMonthAccount;
import lovo.j135_2.netctoss.accoutmag.service.DayCostService;
import lovo.j135_2.netctoss.accoutmag.service.MonthAccountService;
import lovo.j135_2.netctoss.accoutmag.service.MonthBusinessService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@RestController
@RequestMapping("/accountmag")
public class AccountCostController {
	
	@Resource
	private MonthAccountService monthAccountServiceImpl;
	@Resource
	private MonthBusinessService monthBusinessServiceImpl;
	@Resource
	private DayCostService dayCostServiceImpl;
	
//	@RequestMapping(value="/loadMonthAccount")
//	public List<MonthAccount> loadMonthAccount(HttpSession session){
//		AcconutUser accountUser = (AcconutUser) session.getAttribute("user");
//		Long accountId = accountUser.getId();
//		System.out.println(accountId);
//		List<MonthAccount> monthCostAccounts = monthAccountServiceImpl.findMonthCostAccountById(accountId);
//		return monthCostAccounts;
//	}
	@RequestMapping(value="/loadMonthAccount")
	public PageMonthAccount loadMonthAccount(HttpSession session,@RequestParam("page") String page, @RequestParam("rows") String rows){
		AcconutUser accountUser = (AcconutUser) session.getAttribute("user");
		Long accountId = accountUser.getId();
		System.out.println(page);
		System.out.println(rows);
		PageMonthAccount pageAccpunt = new PageMonthAccount();
		pageAccpunt.setPage(Integer.parseInt(page));
		pageAccpunt.setLines(Integer.parseInt(rows));
		pageAccpunt = monthAccountServiceImpl.findMonthCostAccountByIdToPage(accountId, pageAccpunt);
		
		return pageAccpunt;
	}
	
	@RequestMapping(value="/loadbydate{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<MonthAccount> loadMonthAccountBydate(int year,int month,HttpSession session){
		AcconutUser accountUser = (AcconutUser) session.getAttribute("user");
		Long accountId = accountUser.getId();
		List<MonthAccount> monthCostAccounts = monthAccountServiceImpl.findMonthCostAccountBydate(year, month,accountId);
		return monthCostAccounts;
	}
	
	@RequestMapping(value="/loadBusinessbyAccountId",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<MonthBusiness> loadMonthBusinessByAccountId(Long account,int month){
		List<MonthBusiness> monthCostBusinesses = monthBusinessServiceImpl.findAllBusinessCostByAccountId(account,month);
		return monthCostBusinesses;
	}
	
	@RequestMapping(value="/loadDayCost",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<DayCost> loadDayCostByBusinessIdAccountId(Long businessId,Long accountId, int month){
		List<DayCost> datCosts = dayCostServiceImpl.findAllDayCostByBusinessIdAndAccountId(businessId, accountId, month);
		for (DayCost dayCostAccount2 : datCosts) {
			String beginTime = dayCostAccount2.getSqlBeginTime().toString();
			dayCostAccount2.setBeginTime(beginTime);
			String endTime = dayCostAccount2.getSqlEndTime().toString();
			dayCostAccount2.setEndTime(endTime);
		}
		
		return datCosts;
	}
	
	@RequestMapping(value="/loadAllBusinessbyAccountId{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<MonthBusiness> loadBusinessbyAccountId(@PathVariable("id")Long id){
		List<MonthBusiness> monthCostBusinesses = monthBusinessServiceImpl.findAllBusinessByAccountId(id);
		return monthCostBusinesses;
	}
	@RequestMapping(value="/loadAccountByYear{id}")
	public List<MonthAccount> loadAccountByYear(@PathVariable("id")Long id,int year){
		List<MonthAccount> monthCostAccounts = monthAccountServiceImpl.findAccountByYear(id, year);
		System.out.println(monthCostAccounts);
		return monthCostAccounts;
	}
	@RequestMapping(value="/loadAllBusinessbyAccountIdAndYear{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<MonthBusiness> loadAllBusinessbyAccountIdAndYear(@PathVariable("id")Long id,int year){
		List<MonthBusiness> monthCostBusinesses = monthBusinessServiceImpl.findAllBusinessByAccountIdAndYear(id, year);
		return monthCostBusinesses;
	}
}
