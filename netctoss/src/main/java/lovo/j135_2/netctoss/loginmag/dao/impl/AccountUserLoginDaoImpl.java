package lovo.j135_2.netctoss.loginmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.loginmag.dao.IAccountUserLoginDao;
import lovo.j135_2.netctoss.loginmag.mapper.AccountUserLoginMapper;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
@Repository
public class AccountUserLoginDaoImpl implements IAccountUserLoginDao {

	@Resource
	private AccountUserLoginMapper accountUserLoginMapper;

	@Override
	public AcconutUser queryAcconutUserByAccountNameAndPwd(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.queryAcconutUserByAccountNameAndPwd(account);
	}

	@Override
	public AcconutUser getAccountUserByAccountName(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.getAccountUserByAccountName(account);
	}

	@Override
	public int updatePasswordByAccountName(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.updatePasswordByAccountName(account);
	}
	
	
}
