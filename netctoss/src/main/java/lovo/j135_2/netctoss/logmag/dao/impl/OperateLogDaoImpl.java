package lovo.j135_2.netctoss.logmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogPageBean;
import lovo.j135_2.netctoss.logmag.dao.IOperateLogDao;
import lovo.j135_2.netctoss.logmag.mapper.OperateLogMapper;

@Repository
public class OperateLogDaoImpl implements IOperateLogDao {
	
	@Resource
	private OperateLogMapper operateLogMapper;
	
	@Override
	public void saveOperateLog(OperateLogBean operateLog) {
		// TODO Auto-generated method stub
		operateLogMapper.saveOperateLog(operateLog);
	}

	@Override
	public List<OperateLogBean> findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(String account,
			String type, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return operateLogMapper.findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(account, type, beginTime, endTime);
	}

	@Override
	public List<OperateLogBean> findOperateLogBeanByTimeToPage(OperateLogPageBean op, String account, String type,
			String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return operateLogMapper.findOperateLogBeanByTimeToPage(op, account, type, beginTime, endTime);
	}

	@Override
	public int findCountOperateLogBeanByTimeToPage(String account, String type, String beginTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return operateLogMapper.findCountOperateLogBeanByTimeToPage(account, type, beginTime, endTime);
	}

}
