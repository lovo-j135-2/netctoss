package lovo.j135_2.netctoss.logmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
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

}
