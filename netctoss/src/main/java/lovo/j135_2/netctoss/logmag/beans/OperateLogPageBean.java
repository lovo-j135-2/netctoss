package lovo.j135_2.netctoss.logmag.beans;

import java.io.Serializable;
import java.util.List;

public class OperateLogPageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8187251180920087691L;
	private int page;	//当前第几页
	private int lines;	//每页显示条数
	private int index;	//当页起始位置
	private int total;	//总条数
	private List<OperateLogBean> rows;	//当页数据列表
	
	
	public OperateLogPageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperateLogPageBean(int page, int lines, int index, int total, List<OperateLogBean> rows) {
		super();
		this.page = page;
		this.lines = lines;
		this.index = index;
		this.total = total;
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "OperateLogPageBean [page=" + page + ", lines=" + lines + ", index=" + index + ", total=" + total
				+ ", rows=" + rows + "]";
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
	public List<OperateLogBean> getRows() {
		return rows;
	}
	public void setRows(List<OperateLogBean> rows) {
		this.rows = rows;
	}
	
	
	
	
	
	
	
}
