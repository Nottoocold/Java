package com.zyc.book.pojo;

//订单详情Bean
public class OrderItem {
    private Integer id;
    private Integer book;
    private Integer bugCount;
    private Integer orderBean;

    private Book bookInfo;//图书Bean
    private OrderBean orderBeanInfo; //所属订单Bean 多个订单详情属于一个订单

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer book, Integer bugCount, Integer orderBean) {
        this.id = id;
        this.book = book;
        this.bugCount = bugCount;
        this.orderBean = orderBean;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", book=" + book +
                ", bugCount=" + bugCount +
                ", orderBean=" + orderBean +
                '}';
    }

    public Book getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }

    public OrderBean getOrderBeanInfo() {
        return orderBeanInfo;
    }

    public void setOrderBeanInfo(OrderBean orderBeanInfo) {
        this.orderBeanInfo = orderBeanInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBugCount() {
        return bugCount;
    }

    public void setBugCount(Integer bugCount) {
        this.bugCount = bugCount;
    }

    public Integer getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Integer orderBean) {
        this.orderBean = orderBean;
    }
}
