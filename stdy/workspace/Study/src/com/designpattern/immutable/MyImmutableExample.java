package com.designpattern.immutable;

public class MyImmutableExample {
	public static void main(String[] args) {
		MyImmutableExample instance = new MyImmutableExample();
		instance.process();
	}

	private void process() {
		String immutableArg1 = "Kalu";
		Integer immutableArg2 = 123;
		MyMutable immutableArg3 = new MyMutable("Bhaiya".toCharArray());
		MyImmutable immutable = new MyImmutable(immutableArg2, immutableArg1, immutableArg3);
		immutable.getMutable().setCharArray("Zindabad".toCharArray());
		System.out.println(immutable);
		
	}
}
