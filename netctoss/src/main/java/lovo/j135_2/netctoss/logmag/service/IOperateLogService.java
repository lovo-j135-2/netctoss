package lovo.j135_2.netctoss.logmag.service;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;

public interface IOperateLogService {
	/**
	 * 保存操作日志
	 * @param operateLog
	 */
	public void saveOperateLog(OperateLogBean operateLog);
}
