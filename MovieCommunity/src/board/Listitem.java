package board;

import java.util.ArrayList;

public class Listitem {
	private ArrayList list;
	private Paging paging;
	public Listitem(ArrayList list, Paging paging) {
		super();
		this.list = list;
		this.paging = paging;
	}
	public Listitem() {
		super();
	}
	public ArrayList getList() {
		return list;
	}
	public void setList(ArrayList list) {
		this.list = list;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	@Override
	public String toString() {
		return "List [list=" + list + ", paging=" + paging + "]";
	}
}
