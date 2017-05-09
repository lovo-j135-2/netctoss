package lovo.j135_2.netctoss.logmag.dao.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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
	public Long findLoginLogIdByLoginDate(Timestamp loginTime) {
		// TODO Auto-generated method stub
		return loginLogMapper.findLoginLogIdByLoginDate(loginTime);
	}

	@Override
	public void updateLoginLog(Timestamp quitTime, Long id) {
		// TODO Auto-generated method stub
		loginLogMapper.updateLoginLog(quitTime, id);
	}
}
