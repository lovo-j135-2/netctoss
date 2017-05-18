package lovo.j135_2.netctoss.usermag.beans;

import java.util.List;

public class PagerAccount {
	//总条数
		private int total;
		//页数
		private int page;
		//每页显示行数
		private int lines;
		//从第几行开始
		private int fromLine;
		//每页显示内容
		private List<AcconutUser> rows;
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
		public List<AcconutUser> getRows() {
			return rows;
		}
		public void setRows(List<AcconutUser> rows) {
			this.rows = rows;
		}
		public PagerAccount() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "PagerAccount [total=" + total + ", page=" + page + ", lines=" + lines + ", fromLine=" + fromLine
					+ ", rows=" + rows + "]";
		}
		

}
