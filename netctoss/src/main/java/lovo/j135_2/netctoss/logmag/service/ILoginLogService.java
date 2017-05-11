package lovo.j135_2.netctoss.logmag.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface ILoginLogService {
	/**
	 * 保存登录日志（保存登录管理员名字，登录时间为当前时间）
	 * @param name
	 */
	public void saveLoginLog(String name,Timestamp loginTime);
	
	/**
	 * 传统：分页查询登录日志
	 * @param beginTime	起始登录时间
	 * @param endTime	结束登录时间
	 * @return
	 */
	public List<LoginLogBean> findLoginLogBeanByTimeToPage(LoginLogPageBean pageBean,String beginTime,String endTime) throws Exception;
	
	public int findCountLoginLogBeanByTimeToPage(String beginTime,String endTime);
	
	/**
	 * 据说：可以利用easyUI的假分页
	 * @param beginTime	起始登录时间
	 * @param endTime	结束登录时间
	 * @return
	 */
	public List<LoginLogBean> findAllLoginLogBeanByTimeToPage(String beginTime,String endTime);
	
	/**
	 * 根据id查询对应的LoginLogBean，顺带查出对应的OperateLogBean
	 * @param id
	 * @return
	 */
	public LoginLogBean findLoginLogBeanById(Long id);
	
	/**
	 * 页面效果是点击某条登录日志记录，弹窗显示这条记录对应的所有详细操作日志记录，所以上面的方法没用，直接通过id查找详细操作日志List显示就行
	 * @param id
	 * @return
	 */
	public List<OperateLogBean> findOperateLogById(Long id);
}
