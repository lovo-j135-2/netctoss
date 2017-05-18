package lovo.j135_2.netctoss.logmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogPageBean;
import lovo.j135_2.netctoss.logmag.dao.IOperateLogDao;
import lovo.j135_2.netctoss.logmag.service.IOperateLogService;

@Service
public class OperateLogServiceImpl implements IOperateLogService{
	
	@Resource
	private IOperateLogDao operateLogDaoImpl;
	
	@Override
	public void saveOperateLog(OperateLogBean operateLog) {
		
		operateLogDaoImpl.saveOperateLog(operateLog);
	}

	@Override
	public List<OperateLogBean> findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(String account,
			String type, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return operateLogDaoImpl.findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(account, type, beginTime, endTime);
	}

	@Override
	public OperateLogPageBean findOperateLogBeanByTimeToPage(OperateLogPageBean op, String account, String type,String beginTime,
			String endTime) throws Exception {
		op.setTotal(operateLogDaoImpl.findCountOperateLogBeanByTimeToPage(account, type, beginTime, endTime));
		op.setRows(operateLogDaoImpl.findOperateLogBeanByTimeToPage(op, account, type, beginTime, endTime));
		return op;
	}

}
