package com.david.fileSystem;

import java.io.File;

public class Example {

	private int value = 0;
	
	
	public Example(int x) {
		if(x!=0){
			value = x;
		} else {
			value++;
		}
	}

	public int getValue(){
		return value;
	}
	/*
	 This class is used to preform the operation from and to a string of a object
																\/ is your object*/
	class ExampleTransformerInClass implements TextTransformer<Example> {
	
		public String toWrite(Example e) {
			return String.valueOf(e.getValue());
		}
	
		public Example fromRead(String s) {
			return new Example(Integer.parseInt(s));
		}
	
	}

	/*
		There are multiple ways of making a transformer
		in class, in a separate file as its own class,
		in a a anonymous inner class, etc
	*/
	
	public static void main(String[] args) {
		// if you just do a string it goes from the current
		// directory
		File f = new File("fileExample.txt");
		
		//The in class method
		SaveFile<Example> save1 = new SaveFile<Example>(f,
				new Example(0).new ExampleTransformerInClass());
		
		//The own class method
		SaveFile<Example> save2 = new SaveFile<Example>(f,
				new ExampleTransformerOwnClass());
		
		//The anonymous inner class method
		SaveFile<Example> save3 = new SaveFile<Example>(f,
				new TextTransformer<Example>() {
			public String toWrite(Example e){
				return String.valueOf(e.getValue());
			}
			
			public Example fromRead(String s) {
				return new Example(Integer.parseInt(s));
			}
		});

	}
	
	
	
	

}