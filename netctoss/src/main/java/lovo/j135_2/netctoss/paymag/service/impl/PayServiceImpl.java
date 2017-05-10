package lovo.j135_2.netctoss.paymag.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.paymag.dao.PayDao;
import lovo.j135_2.netctoss.paymag.service.PayService;

@Service
public class PayServiceImpl implements PayService {
	
	@Resource
	private PayDao payDaoImpl;

	@Override
	public int addPay(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		return payDaoImpl.addPay(pay);
	}

	@Override
	public int deletePay(Long id) throws Exception {
		// TODO Auto-generated method stub
		return payDaoImpl.deletePay(id);
	}

	@Override
	public int updatePay(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		return payDaoImpl.updatePay(pay);
	}

	@Override
	public int updatePayStatus(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		return payDaoImpl.updatePayStatus(pay);
	}

	@Override
	public PagePay findPaysByTime(List<Date> dates,PagePay pagePay) throws Exception {
		// TODO Auto-generated method stub
		pagePay.setFromLine((pagePay.getPage()-1)*pagePay.getLines());
		pagePay.setTotal(payDaoImpl.findPayCountByTime(dates));
		pagePay.setRows(payDaoImpl.findPaysByTime(dates, pagePay));
		return pagePay;
	}

}
