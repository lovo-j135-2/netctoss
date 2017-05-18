package lovo.j135_2.netctoss.logmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogPageBean;

public interface IOperateLogDao {

	public void saveOperateLog(OperateLogBean operateLog);
	
	public List<OperateLogBean> findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(String account,String type,String beginTime,String endTime);

	
	/**
	 * 传统：分页查询登录日志
	 */
	public List<OperateLogBean> findOperateLogBeanByTimeToPage(OperateLogPageBean op,String account,String type,String beginTime,String endTime) throws Exception;
	
	public int findCountOperateLogBeanByTimeToPage(String account,String type,String beginTime,String endTime) throws Exception;
}
