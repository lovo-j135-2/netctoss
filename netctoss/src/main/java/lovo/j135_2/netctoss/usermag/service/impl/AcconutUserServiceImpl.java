package lovo.j135_2.netctoss.usermag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Pager;
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
	public int deleteAcconutUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.delAcconutUser(id);
	}

	@Override
	public int updateAcconutUser(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.updateAcconutUser(user);
	}

	@Override
	public AcconutUser queryAcconutUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.queryAcconutUserById(id);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByPager(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserDaoImpl.queryAcconutUserByPager(pager);
	}

}
