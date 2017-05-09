package lovo.j135_2.netctoss.labmag.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.labmag.bean.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.bean.PageDayTimeFiles;

public interface LabDayFilesDao {

	public int insertDayTimeLabFiles(List<DayTimeFiles> list) throws Exception;
	
	/**
	 * 按年月及实验室IP来查询每天的账号情况
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public List<DayTimeFiles> findLabDayMesByYearAndMonth(int year,int month,String ip,PageDayTimeFiles pageDay) throws Exception;
	
	/**
	 * 按年月来查询实验室本月的总时长信息
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public List<DayTimeFiles> findLabMonthMesByYearAndMonth(int year,int month,PageDayTimeFiles pageDay) throws Exception;
	
	/**
	 * 通过年来查询所有实验室本年总时长信息
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public List<DayTimeFiles> findLabYearMesByYear(int year,PageDayTimeFiles pageDay) throws Exception;
	
}
