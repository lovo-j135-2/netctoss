package lovo.j135_2.netctoss.accoutmag.beans;

import java.io.Serializable;
import java.util.List;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;

public class PageMonthAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3747140236811337276L;
	private int page;	//当前第几页
	private int lines;	//每页显示条数
	private int index;	//当页起始位置
	private int total;	//总条数
	private int totalPages; //总页数
	private List<MonthAccount> rows;	//当页数据列表
	public PageMonthAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageMonthAccount(int page, int lines, int index, int total, int totalPages, List<MonthAccount> rows) {
		super();
		this.page = page;
		this.lines = lines;
		this.index = index;
		this.total = total;
		this.totalPages = totalPages;
		this.rows = rows;
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
	public List<MonthAccount> getRows() {
		return rows;
	}
	public void setRows(List<MonthAccount> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "PageMonthAccount [page=" + page + ", lines=" + lines + ", index=" + index + ", total=" + total
				+ ", totalPages=" + totalPages + ", rows=" + rows + "]";
	}
	
}
