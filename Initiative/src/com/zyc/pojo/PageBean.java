package com.zyc.pojo;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/6 下午9:56
 */
public class PageBean<T> {
    Integer totalCount;//总记录数
    //    Integer curPage;//当前页码
//    Integer numPerPage;//每页记录数
    Integer pageTotal;//总页数
    List<T> data;

    public PageBean(Integer totalCount, Integer pageTotal, List<T> data) {
        this.totalCount = totalCount;
        this.pageTotal = pageTotal;
        this.data = data;
    }

    public PageBean() {
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
