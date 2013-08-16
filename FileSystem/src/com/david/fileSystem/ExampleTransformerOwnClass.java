package com.david.fileSystem;

public class ExampleTransformerOwnClass implements TextTransformer<Example> {

	public String toWrite(Example e){
		return String.valueOf(e.getValue());
	}

	public Example fromRead(String s){
		return new Example(Integer.parseInt(s));
	}

}