package lovo.j135_2.netctoss.logmag.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface OperateLogMapper {
	
	@Insert(value="insert into t_operatelog (account,op_type,op_class,op_method,op_param,op_oldvalue,op_time,fk_loginlog_id) values (#{op.account},#{op.operateType},#{op.operateClass},#{op.operateMethod},#{op.operateParam},#{op.operateOldValue},#{op.operateTime},#{op.loginLog.id})")
	public void saveOperateLog(@Param("op")OperateLogBean operateLog);
	
	
	
	@Select(value="select * from t_operatelog where account like CONCAT(#{account},'%') and op_type like CONCAT(#{type},'%') and (op_time between #{beginTime} and #{endTime})")
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
	public List<OperateLogBean> findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(@Param("account")String account,@Param("type")String type,@Param("beginTime")String beginTime,@Param("endTime")String endTime);

}
