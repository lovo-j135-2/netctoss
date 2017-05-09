package lovo.j135_2.netctoss.logmag.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	public Long findLoginLogIdByLoginDate(Timestamp loginTime) {
		// TODO Auto-generated method stub
		return loginLogDaoImpl.findLoginLogIdByLoginDate(loginTime);
	}

	@Override
	public void updateLoginLog(Timestamp quitTime, Long id) {
		// TODO Auto-generated method stub
		loginLogDaoImpl.updateLoginLog(quitTime, id);
	}

}
