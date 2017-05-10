package lovo.j135_2.netctoss.labmag.service;

import java.util.List;

import lovo.j135_2.netctoss.labmag.beans.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.beans.PageDayTimeFiles;

public interface LabDayFilesService {

	public int insertDayTimeLabFiles(List<DayTimeFiles> list) throws Exception;
	
	public PageDayTimeFiles findLabDayMesByYearAndMonth(int year,int month,String ip,PageDayTimeFiles pageDayTime) throws Exception;
	
	public PageDayTimeFiles findLabMonthMesByYearAndMonth(int year,int month,PageDayTimeFiles pageDayTime) throws Exception;
	
	public PageDayTimeFiles findLabYearMesByYear(int year,PageDayTimeFiles pageDayTime) throws Exception;
}
