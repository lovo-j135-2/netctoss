package lovo.j135_2.netctoss.loginmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.loginmag.dao.IAccountUserLoginDao;
import lovo.j135_2.netctoss.loginmag.service.IAccountUserLoginService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@Service
public class AccountUserServiceImpl implements IAccountUserLoginService {

	@Resource
	private IAccountUserLoginDao accountUserLoginDaoImpl;

	@Override
	public AcconutUser queryAcconutUserByAccountNameAndPwd(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.queryAcconutUserByAccountNameAndPwd(account);
	}

	@Override
	public AcconutUser getAccountUserByAccountName(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.getAccountUserByAccountName(account);
	}

	@Override
	public int updatePasswordByAccountName(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.updatePasswordByAccountName(account);
	}

	
}
