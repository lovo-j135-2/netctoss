package lovo.j135_2.netctoss.logmag.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.dao.ILoginLogDao;
import lovo.j135_2.netctoss.logmag.service.ILoginLogService;

@Service
public class LoginLogServiceImpl implements ILoginLogService {
	
	@Resource
	private ILoginLogDao loginLogDaoImpl;
	
	@Override
	public void saveLoginLog(String name, Timestamp loginTime) {
		// TODO Auto-generated method stub
		loginLogDaoImpl.saveLoginLog(name, loginTime);		//NullPointerException!!!!!!
	}

	@Override
	public List<LoginLogBean> findLoginLogBeanByTimeToPage(LoginLogPageBean pageBean,String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findLoginLogBeanByTimeToPage(pageBean,beginTime, endTime);
	}

	@Override
	public int findCountLoginLogBeanByTimeToPage(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findCountLoginLogBeanByTimeToPage(beginTime, endTime);
	}

	@Override
	public List<LoginLogBean> findAllLoginLogBeanByTimeToPage(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findAllLoginLogBeanByTimeToPage(beginTime, endTime);
	}

	@Override
	public LoginLogBean findLoginLogBeanById(Long id) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findLoginLogBeanById(id);
	}

	@Override
	public List<OperateLogBean> findOperateLogById(Long id) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findOperateLogById(id);
	}

	
	

}
