package lovo.j135_2.netctoss.usermag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.beans.Pager;
import lovo.j135_2.netctoss.usermag.dao.IBusinessDao;
import lovo.j135_2.netctoss.usermag.mapper.BusinessMapper;
@Repository
public class BusinessDaoImpl implements IBusinessDao{
	@Resource
	private BusinessMapper businessMapper;
	@Override
	public int saveBusiness(Business business) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.saveBusiness(business);
	}

	@Override
	public int deleteBusiness(Long id) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.deleteBusiness(id);
	}

	@Override
	public int updateBusiness(Business business) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.updateBusiness(business);
	}

	@Override
	public Business queryBusinessByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.queryBusinessByName(name);
	}

	@Override
	public List<Business> queryBusinessByPager(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.queryBusinessByPager(pager);
	}

	@Override
	public Business findBusinessContainLabAndAccountAndPayByBusiId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.findBusinessContainLabAndAccountAndPayByBusiId(id);
	}

	@Override
	public int countTotalBusiness() throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.countTotalBusiness();
	}

	@Override
	public Business findBusinessByIdAndPassword(Long id, String password) throws Exception {
		// TODO Auto-generated method stub
		return businessMapper.findBusinessByIdAndPassword(id, password);
	}
}
