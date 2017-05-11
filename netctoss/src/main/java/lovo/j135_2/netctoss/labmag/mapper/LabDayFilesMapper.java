package lovo.j135_2.netctoss.labmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import lovo.j135_2.netctoss.labmag.beans.DayTimeFiles;
import lovo.j135_2.netctoss.labmag.beans.PageDayTimeFiles;

public interface LabDayFilesMapper {
	
	public int insertDayTimeLabFiles(@Param("list")List<DayTimeFiles> list) throws Exception;
	
	@Select(value="select year,month,day,sum(time) as time,ip_num as ip from t_daytime_lab where year=#{year} and month=#{month} and ip_num=#{ip} group by day limit #{page},#{rows}")
//	@Results({
//		@Result(id=true,property="id",column="id",javaType=Long.class),
//		@Result(property="accountId",column="account_id",javaType=Long.class),
//		@Result(property="year",column="year",javaType=Integer.class),
//		@Result(property="month",column="month",javaType=Integer.class),
//		@Result(property="day",column="day",javaType=Integer.class),
//		@Result(property="time",column="time",javaType=Integer.class),
//		@Result(property="ip",column="ip_num",javaType=String.class)
//	})
	public List<DayTimeFiles> findLabDayMesByYearAndMonth(@Param("year")int year,@Param("month")int month,@Param("ip")String ip,@Param("page")int page,@Param("rows")int rows) throws Exception;
	
	@Select(value="SELECT COUNT(DISTINCT day) from t_daytime_lab where year=#{year} and month=#{month} and ip_num=#{ip}")
	@ResultType(Integer.class)
	public int findLabDayCountByYearAndMonth(@Param("year")int year,@Param("month")int month,@Param("ip")String ip) throws Exception;
	
	@Select(value="select year,month,sum(time) as time,ip_num as ip from t_daytime_lab where year=#{year} and month=#{month}  GROUP BY ip_num limit #{page},#{rows}")
	public List<DayTimeFiles> findLabMonthMesByYearAndMonth(@Param("year")int year,@Param("month")int month,@Param("page")int page,@Param("rows")int rows) throws Exception;
	
	@Select(value="select count(DISTINCT ip_num) from t_daytime_lab where year=#{year} and month=#{month} ")
	@ResultType(Integer.class)
	public int findLabMonthCountByYearAndMonth(@Param("year")int year,@Param("month")int month) throws Exception;
	
	@Select(value="select year,sum(time) as time,ip_num as ip from t_daytime_lab where year=#{year} GROUP BY ip_num limit #{page},#{rows}")
	public List<DayTimeFiles> findLabYearMesByYear(@Param("year")int year,@Param("page")int page,@Param("rows")int rows) throws Exception;
	
	@Select(value="SELECT count(DISTINCT ip_num)  from t_daytime_lab where year=#{year}")
	@ResultType(Integer.class)
	public int findLabYearCountByYear(@Param("year")int year) throws Exception;
	
	
	@Select(value="select year,sum(time) as time ,month from t_daytime_lab where year=#{year} and ip_num=#{ip} GROUP BY ip_num limit #{page},#{rows}")
	public List<DayTimeFiles> findLabYearsMonthMesByYearAndIp(@Param("year")int year,@Param("ip")String ip,@Param("page")int page,@Param("rows")int rows) throws Exception;
	
	@Select(value="SELECT count(DISTINCT ip_num) FROM  t_daytime_lab where year=#{year} and ip_num=#{ip}")
	@ResultType(Integer.class)
	public int findLabYearsMonthCountByYearAndIp(@Param("year")int year,@Param("ip")String ip) throws Exception;
	
	
	
}
