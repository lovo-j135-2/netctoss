package lovo.j135_2.netctoss.billmag.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.billmag.beans.MessagePayBill;
import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostBusiness;
import lovo.j135_2.netctoss.billmag.service.MonthCostAccountService;
import lovo.j135_2.netctoss.billmag.service.MonthCostBusinessService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@RestController
@RequestMapping("/billmag")
@ResponseBody
public class BillSystemController {

	@Resource
	private MonthCostAccountService monthCostAccountServiceImpl;
	
	@Resource
	private MonthCostBusinessService monthCostBusinessServiceImpl;
	
	@RequestMapping(value="/searchDetail")
	public PageMonthCostAccount searchDetail(@RequestParam("page")String page,
			@RequestParam("rows")String rows,@RequestParam("id_num")String id_num,
			@RequestParam("year")String year,@RequestParam("month")String month,
			@RequestParam("realName")String realName,@RequestParam("accountName")String accountName){
		PageMonthCostAccount pager=new PageMonthCostAccount();
		if(page.equals("0")){
			pager.setPage(1);
		}else{
			pager.setPage(Integer.parseInt(page));
		}
		pager.setLines(Integer.parseInt(rows));
		AcconutUser user=new AcconutUser();
		user.setReal_name(realName);
		user.setAccount_name(accountName);
		user.setId_num(id_num);
		MonthCostAccount time=new MonthCostAccount();
		time.setYear(Integer.parseInt(year));
		time.setMonth(Integer.parseInt(month));
		try {
			pager=monthCostAccountServiceImpl.findMonthCostAccountByIdOrAccountMesOrYearAndMonth(user, time, pager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
	}
	
	@RequestMapping(value="/searchBusinessMonthDetail")
	public PageMonthCostBusiness searchBusinessMonthDetail(@RequestParam("page")String page,
			@RequestParam("rows")String rows,@RequestParam("id")String id,
			@RequestParam("year")String year,@RequestParam("month")String month
			){
		PageMonthCostBusiness pager=new PageMonthCostBusiness();
		if(page.equals("0")){
			pager.setPage(1);
		}else{
			pager.setPage(Integer.parseInt(page));
		}
		pager.setLines(Integer.parseInt(rows));
		AcconutUser user=new AcconutUser();
		MonthCostAccount time=new MonthCostAccount();
		time.setYear(Integer.parseInt(year));
		time.setMonth(Integer.parseInt(month));
		try {
			pager=monthCostBusinessServiceImpl.findMonthCostBussinessByAccountIDAndYearAndMonth(Integer.parseInt(year), Integer.parseInt(month), new Long(id), pager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
	}
	
	
	@RequestMapping(value="/payBill")
	public MessagePayBill payBill(@RequestParam("id")String id,
			@RequestParam("year")String year,@RequestParam("month")String month,
			@RequestParam("payWay")String payWay){
		MessagePayBill pay=new MessagePayBill();
		MonthCostAccount cost=new MonthCostAccount();
		cost.setYear(Integer.parseInt(year));
		cost.setMonth(Integer.parseInt(month));
		cost.setAccountId(new Long(id));
		cost.setPayWay(Integer.parseInt(payWay));
		cost.setPayStatus(1);
		try {
			int num=monthCostAccountServiceImpl.updatePayStatusByIdAndYearAndMonth(cost);
			if(num!=0){
				pay.setFlag(true);
				pay.setMessage("支付成功");
			}else{
				pay.setFlag(true);
				pay.setMessage("支付失败，请确认账户余额是否足够");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pay.setFlag(false);
			pay.setMessage("系统繁忙请稍后重试");
		}
		return pay;
	}
}
