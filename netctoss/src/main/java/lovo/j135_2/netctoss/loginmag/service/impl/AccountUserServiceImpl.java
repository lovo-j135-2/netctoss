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
	public int saveAccountUser(AcconutUser account)throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.saveAccountUser(account);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByAccountAndPwd(AcconutUser account)throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.queryAcconutUserByAccountAndPwd(account);
	}

	@Override
	public AcconutUser getAccountUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.getAccountUser(id);
	}

	@Override
	public int updateAccountUser(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginDaoImpl.updateAccountUser(account);
	}

}
