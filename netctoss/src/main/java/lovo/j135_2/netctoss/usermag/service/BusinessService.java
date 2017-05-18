package lovo.j135_2.netctoss.usermag.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.beans.Pager;

/**
 * 业务业务
 * @author Administrator
 *
 */
public interface BusinessService {
	/**
	 * 添加业务
	 * @param business
	 * @return
	 * @throws Exception
	 */
	public int saveBusiness(Business business) throws Exception;
	/**
	 * 删除业务
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBusiness(Long id) throws Exception;
	/**
	 * 修改业务状
	 * @param business
	 * @return
	 * @throws Exception
	 */
	public int updateBusiness(Business business) throws Exception;
	/**
	 * 按业务账号查询业务
	 * @param name 业务账号
	 * @return
	 * @throws Exception
	 */
	public Business queryBusinessByName(String name) throws Exception;
	/**
	 * 分页查询
	 * @param pager
	 * @return
	 * @throws Exception
	 */
	public List<Business> queryBusinessByPager(Pager pager)throws Exception;
	
	
	public Business findBusinessContainLabAndAccountAndPayByBusiId(Long id) throws Exception;
	/**
	 * 查询总业务记录数
	 * @return
	 * @throws Exception
	 */
	public int countTotalBusiness()throws Exception;
	
	public Business findBusinessByIdAndPassword(Long id, String password) throws Exception;
	
	
	public Business findBusinessById(Long id) throws Exception;
}
