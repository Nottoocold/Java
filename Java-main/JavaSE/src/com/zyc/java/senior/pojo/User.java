package com.zyc.java.senior.pojo;

import java.io.Serializable;
import java.util.Comparator;

public class User implements Serializable,Comparator<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8464854457789676394L;
	private String id;
	private String name;
	private String sex;
	private Integer age;
	private Double high;
	public User() {
		this.sex = "boy";
	}
	public User(String id, String name, Integer age, Double high) {
		this();
		this.id = id;
		this.name = name;
		this.age = age;
		this.high = high;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	@Override
	public String toString() {
		return "User [ 编号=" + id + ", 姓名=" + name + ", 性别=" + sex + ", 年龄=" + age + ", 身高=" + high + "cm ]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	/**
	 * Both id and name is the same ,then User is the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compare(User o1, User o2) {
		if (o1 == null)
			return -1;
		if(!o1.getId().equals(o2.getId()))
			return o1.getId().compareTo(o2.getId());
		else if(!o1.getName().equals(o2.getName()))
			return o1.getName().compareTo(o2.getName());
		return -1;
	}
}
