package lovo.j135_2.netctoss.rightmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;

public interface RightDao {
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
	public List<Right> getRights(Page page);

	/**
	 * 查询权限（修改角色时调用）
	 */
	public List<Right> getRights();
	
	/**
	 *返回查询数据总条数 
	 */
	public int getRightsCount();
	
	/**
	 * 根据Id查询权限
	 */
	public Right findRightBeanById(long id);
}
