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

import lovo.j135_2.netctoss.loginmag.service.IManagerLoginService;
import lovo.j135_2.netctoss.managermag.beans.Manager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class TestManagerLoginService {
	@Resource
	private IManagerLoginService managerLoginServiceImpl;

	@Test
	public void testLogin() {
		List<Manager> list = new ArrayList<Manager>();
		Manager ma = new Manager();
		ma.setAccounts("2222222");
		ma.setPassword("1111111");
		try {
			list = managerLoginServiceImpl.queryManagerByaccountsAndPassword(ma);
			Assert.assertNotNull(ma);
			System.out.println(ma);
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void testGetmManagerById() {

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
		ma.setId(1l);
		ma.setPassword("000000");
		try {
			managerLoginServiceImpl.updateManager(ma);
			System.out.println(ma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
