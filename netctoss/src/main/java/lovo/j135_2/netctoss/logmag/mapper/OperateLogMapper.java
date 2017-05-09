package lovo.j135_2.netctoss.logmag.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface OperateLogMapper {
	
	@Insert(value="insert into t_operatelog (account,op_type,op_class,op_method,op_param,op_oldvalue,op_time,fk_loginlog_id) values (#{op.account},#{op.operateType},#{op.operateClass},#{op.operateMethod},#{op.operateParam},#{op.operateOldValue},#{op.operateTime},#{op.loginLog.id})")
	public void saveOperateLog(@Param("op")OperateLogBean operateLog);
}
