package board;

import java.util.ArrayList;
import java.util.List;

public class BoardList {
	private List<Article> articleList;
	private int requestPage;
	private int totalPageCount;
	private int startRow;
	private int endRow;

	public BoardList() {
		this(new ArrayList<Article>(), 0, 0, 0, 0);
	}
	
	public BoardList(List<Article> articleList, int requestPageNumber,
			int totalPageCount, int startRow, int endRow) {
		this.articleList = articleList;
		this.requestPage = requestPageNumber;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public List<Article> getArticleList() {
		return articleList;
	}
	
	public boolean isHasArticle() {
		return ! articleList.isEmpty();
	}

	public int getRequestPage() {
		return requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}
}
