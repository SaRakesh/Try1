package com.generic.basic.try1;

public class PersionDetails {

	private String name;
	private String address;
	private int age;
	private String aadhar;
	private String PAN;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	@Override
	public String toString() {
		return "MyPOJOClass [name=" + name + ", address=" + address + ", age=" + age + ", aadhar=" + aadhar + ", PAN="
				+ PAN + "]";
	}
	
	
}
