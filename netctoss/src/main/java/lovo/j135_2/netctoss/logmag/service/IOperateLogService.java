package lovo.j135_2.netctoss.logmag.service;

import java.util.List;

import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogPageBean;

public interface IOperateLogService {
	/**
	 * 保存操作日志
	 * @param operateLog
	 */
	public void saveOperateLog(OperateLogBean operateLog);
	
	
	public List<OperateLogBean> findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(String account,String type,String beginTime,String endTime);
	
	
	/**
	 * 传统：分页查询登录日志
	 */
	public OperateLogPageBean findOperateLogBeanByTimeToPage(OperateLogPageBean op,String account,String type,String beginTime,String endTime) throws Exception;
	
	
}
