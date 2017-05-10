package lovo.j135_2.netctoss.logmag.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.dao.ILoginLogDao;
import lovo.j135_2.netctoss.logmag.mapper.LoginLogMapper;


@Repository
public class LoginLogDaoImpl implements ILoginLogDao {
	
	@Resource
	private LoginLogMapper loginLogMapper;

	@Override
	public void saveLoginLog(String name, Timestamp loginTime) {
		// TODO Auto-generated method stub		
		loginLogMapper.saveLoginLog(name, loginTime);
	}

	@Override
	public List<LoginLogBean> findLoginLogBeanByTimeToPage(LoginLogPageBean pageBean,String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return loginLogMapper.findLoginLogBeanByTimeToPage(pageBean,beginTime, endTime);
	}

	@Override
	public int findCountLoginLogBeanByTimeToPage(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return loginLogMapper.findCountLoginLogBeanByTimeToPage(beginTime, endTime);
	}

	@Override
	public List<LoginLogBean> findAllLoginLogBeanByTimeToPage(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return loginLogMapper.findAllLoginLogBeanByTimeToPage(beginTime, endTime);
	}

	@Override
	public LoginLogBean findLoginLogBeanById(Long id) {
		// TODO Auto-generated method stub
		return loginLogMapper.findLoginLogBeanById(id);
	}

	@Override
	public List<OperateLogBean> findOperateLogById(Long id) {
		// TODO Auto-generated method stub
		return loginLogMapper.findOperateLogById(id);
	}

	
}
