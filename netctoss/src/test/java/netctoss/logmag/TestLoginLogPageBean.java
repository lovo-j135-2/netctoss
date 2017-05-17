package netctoss.logmag;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.service.ILoginLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestLoginLogPageBean {
	
	@Resource
	private ILoginLogService loginLogServiceImpl;
	
	@Ignore
	public void testLoginLogPageBean(){		//传统分页测试
		LoginLogPageBean lp = null;
		lp = new LoginLogPageBean();
		lp.setIndex(5);	//page=2 index=5 表示第二页
		lp.setRows(5);
		
		try {
			List<LoginLogBean> list = loginLogServiceImpl.findLoginLogBeanByTimeToPage(lp, "20170101", "20180101");
			int total = loginLogServiceImpl.findCountLoginLogBeanByTimeToPage("20170101", "20180101");
			lp.setDatas(list);
			lp.setTotalRows(total);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lp);
	}
	
	@Test
	public void testLoginLogPageBean2(){	//先进的分页测试
		List<LoginLogBean> list = loginLogServiceImpl.findAllLoginLogBeanByTimeToPage("20170101", "20180101");
		System.out.println(list);
	}
	
	@Ignore
	public void testFindOperateLogById(){	//根据Id查询所有的OperateLogBean
		List<OperateLogBean> list = loginLogServiceImpl.findOperateLogById(3l);
		System.out.println(list);
	}
	
	@Ignore
	public void teatFindLoginLogById(){
		LoginLogBean loginLogBean = loginLogServiceImpl.findLoginLogBeanById(3l);
		System.out.println(loginLogBean);
	}
	
	
	
}
