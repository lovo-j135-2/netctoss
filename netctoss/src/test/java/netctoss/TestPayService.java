package netctoss;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.paymag.service.PayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-context.xml")
public class TestPayService {

	@Resource
	private PayService payServiceImpl;
	
	@Ignore
	public void testAddPay(){
		Pay pay=new Pay("全球通业务","包月", 150, new BigDecimal(58.00), new BigDecimal(0), "超出部分按0.19元/分收费", 0);
		int num=0;
		try {
			num = payServiceImpl.addPay(pay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
	
	@Ignore
	public void testDeletePay(){
		int num=0;
		try {
			num=payServiceImpl.deletePay(4l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
	
	@Test
	public void testUpdatePay(){
		int num=0;
		Pay pay=new Pay("全球通业务","包月", 240, new BigDecimal(58.00), new BigDecimal(0), "超出部分按0.19元/分收费", 0);
		pay.setId(5l);
		try {
			num=payServiceImpl.updatePay(pay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
	
	@Ignore
	public void testUpdatePayStatus(){
		int num=0;
		Pay pay=new Pay();
		pay.setId(5l);
		pay.setPayStatus(1);
		try {
			num=payServiceImpl.updatePay(pay);
			System.out.println(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFindPaysByTime(){
		PagePay pagePay=new PagePay();
		pagePay.setPage(2);
		pagePay.setLines(3);
		List<Date> dates=new ArrayList<Date>();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		String s1="2016-05-04";
		String s2="2018-01-01";
		
		try {
			Date date1=simple.parse(s1);
			Date date2=simple.parse(s2);
			dates.add(date1);
			dates.add(date2);
			pagePay=payServiceImpl.findPaysByTime(dates, pagePay);
			System.out.println(pagePay);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
