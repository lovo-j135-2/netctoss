package lovo.j135_2.netctoss.logmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface IOperateLogDao {

	public void saveOperateLog(OperateLogBean operateLog);
	
	public List<OperateLogBean> findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(String account,String type,String beginTime,String endTime);

}
