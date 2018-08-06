package com.designpattern.immutable;

public final class MyImmutable {

	private final Integer immutableField1;
	
	private final String ImmutableFiel2;
	
	private final MyMutable mutable;
	

	public Integer getImmutableField1() {
		return immutableField1;
	}


	public String getImmutableFiel2() {
		return ImmutableFiel2;
	}


	@Override
	public String toString() {
		return "MyImmutable [immutableField1=" + immutableField1 + ", ImmutableFiel2=" + ImmutableFiel2 + ", mutable="
				+ mutable + "]";
	}


	public MyMutable getMutable() {
		return new MyMutable(this.mutable.getCharArray());
	}


	public MyImmutable(Integer immutableField1, String immutableFiel2, MyMutable mutable) {
		super();
		this.immutableField1 = immutableField1;
		this.ImmutableFiel2 = immutableFiel2;
		this.mutable = new MyMutable(mutable.getCharArray());
	}
	
}
