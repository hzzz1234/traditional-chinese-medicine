package com.hzzz.tcm.web.vo;

public class Page {
	public static void main(String args[]) {
		Page page = new Page();
		page.setItemCount(61l);
		System.out.println(page.getPageCount());
	}

	private Long itemCount = 0l;
	private Long curPage = 1l;
	private Long pageCount = 1l;
	private Long pageSize = 10l;
	private Long startItem = 0l;

	public Page() {
	}

	public Page(Long curPage, Long pageSize) {
		this.curPage = curPage;
		this.pageSize = pageSize;
		if (curPage != null && curPage > 1) {
			startItem = (curPage - 1) * pageSize;
		}
	}

	public Page(Long itemCount) {
		this.setItemCount(itemCount);
	}

	public Long getItemCount() {
		return itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
		if (itemCount != null && itemCount > pageSize) {
			pageCount = itemCount / pageSize;
			int i = (int) (itemCount % pageSize);
			if (i > 0) {
				pageCount = pageCount + 1;
			}
		}
	}

	public Long getCurPage() {
		return curPage;
	}

	public void setCurPage(Long curPage) {
		this.curPage = curPage;
		if (curPage != null && curPage > 1) {
			startItem = (curPage - 1) * pageSize;
		}
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getStartItem() {
		return startItem;
	}

	public void setStartItem(Long startItem) {
		this.startItem = startItem;
	}

}