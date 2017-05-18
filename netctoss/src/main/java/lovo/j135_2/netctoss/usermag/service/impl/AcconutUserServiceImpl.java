package lovo.j135_2.netctoss.usermag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.PagerAccount;
import lovo.j135_2.netctoss.usermag.dao.IAcconutUserDao;
import lovo.j135_2.netctoss.usermag.service.AcconutUserService;
/**
 *
 * @author Administrator
 *
 */
@Service
public class AcconutUserServiceImpl implements AcconutUserService{
	@Resource
	private IAcconutUserDao acconutUserDaoImpl;
	@Override
	public int saveAcconutUser(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.saveAcconutUser(user);
	}

	@Override
	public int deleteAcconutUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.delAcconutUser(id);
	}

	@Override
	public int updateAcconutUser(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.updateAcconutUser(user);
	}

	@Override
	public AcconutUser queryAcconutUserById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.queryAcconutUserById(id);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByPager(PagerAccount pager) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.queryAcconutUserByPager(pager);
	}

	@Override
	public int updatePwdAndPhone(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.updatePwdAndPhone(user);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.queryAcconutUserByName(name);
	}

	@Override
	public int countTotalAcconutUser() throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.countTotalAcconutUser();
	}

	@Override
	public List<AcconutUser> findAllUserAccount() throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.findAllUserAccount();
	}

}
