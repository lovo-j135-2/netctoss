package netctoss.billmag;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestDayCostBusinessService {

	@Resource
	private  DayCostBusinessService dayCostBuisnessServiceImpl;
	
	@Test
	public void testFindMonthTotalMesInDayCostBusinessByYearAndMonth(){
		try {
			List<MonthCostBussiness> list=dayCostBuisnessServiceImpl.findMonthTotalMesInDayCostBusinessByYearAndMonth();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
