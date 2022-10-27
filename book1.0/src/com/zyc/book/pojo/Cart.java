package com.zyc.book.pojo;

import com.zyc.ssm.utils.NumberFormatUtils;

import java.util.Collection;
import java.util.Map;

//购物车Bean
public class Cart {
    private Map<Integer, CartItem> cartMap; // key : 购物车书籍id ; value : cartItem
    private Double totalMoney; //总金额
    private Integer totalCount; // 购物车中有多少项

    public Cart() {
    }

    public Map<Integer, CartItem> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Integer, CartItem> cartMap) {
        this.cartMap = cartMap;
    }

    public Double getTotalMoney() {
        this.totalMoney = 0.0;
        cartMap.forEach((integer, cartItem) -> {
            double v = cartItem.getBookInfo().getPrice() * cartItem.getBugCount();
            totalMoney += v;
        });
        String s = NumberFormatUtils.formatDecimal(totalMoney, NumberFormatUtils.numberFormaterPattern1);
        totalMoney = Double.valueOf(s);
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        Collection<CartItem> values = cartMap.values();
        values.forEach(e -> {
            totalCount = e.getBugCount() + totalCount;
        });
        return totalCount;
    }
}
