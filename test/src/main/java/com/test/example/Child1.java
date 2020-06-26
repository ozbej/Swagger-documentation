package com.test.example;

public class Child1 extends Person {
	
	private String middlename;
	
	private Subchild1 subchild;
	
	Child1() {
		super();
		middlename = "middlename";
	}
	
	Child1(String name, String lastname, double height, Double width, boolean slovenian, String middlename, Child1 child, Subchild1 subchild) {
		super(name, lastname, height, width, slovenian, child);
		this.middlename = middlename;
		this.subchild = subchild; 
	}
	
	public String getMiddlename() {
		return middlename;
	}
	
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	public Subchild1 getSubchild() {
		return subchild;
	}
	
	public void setSubchild(Subchild1 subchild) {
		this.subchild = subchild;
	}
}
