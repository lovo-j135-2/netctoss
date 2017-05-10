package lovo.j135_2.netctoss.labmag.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;
import lovo.j135_2.netctoss.labmag.beans.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.beans.PageDayTimeFiles;
import lovo.j135_2.netctoss.labmag.dao.LabDayFilesDao;
import lovo.j135_2.netctoss.labmag.service.LabDayFilesService;
import lovo.j135_2.netctoss.util.MyDate;

@Service
public class LabDayFilesServiceImpl implements LabDayFilesService {
	
	@Resource
	private LabDayFilesDao labDayFilesDaoImpl;
	
	@Resource
	private DMSService dMSServiceImpl;

	@Override
	public int insertDayTimeLabFiles(List<DayTimeFiles> list) throws Exception {
		// TODO Auto-generated method stub
		List<DMS> dmss=dMSServiceImpl.findAccountByDate();
		for (DMS dms : dmss) {
			String time=MyDate.dateToString(dms.getBeginTime());
			String[] strings=time.split("-| |:");
			String time2=MyDate.dateToString(dms.getEndTime());
			String[] strings2=time2.split("-| |:");
			int year=Integer.parseInt(strings[0]);
			int month=Integer.parseInt(strings[1]);
			int day=Integer.parseInt(strings[2]);
			int endSecond=Integer.parseInt(strings2[3])*3600+Integer.parseInt(strings2[4])*60+
					Integer.parseInt(strings2[5]);
			int beginSecond=Integer.parseInt(strings[3])*3600+Integer.parseInt(strings[4])*60+
					Integer.parseInt(strings[5]);
			int second=endSecond-beginSecond;
			int min=(int) Math.ceil((double)second/(double)60);
			DayTimeFiles dayTime=new DayTimeFiles(dms.getAccountId(),year,month,day,min,dms.getIp());
			list.add(dayTime);
		}
		return labDayFilesDaoImpl.insertDayTimeLabFiles(list);
	}

	@Override
	public PageDayTimeFiles findLabDayMesByYearAndMonth(int year, int month, String ip, PageDayTimeFiles pageDayTime)
			throws Exception {
		// TODO Auto-generated method stub
		pageDayTime.setRows(labDayFilesDaoImpl.findLabDayMesByYearAndMonth(year, month, ip, pageDayTime));
		return pageDayTime;
	}

	@Override
	public PageDayTimeFiles findLabMonthMesByYearAndMonth(int year, int month, PageDayTimeFiles pageDayTime)
			throws Exception {
		// TODO Auto-generated method stub
		pageDayTime.setRows(labDayFilesDaoImpl.findLabMonthMesByYearAndMonth(year, month, pageDayTime));
		return pageDayTime;
	}

	@Override
	public PageDayTimeFiles findLabYearMesByYear(int year, PageDayTimeFiles pageDayTime) throws Exception {
		// TODO Auto-generated method stub
		pageDayTime.setRows(labDayFilesDaoImpl.findLabYearMesByYear(year, pageDayTime));
		return pageDayTime;
	}

	
}
