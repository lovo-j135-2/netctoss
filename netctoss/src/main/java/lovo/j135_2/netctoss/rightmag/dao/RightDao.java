package lovo.j135_2.netctoss.rightmag.dao;

import java.util.List;

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
	 * 查询
	 */
	public List<Right> getRights();
}
