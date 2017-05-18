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
	public int saveLoginLog(LoginLogBean bean) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.saveLoginLog(bean);		//NullPointerException!!!!!!
	}

	@Override
	public LoginLogPageBean findLoginLogBeanByTimeToPage(LoginLogPageBean pageBean,String account,String beginTime, String endTime) throws Exception {
				
		
		pageBean.setTotal(loginLogDaoImpl.findCountLoginLogBeanByTimeToPage(account,beginTime,endTime));
		pageBean.setRows(loginLogDaoImpl.findLoginLogBeanByTimeToPage(pageBean,account,beginTime,endTime));
		return pageBean;
		
	}

	@Override
	public List<LoginLogBean> findAllLoginLogBeanByTimeToPage(String account,String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findAllLoginLogBeanByTimeToPage(account,beginTime, endTime);
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
