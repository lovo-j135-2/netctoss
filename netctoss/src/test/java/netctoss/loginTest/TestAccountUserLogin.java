package netctoss.loginTest;




import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.loginmag.service.IAccountUserLoginService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml" })
public class TestAccountUserLogin {
	@Resource
	private IAccountUserLoginService accountUserServiceImpl;

	@Ignore
	public void testqueryAcconutUserByAccountNameAndPwd() {
		AcconutUser ac = new AcconutUser();
		ac.setAccount_name("xianchengduo");
		ac.setPassword("9999999");
		try {
		 ac=accountUserServiceImpl.queryAcconutUserByAccountNameAndPwd(ac);	 
		 System.out.println(ac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAccountUser() {
		AcconutUser ac = new AcconutUser();
		ac.setAccount_name("xianchengduo");
		try {
			ac = accountUserServiceImpl.getAccountUserByAccountName(ac);
			System.out.println(ac);
			System.out.println(ac.getAccount_name());
			System.out.println(ac.getPassword());
			System.out.println(ac.getPhone());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Ignore
	public void testUpdateAccountUser(){
		AcconutUser ac=new AcconutUser();
		ac.setAccount_name("xianhua");
		ac.setPassword("1111111");
		int num=0;
		try {
			num=accountUserServiceImpl.updatePasswordByAccountName(ac);
			System.out.println(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
