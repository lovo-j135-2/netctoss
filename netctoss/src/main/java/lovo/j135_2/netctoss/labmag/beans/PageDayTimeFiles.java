package lovo.j135_2.netctoss.labmag.beans;

import java.util.List;

import lovo.j135_2.netctoss.paymag.beans.Pay;

public class PageDayTimeFiles {
	
	//总条数
	private int total;
	//页数
	private int page;
	//每页显示行数
	private int lines;
	//从第几行开始
	private int fromLine;
	
	private List<DayTimeFiles> rows;

	public PageDayTimeFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public int getFromLine() {
		return fromLine;
	}

	public void setFromLine(int fromLine) {
		this.fromLine = fromLine;
	}

	public List<DayTimeFiles> getRows() {
		return rows;
	}

	public void setRows(List<DayTimeFiles> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageDayTimeFiles [total=" + total + ", page=" + page + ", lines=" + lines + ", fromLine=" + fromLine
				+ ", rows=" + rows + "]";
	}

}
