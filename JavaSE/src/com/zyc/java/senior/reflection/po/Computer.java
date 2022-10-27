package com.zyc.java.senior.reflection.po;

public class Computer {
	String brand;
	Double price;
	
	public Computer() {
	}
	
	public Computer(String brand, Double price) {
		this.brand = brand;
		this.price = price;
	}
	
	public void start() {
		System.out.println("Power on");
	}
	
	public void shut() {
		System.out.println("Power off");
	}
	
	@Override
	public String toString() {
		return "Computer info, brand is " + brand + ",Price is гд" + price;
	}
}
