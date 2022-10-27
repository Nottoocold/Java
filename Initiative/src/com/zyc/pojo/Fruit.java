package com.zyc.pojo;

import java.util.Map;
import java.util.Objects;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/6 上午10:25
 */
public class Fruit {
    private Integer id;
    private String name;
    private Integer price;
    private Integer count;
    private String remark;

    public Fruit(Integer id, String name, Integer price, Integer count, String remark) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.remark = remark;
    }

    public Fruit() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        if (!id.equals(fruit.id)) return false;
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, count, remark);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", remark='" + remark + '\'' +
                '}';
    }

    public static Fruit get(Map<String, String[]> map) {
        Fruit fruit = new Fruit();
        String[] value = {};
        for (String key : map.keySet()) {
            if ("id".equalsIgnoreCase(key)) {
                value = map.get(key);
                fruit.setId(Integer.parseInt(value[0]));
            } else if ("name".equalsIgnoreCase(key)) {
                value = map.get(key);
                fruit.setName(value[0]);
            } else if ("price".equalsIgnoreCase(key)) {
                value = map.get(key);
                fruit.setPrice(Integer.parseInt(value[0]));
            } else if ("count".equalsIgnoreCase(key)) {
                value = map.get(key);
                fruit.setCount(Integer.parseInt(value[0]));
            } else if ("remark".equalsIgnoreCase(key)) {
                value = map.get(key);
                fruit.setRemark(value[0]);
            }
        }
        return fruit;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public String getRemark() {
        return remark;
    }
}
