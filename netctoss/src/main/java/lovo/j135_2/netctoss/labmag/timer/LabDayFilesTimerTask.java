package lovo.j135_2.netctoss.labmag.timer;

import java.util.ArrayList;
import java.util.Calendar;
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
		 final Calendar c = Calendar.getInstance();
		 	//判断容器调用本方法时，当前时间是否为每个月的最后一天
		    if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
		        // do your stuff
		    	List<DayTimeFiles> list=new ArrayList<DayTimeFiles>();
				try {
					labDayFilesServiceImpl.insertDayTimeLabFiles(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	}
}
