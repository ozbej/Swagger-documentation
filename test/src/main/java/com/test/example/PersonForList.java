package com.test.example;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class PersonForList {
private String name;
	
	private String lastname;
	
	
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "250.0", inclusive = true)
	private double height;
	
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "200.0", inclusive = true)
	private Double weight;
	
	private boolean slovenian;
	
	
	PersonForList() {
		this.name = "name";
		this.lastname = "lastname";
		this.height = 0;
		this.weight = 0.0;
	}
	
	PersonForList(String name, String lastname, double height, Double width, boolean slovenian, Child1 child) {
		this.name = name;
		this.lastname = lastname;
		this.height = height;
		this.weight = width;
		this.slovenian = slovenian;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double width) {
		this.weight = width;
	}
	
	public boolean getSlovenian() {
		return slovenian;
	}
	
	public void setSlovenian(boolean slovenian) {
		this.slovenian = slovenian;
	}
	@Override
    public String toString() {
        return "Person [name=" + name + ", lastname=" + lastname + "]";
    }
}
