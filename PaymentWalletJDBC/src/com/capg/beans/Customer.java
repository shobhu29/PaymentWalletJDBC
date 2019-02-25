package com.capg.beans;

public class Customer {
	
	private String name;
	private String mobileno;											// CUSTOMER PROPERTIES
	private Wallet wallet;
	
	public Customer(String name, String mobileno, Wallet wallet) {
		super();
		this.name = name;												// PARAMETERIZED CONSTRUCTOR
		this.mobileno = mobileno;
		this.wallet = wallet;
	}
	public String getName() {											// GETTER AND SETTER METHODS
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	@Override															// OBJECT REPRESENTATION OF STRING
	public String toString() {
		return "Customer [name=" + name + ", mobileno=" + mobileno + ", wallet=" + wallet + "]";
	}
	
	
}
