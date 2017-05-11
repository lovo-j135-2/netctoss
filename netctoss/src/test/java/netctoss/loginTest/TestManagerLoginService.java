package netctoss.loginTest;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.loginmag.service.IManagerLoginService;
import lovo.j135_2.netctoss.managermag.beans.Manager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class TestManagerLoginService {
	@Resource
	private IManagerLoginService managerLoginServiceImpl;

	@Ignore
	public void testLogin() {

		Manager ma = new Manager();
		ma.setAccounts("2222222");
		ma.setPassword("0000000");
		try {
			ma = managerLoginServiceImpl.queryManagerByaccountsAndPassword(ma);
			System.out.println(ma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void testGetManagerByAccounts() {
		 Manager ma = new Manager();
		 ma.setAccounts("2222222");
		try {
			ma = managerLoginServiceImpl.getManagerByaccounts(ma);
			System.out.println(ma);
			System.out.println(ma.getAccounts());
			System.out.println(ma.getName());
			System.out.println(ma.getPassword());
			System.out.println(ma.getPhone());
			System.out.println(ma.getPostcode());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void testGetManagerById() {

		try {
			Manager ma = managerLoginServiceImpl.getManagerById(1l);
			System.out.println(ma);
			System.out.println(ma.getAccounts());
			System.out.println(ma.getName());
			System.out.println(ma.getPassword());
			System.out.println(ma.getPhone());
			System.out.println(ma.getPostcode());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void testUpdateManager() {
		Manager ma = new Manager();
		ma.setAccounts("3333333");
		ma.setPassword("5555555");
		int num = 0;
		try {
			num = managerLoginServiceImpl.updatePasswordByAccounts(ma);
			System.out.println(ma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
