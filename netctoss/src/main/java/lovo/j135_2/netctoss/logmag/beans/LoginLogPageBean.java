package lovo.j135_2.netctoss.logmag.beans;

import java.io.Serializable;
import java.util.List;

public class LoginLogPageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622629696581120443L;
	
	private int page;	//当前第几页
	private int lines;	//每页显示条数
	private int index;	//当页起始位置
	private int total;	//总条数
	private int totalPages; //总页数
	private List<LoginLogBean> rows;	//当页数据列表
	
	
	public LoginLogPageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginLogPageBean(int page, int lines, int index, int total, int totalPages, List<LoginLogBean> rows) {
		super();
		this.page = page;
		this.lines = lines;
		this.index = index;
		this.total = total;
		this.totalPages = totalPages;
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "LoginLogPageBean [page=" + page + ", lines=" + lines + ", index=" + index + ", total=" + total
				+ ", totalPages=" + totalPages + ", rows=" + rows + "]";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<LoginLogBean> getRows() {
		return rows;
	}
	public void setRows(List<LoginLogBean> rows) {
		this.rows = rows;
	}
	
	
	
	
	
	
	
	
}
