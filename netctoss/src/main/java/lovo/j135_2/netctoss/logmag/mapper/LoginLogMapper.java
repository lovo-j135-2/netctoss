package lovo.j135_2.netctoss.logmag.mapper;

import java.sql.Date;	//注意：这里是SqlDate
import java.sql.Timestamp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginLogMapper {
	
	@Insert(value="insert into t_loginlog (account,login_time) values (#{name},#{loginTime})")
	public void saveLoginLog(@Param("name")String name,@Param("loginTime")Timestamp loginTime);
	
	
	@Select(value="select id as id from t_loginlog where login_time = #{loginTime}")
	public Long findLoginLogIdByLoginDate(Timestamp loginTime);	//查找刚刚save的这条登录日志记录
	
	
	@Update(value="update t_loginlog set quit_time = #{quitTime} where id = #{id}")
	public void updateLoginLog(@Param("quitTime")Timestamp quitTime,@Param("id")Long id);
}
