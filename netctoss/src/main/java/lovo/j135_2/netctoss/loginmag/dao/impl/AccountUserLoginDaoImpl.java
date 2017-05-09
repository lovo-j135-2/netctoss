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
	public int saveAccountUser(AcconutUser account)throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.saveAccountUser(account);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByAccountAndPwd(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.queryAcconutUserByAccountAndPwd(account);
	}

	@Override
	public AcconutUser getAccountUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.getAccountUser(id);
	}

	@Override
	public int updateAccountUser(AcconutUser account) throws Exception {
		// TODO Auto-generated method stub
		return accountUserLoginMapper.updateAccountUser(account);
	}

}
