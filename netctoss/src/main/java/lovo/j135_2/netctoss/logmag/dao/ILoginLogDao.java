package lovo.j135_2.netctoss.logmag.dao;

import java.sql.Timestamp;
import java.util.List;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface ILoginLogDao {
	/**
	 * 保存登录日志（保存登录管理员名字，登录时间为当前时间）
	 * @param name
	 */
	public int saveLoginLog(LoginLogBean bean);
	
	public List<LoginLogBean> findLoginLogBeanByTimeToPage(LoginLogPageBean pageBean,String account,String beginTime,String endTime) throws Exception;

	public int findCountLoginLogBeanByTimeToPage(String account,String beginTime,String endTime) throws Exception;

	public List<LoginLogBean> findAllLoginLogBeanByTimeToPage(String account,String beginTime,String endTime);
	
	
	
	public LoginLogBean findLoginLogBeanById(Long id);
	
	public List<OperateLogBean> findOperateLogById(Long id);
}
