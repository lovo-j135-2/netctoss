package lovo.j135_2.netctoss.logmag.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
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

}
