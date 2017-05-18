package lovo.j135_2.netctoss.rightmag.service;

import java.util.List;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;

public interface RightService {
	/**
	 * 增加权限
	 */
	public void saveRight(Right right);
	
	/**
	 * 删除权限
	 */
	public void deleteRight(long id);
	
	/**
	 * 修改权限
	 */
	public void updateRight(Right right);
	
	/**
	 * 查询（分页）
	 */
	public Page getRights(Page page);
	public List<Right> getRights();
	
	/**
	 * 根据Id查询权限
	 */
	public Right findRightBeanById(long id);
}
