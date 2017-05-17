package netctoss.billmag;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.billmag.beans.MonthCostAccount;
import lovo.j135_2.netctoss.billmag.beans.PageMonthCostAccount;
import lovo.j135_2.netctoss.billmag.service.MonthCostAccountService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestMonthCostAccountService {

	@Resource
	private MonthCostAccountService monthCostAccountServiceImpl;
	
	@Ignore
	public void testInsertMonthCostAccountBatch(){
		try {
			monthCostAccountServiceImpl.insertMonthCostAccountBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindMonthCostAccountByIdOrAccountMesOrYearAndMonth(){
		AcconutUser user=new AcconutUser();
		user.setAccount_name("159");
		user.setId_num("511");
		user.setReal_name("李");
		System.out.println(user);
		MonthCostAccount time=new MonthCostAccount();
		time.setMonth(5);
		time.setYear(2017);
		PageMonthCostAccount page=new PageMonthCostAccount();
		page.setPage(1);
		page.setLines(10);
		try {
			page=monthCostAccountServiceImpl.findMonthCostAccountByIdOrAccountMesOrYearAndMonth(user, time,page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
