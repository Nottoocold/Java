package com.zyc.book.pojo;

//购物车项Bean
public class CartItem {
    private Integer id;
    private Integer book;
    private Integer bugCount;//购物车中图书数量
    private Integer userBean;//所属用户

    private Book bookInfo;
    private User userInfo;

    public CartItem() {
    }

    public CartItem(Integer id, Integer book, Integer bugCount, Integer userBean) {
        this.id = id;
        this.book = book;
        this.bugCount = bugCount;
        this.userBean = userBean;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", book=" + book +
                ", bugCount=" + bugCount +
                ", userBean=" + userBean +
                '}';
    }

    public Book getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
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

    public Integer getUserBean() {
        return userBean;
    }

    public void setUserBean(Integer userBean) {
        this.userBean = userBean;
    }
}
