package lovo.j135_2.netctoss.labmag.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.labmag.beans.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.beans.PageDayTimeFiles;

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
	 * 通过年月及ip地址查询每天时长总条数
	 * @param year
	 * @param month
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public int findLabDayCountByYearAndMonth(int year,int month,String ip) throws Exception;
	
	/**
	 * 按年月查询实验室总数目
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public int findLabDayCountByYearAndMonth(int year,int month) throws Exception;
	
	/**
	 * 按年月来查询实验室本月的总时长信息
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public List<DayTimeFiles> findLabMonthMesByYearAndMonth(int year,int month,PageDayTimeFiles pageDay) throws Exception;
	
	/**
	 * 按年月来查询实验室本月总条数
	 * @param year
	 * @param month
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public int findLabMonthCountByYearAndMonth(int year,int month) throws Exception;
	
	/**
	 * 通过年来查询所有实验室本年总时长信息
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public List<DayTimeFiles> findLabYearMesByYear(int year,PageDayTimeFiles pageDay) throws Exception;
	
	/**
	 * 通过年来查询所有总条数的实验室
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public int findLabYearCountByYear(int year) throws Exception;
	
	/**
	 * 通过年及实验室ip查询实验室的每月时长总和
	 * @param year
	 * @param ip
	 * @param pageDay
	 * @return
	 * @throws Exception
	 */
	public List<DayTimeFiles> findLabYearsMonthMesByYearAndIp(int year,String ip,PageDayTimeFiles pageDay) throws Exception;
	
	/**
	 * 通过年及实验室ip查询实验室的每月时长总和的总条数
	 * @param year
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public int findLabYearsMonthCountByYearAndIp(int year,String ip) throws Exception;
	
	
}
