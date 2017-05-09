package lovo.j135_2.netctoss.logmag.service;

import java.sql.Timestamp;	//这里也是SqlDate，要不要的？？？

public interface ILoginLogService {
	/**
	 * 保存登录日志（保存登录管理员名字，登录时间为当前时间）
	 * @param name
	 */
	public void saveLoginLog(String name,Timestamp loginTime);
	
	public Long findLoginLogIdByLoginDate(Timestamp loginTime);	//查找刚刚save的这条登录日志记录
	
	/**
	 * 修改登录日志，即添加退出的时间（当前时间）
	 * @param date
	 */
	public void updateLoginLog(Timestamp quitTime,Long id);
}
