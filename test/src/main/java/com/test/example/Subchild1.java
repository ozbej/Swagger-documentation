package com.test.example;

public class Subchild1 extends Child1{
	private String subchildProp;
	
	Subchild1() {
		super();
		subchildProp = "subchildProp";
	}
	
	Subchild1(String name, String lastname, double height, Double width, boolean slovenian, String middlename, Child1 child, Subchild1 subchild) {
		super(name, lastname, height, width, slovenian, middlename, child, subchild);
		this.subchildProp = "subchildProp";
	}
	
	public String getSubchildProp() {
		return subchildProp;
	}
	
	public void setSubchildProp(String subchildProp) {
		this.subchildProp = subchildProp;
	}
}
