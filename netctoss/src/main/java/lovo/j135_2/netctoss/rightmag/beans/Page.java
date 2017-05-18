package lovo.j135_2.netctoss.rightmag.beans;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	private int page;//当前页数
	private int index;//当页起始位置
	private int total;//总条数
	private int lines;//每页显示条数
	private int totalPages;//总页数
	private List<?>rows;
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int page, int index, int total, int lines, int totalPages, List<?> rows) {
		super();
		this.page = page;
		this.index = index;
		this.total = total;
		this.lines = lines;
		this.totalPages = totalPages;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", index=" + index + ", total=" + total + ", lines=" + lines + ", totalPages="
				+ totalPages + ", rows=" + rows + "]";
	}
	
}
