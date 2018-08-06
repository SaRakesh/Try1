package com.parser.stringsprite.pojo;

public enum MyEnum {
	MyEnum1(1),MyEnum2(2),MyEnum3(3),MyEnum4(4),MyEnum5(5),MyEnum6(6),MyEnum7(7),MyEnum8(8);

	int count;
	private MyEnum(int count){
		this.count = count;
	}
	
	public String myFunction(){
		return "count value is "+this.count;
		
	}
}
