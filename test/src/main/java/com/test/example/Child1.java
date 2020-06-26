package com.test.example;

public class Child1 extends Person {
	
	private String middlename;
	
	Child1() {
		super();
		middlename = "middlename";
	}
	
	Child1(String name, String lastname, double height, Double width, boolean slovenian, String middlename) {
		super(name, lastname, height, width, slovenian);
		this.middlename = middlename;
	}
	
	public String getMiddlename() {
		return middlename;
	}
	
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

}
