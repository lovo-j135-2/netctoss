package lovo.j135_2.netctoss.paymag.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.service.PayService;

@RestController
@RequestMapping("/paymag")
@ResponseBody
public class PayController {

	@Resource
	private PayService payServiceImpl;
	
	@RequestMapping(value="/load",produces="application/json;charset=utf-8")
	public PagePay load(@RequestParam("page") String page,@RequestParam("rows") String rows){
		PagePay pagePay=new PagePay();
		pagePay.setPage(Integer.parseInt(page));
		pagePay.setLines(Integer.parseInt(rows));
		List<Date> dates=new ArrayList<Date>();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		String s1="1970-01-01";
		String s2="2018-01-01";
		Date date1;
		try {
			date1 = simple.parse(s1);
			Date date2=simple.parse(s2);
			dates.add(date1);
			dates.add(date2);
			pagePay=payServiceImpl.findPaysByTime(dates, pagePay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagePay;
	}
}
