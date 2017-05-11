package lovo.j135_2.netctoss.labmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.labmag.beans.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.beans.PageDayTimeFiles;
import lovo.j135_2.netctoss.labmag.dao.LabDayFilesDao;
import lovo.j135_2.netctoss.labmag.mapper.LabDayFilesMapper;

@Repository
public class LabDayFilesDaoImpl implements LabDayFilesDao {
	
	@Resource
	private LabDayFilesMapper lbm;

	@Override
	public int insertDayTimeLabFiles(List<DayTimeFiles> list) throws Exception {
		// TODO Auto-generated method stub
		return lbm.insertDayTimeLabFiles(list);
	}

	@Override
	public List<DayTimeFiles> findLabDayMesByYearAndMonth(int year, int month, String ip, PageDayTimeFiles pageDay)
			throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabDayMesByYearAndMonth(year, month, ip, pageDay.getFromLine(), pageDay.getLines());
	}

	@Override
	public List<DayTimeFiles> findLabMonthMesByYearAndMonth(int year, int month, PageDayTimeFiles pageDay)
			throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabMonthMesByYearAndMonth(year, month, pageDay.getFromLine(), pageDay.getLines());
	}

	@Override
	public List<DayTimeFiles> findLabYearMesByYear(int year, PageDayTimeFiles pageDay) throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabYearMesByYear(year, pageDay.getFromLine(), pageDay.getLines());
	}

	@Override
	public int findLabMonthCountByYearAndMonth(int year, int month) throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabMonthCountByYearAndMonth(year, month);
	}

	@Override
	public int findLabDayCountByYearAndMonth(int year, int month) throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabMonthCountByYearAndMonth(year, month);
	}

	@Override
	public int findLabDayCountByYearAndMonth(int year, int month, String ip) throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabDayCountByYearAndMonth(year, month, ip);
	}

	@Override
	public int findLabYearCountByYear(int year) throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabYearCountByYear(year);
	}

	@Override
	public List<DayTimeFiles> findLabYearsMonthMesByYearAndIp(int year, String ip, PageDayTimeFiles pageDay)
			throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabYearsMonthMesByYearAndIp(year, ip, pageDay.getFromLine(), pageDay.getLines());
	}

	@Override
	public int findLabYearsMonthCountByYearAndIp(int year, String ip) throws Exception {
		// TODO Auto-generated method stub
		return lbm.findLabYearsMonthCountByYearAndIp(year, ip);
	}
}
