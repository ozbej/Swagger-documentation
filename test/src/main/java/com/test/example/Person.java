package com.test.example;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Person {
	private String name;
	
	private String lastname;
	
	private Child1 child;
	
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "250.0", inclusive = true)
	private double height;
	
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "200.0", inclusive = true)
	private Double weight;
	
	private boolean slovenian;
	
	
	Person() {
		this.name = "name";
		this.lastname = "lastname";
		this.height = 0;
		this.weight = 0.0;
	}
	
	Person(String name, String lastname, double height, Double width, boolean slovenian, Child1 child) {
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
	
	public Child1 getChild() {
		return child;
	}
	
	public void setChild(Child1 child) {
		this.child = child;
	}
}
