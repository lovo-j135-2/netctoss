package netctoss;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.beans.Lab;
import lovo.j135_2.netctoss.usermag.beans.Pager;
import lovo.j135_2.netctoss.usermag.service.AcconutUserService;
import lovo.j135_2.netctoss.usermag.service.BusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestBusinessService {
	@Resource
	private BusinessService businessServiceImpl;
	@Resource
	private AcconutUserService acconutUserServiceImpl;
	
	@Resource
	private  DayCostBusinessService dayCostBuisnessServiceImpl;
	
	@Ignore
	public void testSaveBusiness(){
		AcconutUser user=null;
		Pay pay = new Pay();
		Lab lab = new Lab();
		Business business=null;
		int num = 0;
		try {
			user = acconutUserServiceImpl.queryAcconutUserById(3);
		    business = new Business("testBusiness7", "test123", user, pay, lab) ;
			num=businessServiceImpl.saveBusiness(business);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(business.getFk_accountuser_id().getId());
	}
	
	@Ignore
	public void testDeleteBusiness(){
		int num=0;
		try {
			num = businessServiceImpl.deleteBusiness(5);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(num);
	}
	@Ignore
	public void testUpdateBusiness(){
		int num=0;
		Business business = null;
		try {
			business = businessServiceImpl.queryBusinessById(2);
			business.setPassword("664");
			businessServiceImpl.updateBusiness(business);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(business.getPassword());
		
	}
	@Ignore
	public void testQueryBusinessById(){
		Business business = null;
		try {
			business = businessServiceImpl.queryBusinessById(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(business);
	}
	@Ignore
	public void testQueryBusinessByPager(){
		Pager pager = new Pager();
		pager.setFromLine(1);
		pager.setLines(5);
		List<Business> list = new ArrayList<Business>();
		try {
			list = businessServiceImpl.queryBusinessByPager(pager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for (Business business : list) {
			System.out.println(business);
		}
	}
	
	@Test
	public void testFindBusinessContainLabAndAccountAndPayByBusiId(){
		try {
			Business b=businessServiceImpl.findBusinessContainLabAndAccountAndPayByBusiId(2l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void testAddDayCostBusiness(){
		try {
			dayCostBuisnessServiceImpl.addDayCostBusiness();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
