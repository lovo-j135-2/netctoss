package netctoss;

import java.util.ArrayList;
import java.util.List;

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
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class TestAccountUserLogin {
	@Resource
	private IAccountUserLoginService accountUserServiceImpl;

	
	@Test
	public void testSaveAccountUser() {
		AcconutUser account = new AcconutUser();
		account.setAccount_name("xianhua");
		account.setPassword("222323232");
		try {
			accountUserServiceImpl.saveAccountUser(account);
			System.out.println(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Ignore
	public void testqueryAcconutUserByAccountAndPwd() {
		List<AcconutUser> list = new ArrayList<AcconutUser>();
		AcconutUser ac = new AcconutUser();
		ac.setAccount_name("xianchengduo");
		ac.setPassword("12233434");
		try {
			list = accountUserServiceImpl.queryAcconutUserByAccountAndPwd(ac);
			Assert.assertNotNull(list);// 为啥呢？
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void testGetAccountUser() {
		try {
			AcconutUser ac = accountUserServiceImpl.getAccountUser(1l);
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
		ac.setId(1l);
		ac.setPassword("9999999");
		int num=0;
		try {
			num=accountUserServiceImpl.updateAccountUser(ac);
			System.out.println(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
