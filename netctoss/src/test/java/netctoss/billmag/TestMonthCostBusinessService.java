package netctoss.billmag;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostBusiness;
import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.billmag.service.MonthCostBusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestMonthCostBusinessService {

	@Resource
	private  MonthCostBusinessService monthCostBusinessServiceImpl;
	
	@Ignore
	public void testInsertMonthCostBusinessBatch(){
		try {
			int num=monthCostBusinessServiceImpl.insertMonthCostBusinessBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFindMonthCostBussinessCountByAccountIDAndYearAndMonth(){
		PageMonthCostBusiness page=new PageMonthCostBusiness();
		page.setPage(1);
		page.setLines(10);
		try {
			page=monthCostBusinessServiceImpl.findMonthCostBussinessByAccountIDAndYearAndMonth(2017, 5, 3l, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(page);
	}
}
