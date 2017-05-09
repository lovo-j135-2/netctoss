package lovo.j135_2.netctoss.loginmag.service;

import java.util.List;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public interface IAccountUserLoginService {
	/**
	 * 用户注册（保存，增加用户）
	 * @param account
	 * @return
	 */
	public int saveAccountUser(AcconutUser account) throws Exception;
	/**
	 * 用户登录（普通用户通过账号和密码登录）
	 * @param account
	 * @return
	 */
	public List<AcconutUser> queryAcconutUserByAccountAndPwd(AcconutUser account) throws Exception;
	/**
	 * 根据id查看用户信息
	 * @param id
	 * @return
	 */
	public AcconutUser getAccountUser(Long id) throws Exception;
	/**
	 * 修改用户信息（修改密码）
	 * @param account
	 * @return
	 */
	public int updateAccountUser(AcconutUser account) throws Exception;
	/**
	 * 退出系统
	 */

}
