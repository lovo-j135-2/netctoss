package netctoss.logmag;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.service.IOperateLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class TestOperateLogBean {
	
	@Resource
	private IOperateLogService operateLogServiceImpl;
	
	@Test
	public void testOperateLogBean(){
		List<OperateLogBean> list = operateLogServiceImpl.findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime("张", "删", "20170101", "20180101");
		
		System.out.println(list);
	}
}
