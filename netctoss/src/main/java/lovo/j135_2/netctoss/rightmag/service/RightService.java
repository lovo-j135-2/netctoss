package lovo.j135_2.netctoss.rightmag.service;

import java.util.List;

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
	public void updateRight(String rightName,String description);
	
	/**
	 * 查询
	 */
	public List<Right> rightList();
}
