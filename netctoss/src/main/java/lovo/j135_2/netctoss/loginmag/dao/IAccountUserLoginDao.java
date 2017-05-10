package lovo.j135_2.netctoss.loginmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public interface IAccountUserLoginDao {
	/**
	 * 用户登录（普通用户通过账号和密码登录）
	 * @param account
	 * @return
	 */
	public AcconutUser queryAcconutUserByAccountNameAndPwd(AcconutUser account) throws Exception;
	
	/**
	 * 根据AccountName查看用户信息
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public AcconutUser getAccountUserByAccountName(AcconutUser account) throws Exception;
	
	/**
	 * 修改用户信息（修改密码）
	 * @param account
	 * @return
	 */
	public int updatePasswordByAccountName(AcconutUser account)throws Exception;
	
	
	/**
	 * 退出系统
	 */



}
