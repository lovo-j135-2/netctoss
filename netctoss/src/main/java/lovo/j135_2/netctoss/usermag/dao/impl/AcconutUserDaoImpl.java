package lovo.j135_2.netctoss.usermag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.PagerAccount;
import lovo.j135_2.netctoss.usermag.dao.IAcconutUserDao;
import lovo.j135_2.netctoss.usermag.mapper.AcconutUserMapper;
@Repository
public class AcconutUserDaoImpl implements IAcconutUserDao {
	@Resource
	private AcconutUserMapper acconutUserMapper;
	@Override
	public int saveAcconutUser(AcconutUser user) throws Exception {
		// TODO Auto-generated method stubso
		return acconutUserMapper.saveAcconutUser(user);
	}

	@Override
	public int delAcconutUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.deleteAcconutUser(id);
	}

	@Override
	public int updateAcconutUser(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.updateAcconutUser(user);
	}

	@Override
	public AcconutUser queryAcconutUserById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.queryAcconutUserById(id);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByPager(PagerAccount pager) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.queryAcconutUserByPager(pager);
	}
	@Override
	public int updatePwdAndPhone(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.updatePwdAndPhone(user);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.queryAcconutUserByName(name);
	}

	@Override
	public int countTotalAcconutUser() throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.countTotalAcconutUser();
	}

	@Override
	public List<AcconutUser> findAllUserAccount() throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.findAllUserAccount();
	}
}
