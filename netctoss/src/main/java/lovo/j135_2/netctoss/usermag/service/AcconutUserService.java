package lovo.j135_2.netctoss.usermag.service;

import java.util.List;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.PagerAccount;

/**
 * 账务业务
 * @author Administrator
 *
 */
public interface AcconutUserService {
	/**
	 * 添加账务账号
	 * @param user 账务账号
	 * @return
	 */
	public int saveAcconutUser(AcconutUser user) throws Exception;
	/**
	 * 按账务id删除账务账号
	 * @param id
	 * @return
	 */
	public int deleteAcconutUser(Long id) throws Exception;
	/**
	 * 修改账务密码和电话
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updatePwdAndPhone(AcconutUser user)throws Exception;
	/**
	 * 修改账务账号状
	 * @param user
	 * @return
	 */
	public int updateAcconutUser(AcconutUser user) throws Exception;
	/**
	 * 按账务id查询账务信息
	 * @param id 账务id
	 * @return 账务对象
	 */
	public AcconutUser queryAcconutUserById(Long id) throws Exception; 
	/**
	 * 按账务名查询账务
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<AcconutUser> queryAcconutUserByName(String name)throws Exception;
	/**
	 * 分页查询账务
	 * @param pager
	 * @return
	 * @throws Exception
	 */
	public List<AcconutUser> queryAcconutUserByPager(PagerAccount pager)throws Exception;
	/**
	 * 查询总记录
	 * @return
	 * @throws Exception
	 */
	public int countTotalAcconutUser()throws Exception;
	
	public List<AcconutUser> findAllUserAccount() throws Exception;
}
