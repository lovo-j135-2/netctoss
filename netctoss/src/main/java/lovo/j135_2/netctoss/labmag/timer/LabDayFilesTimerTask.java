package lovo.j135_2.netctoss.labmag.timer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.labmag.beans.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.service.LabDayFilesService;

@Repository
public class LabDayFilesTimerTask {
	
	@Resource
	private LabDayFilesService labDayFilesServiceImpl;
	
	public void addDayLabFilesEndOfTheMonth(){
		List<DayTimeFiles> list=new ArrayList<DayTimeFiles>();
		try {
			labDayFilesServiceImpl.insertDayTimeLabFiles(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
