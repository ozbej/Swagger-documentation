package com.test.example;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Person {
	private String name;
	
	private String lastname;
	
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "250.0", inclusive = true)
	private double height;
	
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "200.0", inclusive = true)
	private Double width;
	
	private boolean slovenian;
	
	
	Person() {
		this.name = "name";
		this.lastname = "lastname";
		this.height = 0;
		this.width = 0.0;
	}
	
	Person(String name, String lastname, double height, Double width, boolean slovenian) {
		this.name = name;
		this.lastname = lastname;
		this.height = height;
		this.width = width;
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
	
	public Double getWidth() {
		return width;
	}
	
	public void setWidth(Double width) {
		this.width = width;
	}
	
	public boolean getSlovenian() {
		return slovenian;
	}
	
	public void setSlovenian(boolean slovenian) {
		this.slovenian = slovenian;
	}
}
