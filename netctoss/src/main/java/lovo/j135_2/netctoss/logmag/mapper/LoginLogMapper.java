package lovo.j135_2.netctoss.logmag.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface LoginLogMapper {
	
	@Insert(value="insert into t_loginlog (account,login_time) values (#{bean.account},#{bean.loginTime})")
	@Options(useGeneratedKeys = true, keyProperty = "bean.id")
	public int saveLoginLog(@Param("bean")LoginLogBean bean);
	
	@Select(value="select id as id,account as account,login_time as loginTime from t_loginlog where account like CONCAT(#{account},'%') and (login_time between #{bt} and #{et}) limit #{pb.index},#{pb.lines}")
	@ResultType(LoginLogBean.class)	//分页返回一个LoginLogPageBean对象？？service业务层返回一个PageBean就行了
	public List<LoginLogBean> findLoginLogBeanByTimeToPage(@Param("pb")LoginLogPageBean pageBean,@Param("account")String account,@Param("bt")String beginTime,@Param("et")String endTime) throws Exception;
	
	@Select(value="select count(*) from t_loginlog where account like CONCAT(#{account},'%') and (login_time between #{bt} and #{et})")
	@ResultType(Integer.class)
	public int findCountLoginLogBeanByTimeToPage(@Param("account")String account,@Param("bt")String beginTime,@Param("et")String endTime) throws Exception;
	
	
	@Select(value="select * from t_loginlog where account like CONCAT(#{ac},'%') and (login_time between #{bt} and #{et})")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="account",column="account",javaType=String.class),
		@Result(property="loginTime",column="login_time",javaType=Timestamp.class),
	})
	public List<LoginLogBean> findAllLoginLogBeanByTimeToPage(@Param("ac")String account,@Param("bt")String beginTime,@Param("et")String endTime);

	
	@Select(value="select * from t_loginlog where id = #{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="account",column="account",javaType=String.class),
		@Result(property="loginTime",column="login_time",javaType=Timestamp.class),
		@Result(property="operateLogs",javaType=List.class,column="id",many=@Many(fetchType=FetchType.LAZY,select="findOperateLogById"))
	})
	public LoginLogBean findLoginLogBeanById(Long id);
	
	
	@Select(value="select * from t_operatelog where fk_loginlog_id = #{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="account",column="account",javaType=String.class),
		@Result(property="operateType",column="op_type",javaType=String.class),
		@Result(property="operateClass",column="op_class",javaType=String.class),
		@Result(property="operateMethod",column="op_method",javaType=String.class),
		@Result(property="operateParam",column="op_param",javaType=String.class),
		@Result(property="operateOldValue",column="op_oldvalue",javaType=String.class),
		@Result(property="operateTime",column="op_time",javaType=Timestamp.class),
	})
	public List<OperateLogBean> findOperateLogById(Long id);


}
