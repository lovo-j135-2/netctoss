package lovo.j135_2.netctoss.paymag.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.paymag.dao.PayDao;
import lovo.j135_2.netctoss.paymag.mapper.PayMapper;

@Repository
public class PayDaoImpl implements PayDao {
	
	@Resource
	private PayMapper payMapper;

	@Override
	public int addPay(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		return payMapper.addPay(pay);
	}

	@Override
	public int deletePay(Long id) throws Exception {
		// TODO Auto-generated method stub
		return payMapper.deletePay(id);
	}

	@Override
	public int updatePay(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		return payMapper.updatePay(pay);
	}

	@Override
	public int updatePayStatus(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		return payMapper.updatePayStatus(pay);
	}

	@Override
	public List<Pay> findPaysByTime(List<Date> dates, PagePay pagePay) throws Exception {
		// TODO Auto-generated method stub
		return payMapper.findPaysByTime(dates, pagePay);
	}

	@Override
	public int findPayCountByTime(List<Date> dates) throws Exception {
		// TODO Auto-generated method stub
		return payMapper.findPayCountByTime(dates);
	}
	
	
}
