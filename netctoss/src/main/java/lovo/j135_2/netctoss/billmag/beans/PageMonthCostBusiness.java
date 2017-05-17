package lovo.j135_2.netctoss.billmag.beans;

import java.io.Serializable;
import java.util.List;

public class PageMonthCostBusiness implements Serializable {

	//总条数
	private int total;
	//页数
	private int page;
	//每页显示行数
	private int lines;
	//从第几行开始
	private int fromLine;
	//每页显示内容
	private List<MonthCostBussiness> rows;
	public PageMonthCostBusiness() {
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
	
	public List<MonthCostBussiness> getRows() {
		return rows;
	}
	public void setRows(List<MonthCostBussiness> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "PageMonthCostAccount [total=" + total + ", page=" + page + ", lines=" + lines + ", fromLine=" + fromLine
				+ ", rows=" + rows + "]";
	}
}
