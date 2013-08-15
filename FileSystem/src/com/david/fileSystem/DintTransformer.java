package com.david.fileSystem;

public class DintTransformer implements TextTransformer<Dint> {

	public String toWrite(Dint value) {
		System.out.println("WRITE");
		return value.toString();
	}

	public Dint fromRead(String s) {
		System.out.println("HELLO");
		return new Dint(Integer.parseInt(s));
	}

}
