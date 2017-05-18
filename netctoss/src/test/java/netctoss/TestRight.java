package netctoss;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.beans.Role;
import lovo.j135_2.netctoss.rightmag.service.RightService;
import lovo.j135_2.netctoss.rightmag.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class TestRight {
	@Resource
	private RightService rightServiceImpl;
	@Resource
	private RoleService roleServiceImpl;
	
	@Test
	public void testFindRightBeanById(){
		Role role=roleServiceImpl.findRoleBeanById(3);
		System.out.println(role);
	}
	
	@Test
	public void testFindRight(){
		Page page=new Page();
		page.setPage(1);
		page.setIndex(0);
		page.setLines(10);
		page=rightServiceImpl.getRights(page);
		System.out.println(page);
	}
}
