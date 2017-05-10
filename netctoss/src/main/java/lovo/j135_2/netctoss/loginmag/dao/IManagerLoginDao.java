package lovo.j135_2.netctoss.loginmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.managermag.beans.Manager;

public interface IManagerLoginDao {
	/**
	 * 管理员登录（通过管理员用户名和密码）
	 * @param ma
	 * @return
	 */
public Manager queryManagerByaccountsAndPassword(Manager manager) throws Exception;
	/**
	 * 根据id查看管理员信息
	 * @param id
	 * @return
	 */
public Manager getManagerById(Long id)throws Exception;
	/**
	 * 根据管理员名字查看管理员信息
	 * @param accounts
	 * @return
	 */
public Manager getManagerByaccounts(Manager manager)throws Exception;



	/**
	 * 根据管理员名字修改管理员信息（修改密码）
	 * @param manager
	 * @return
	 */
public int updatePasswordByAccounts(Manager manager)throws Exception; 

    /**
     * 退出系统
     */
	
	
}
