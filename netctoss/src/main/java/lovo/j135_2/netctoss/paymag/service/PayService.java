package lovo.j135_2.netctoss.paymag.service;

import java.util.Date;
import java.util.List;

import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.beans.Pay;


public interface PayService {

	/**
	 * 添加资费
	 * @param pay
	 * @return
	 */
	public int addPay(Pay pay) throws Exception;
	
	/**
	 * 删除资费
	 * @param id
	 * @return
	 */
	public int deletePay(Long id) throws Exception;
	
	/**
	 * 更新资费内容
	 * @param pay
	 * @return
	 * @throws Exception
	 */
	public int updatePay(Pay pay) throws Exception;
	
	/**
	 * 修改资费状态
	 * @param pay
	 * @return
	 * @throws Exception
	 */
	public int updatePayStatus(Pay pay) throws Exception;
	
	/**
	 * 通过资费的开通时间来查找资费
	 * @param dates
	 * @return 返回资费查找list
	 * @throws Exception
	 */
	public PagePay findPaysByTime(List<Date> dates,PagePay pagePay) throws Exception;
	
}
