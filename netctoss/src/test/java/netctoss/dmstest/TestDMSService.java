package netctoss.dmstest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-context.xml")
public class TestDMSService {

	@Resource
	private DMSService dMSServiceImpl;
	
	@Test
	public void testFindAccountBy(){
		try {
			List<DMS> dms=dMSServiceImpl.findAccountByDate();
			for (DMS dms2 : dms) {
				System.out.println(dms2.getBeginTime());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
