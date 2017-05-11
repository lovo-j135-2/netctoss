package lovo.j135_2.netctoss.paymag.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.paymag.beans.MessagePay;
import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.paymag.service.PayService;
import lovo.j135_2.netctoss.util.MyDate;

@RestController
@RequestMapping("/paymag")
@ResponseBody
public class PayController {

	@Resource
	private PayService payServiceImpl;

	@RequestMapping(value = "/load", produces = "application/json;charset=utf-8")
	public PagePay load(@RequestParam("page") String page, @RequestParam("rows") String rows) {
		PagePay pagePay = new PagePay();
		pagePay.setPage(Integer.parseInt(page));
		pagePay.setLines(Integer.parseInt(rows));
		List<Date> dates = new ArrayList<Date>();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "1970-01-01";
		String s2 = MyDate.dateToString(new Date());
		Date date1;
		try {
			date1 = simple.parse(s1);
			Date date2 = simple.parse(s2);
			dates.add(date1);
			dates.add(date2);
			pagePay = payServiceImpl.findPaysByTime(dates, pagePay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagePay;
	}

	@RequestMapping(value = "/addPay", produces = "application/json;charset=utf-8")
	public MessagePay addPay(@RequestBody Pay pay) {
		MessagePay mes = new MessagePay();
		try {
			payServiceImpl.addPay(pay);
			mes.setFlag(true);
			mes.setMessage("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes.setFlag(false);
			mes.setMessage("添加失败");
		}
		return mes;
	}

	@RequestMapping(value = "/updatePay", produces = "application/json;charset=utf-8")
	public MessagePay updatePay(@RequestBody Pay pay) {
		MessagePay mes = new MessagePay();
		try {
			int num = payServiceImpl.updatePay(pay);
			mes.setFlag(true);
			mes.setMessage("修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes.setFlag(false);
			mes.setMessage("修改失败");
		}
		return mes;
	}

	@RequestMapping(value = "/deletePay", produces = "application/json;charset=utf-8")
	public MessagePay deletePay(@RequestParam Long id) {
		MessagePay mes = new MessagePay();
		try {
			int num = payServiceImpl.deletePay(id);
			mes.setFlag(true);
			mes.setMessage("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes.setFlag(false);
			mes.setMessage("删除失败");
		}
		return mes;
	}

	@RequestMapping(value = "/updatePayStatus", produces = "application/json;charset=utf-8")
	public MessagePay updatePayStatus(@RequestBody Pay pay) {
		System.out.println(pay);
		MessagePay mes = new MessagePay();
		try {
			int num = payServiceImpl.updatePayStatus(pay);
			mes.setFlag(true);
			mes.setMessage("开通资费成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes.setFlag(false);
			mes.setMessage("删除失败");
		}
		return mes;
	}
	
	@RequestMapping(value = "/findPaysByDate")
	public PagePay findPaysByDate(@RequestParam(value="page")String page,
			@RequestParam(value="rows")String rows,
			@RequestParam(value="data[]")String[] data) {
		System.out.println(page);
		System.out.println(data);
		PagePay pagePay = new PagePay();
		pagePay.setPage(Integer.parseInt(page));
		pagePay.setLines(Integer.parseInt(rows));
		List<Date> dates = new ArrayList<Date>();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		Date date1;
		Date date2;
		try {
			date1 = simple.parse(data[0]);
			date2 = simple.parse(data[1]);
			dates.add(date1);
			dates.add(date2);
			pagePay = payServiceImpl.findPaysByTime(dates, pagePay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagePay;
	}
}
