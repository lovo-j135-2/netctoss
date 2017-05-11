package lovo.j135_2.netctoss.logmag.beans;

import java.io.Serializable;
import java.util.List;

public class LoginLogPageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622629696581120443L;
	
	private int page;	//当前第几页
	private int rows;	//每页显示条数
	private int index;	//当页起始位置
	private int totalRows;	//总条数
	private int totalPages; //总页数
	private List<LoginLogBean> datas;	//当页数据列表
	
	
	public LoginLogPageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginLogPageBean(int page, int rows, int index, int totalRows, int totalPages, List<LoginLogBean> datas) {
		super();
		this.page = page;
		this.rows = rows;
		this.index = index;
		this.totalRows = totalRows;
		this.totalPages = totalPages;
		this.datas = datas;
	}
	@Override
	public String toString() {
		return "LoginLogPageBean [page=" + page + ", rows=" + rows + ", index=" + index + ", totalRows=" + totalRows
				+ ", totalPages=" + totalPages + ", datas=" + datas + "]";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<LoginLogBean> getDatas() {
		return datas;
	}
	public void setDatas(List<LoginLogBean> datas) {
		this.datas = datas;
	}
	
	
	
	
}
