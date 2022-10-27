package org.mybatis.vo;

import java.io.Serializable;

/**
 * @author zyc
 * @date 2022/10/22
 */
public class PageItem implements Serializable {

    /**
     * 每页显示数量
     */
    private int pageSize;
    /**
     * 当前页码
     */
    private int curPage;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 总记录数
     */
    private int total;
    /**
     * 当前页数量
     */
    private int count;
    /**
     * 自动统计分页总数
     */
    private boolean autoCount;

    /**
     * 默认无参构造器，初始化各值
     */
    public PageItem() {
        this.pageSize = 20;
        this.curPage = 1;
        this.pages = 0;
        this.total = 0;
        this.count = 0;
        this.autoCount = true;
    }

    public PageItem(int curPage, int pageSize) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.autoCount = true;
    }

    public void calculate(int total) {
        this.setTotal(total);
        this.pages = (total / pageSize) + ((total % pageSize) > 0 ? 1 : 0);
        /* 如果当前页码超出总页数，自动更改为最后一页 */
        this.curPage = Math.min(this.curPage, pages);
    }

    /**
     * 获取分页起始位置和偏移量
     *
     * @return 分页起始位置和偏移量数组
     */
    public int[] paginate() {
        // 数量为零时,直接从0开始
        return new int[]{total > 0 ? (curPage - 1) * pageSize : 0, pageSize};
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAutoCount() {
        return autoCount;
    }

    public void setAutoCount(boolean autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public String toString() {
        return "PageItem{" +
                "pageSize=" + pageSize +
                ", curPage=" + curPage +
                ", pages=" + pages +
                ", total=" + total +
                ", count=" + count +
                ", autoCount=" + autoCount +
                '}';
    }
}
