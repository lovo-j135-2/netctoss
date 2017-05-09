package netctoss.LabTest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lovo.j135_2.netctoss.labmag.bean.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.bean.PageDayTimeFiles;
import lovo.j135_2.netctoss.labmag.service.LabDayFilesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-context.xml")
public class TestLabDayFilesService {
	
	@Resource
	private LabDayFilesService labDayFilesServiceImpl;

	@Ignore
	public void testInsertDayTimeLabFiles(){
		List<DayTimeFiles> list=new ArrayList<DayTimeFiles>();
		try {
			labDayFilesServiceImpl.insertDayTimeLabFiles(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindLabDayMesByYearAndMonth(){
		PageDayTimeFiles page=new PageDayTimeFiles();
		page.setPage(1);
		page.setLines(4);
		page.setFromLine(0);
		try {
			page=labDayFilesServiceImpl.findLabDayMesByYearAndMonth(2017, 5,"192.168.0.1",page);
			System.out.println(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindLabMonthMesByYearAndMonth(){
		PageDayTimeFiles page=new PageDayTimeFiles();
		page.setPage(1);
		page.setLines(4);
		page.setFromLine(0);
		try {
			page=labDayFilesServiceImpl.findLabMonthMesByYearAndMonth(2017, 5,page);
			System.out.println(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindLabYearMesByYear(){
		PageDayTimeFiles page=new PageDayTimeFiles();
		page.setPage(1);
		page.setLines(4);
		page.setFromLine(0);
		try {
			page=labDayFilesServiceImpl.findLabYearMesByYear(2017,page);
			System.out.println(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
