package netctoss;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.service.RightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-context.xml"})
public class TestRight {
	
	@Resource
	private RightService rightServiceImpl;
	
	@Test
	public void testSaveRight(){
		Right right = new Right("用户管理系统权限","可以对用户管理系统进行相关操作" );
		rightServiceImpl.saveRight(right);
	}
	
	@Test
	public void testDeleteRight(){
		rightServiceImpl.deleteRight(1);
	}
	
	@Test
	public void testUpdateRight(){
		Right right = new Right(2,"资费管理权限","可以对资费管理系统进行相关操作");
		rightServiceImpl.updateRight(right);
	}
	
	@Test
	public void testGetRight(){
		List<Right>rightList = rightServiceImpl.getRights();
		for(Right r:rightList){
			System.out.println("rightName="+r.getName());
			System.out.println("description="+r.getDiscription());
		}
	}
}
