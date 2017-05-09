package lovo.j135_2.netctoss.usermag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Pager;
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
	public int delAcconutUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.deleteAcconutUser(id);
	}

	@Override
	public int updateAcconutUser(AcconutUser user) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.updateAcconutUser(user);
	}

	@Override
	public AcconutUser queryAcconutUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.queryAcconutUserById(id);
	}

	@Override
	public List<AcconutUser> queryAcconutUserByPager(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return acconutUserMapper.queryAcconutUserByPager(pager);
	}

}
