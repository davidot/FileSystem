package com.david.fileSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		SaveFile<Example> save = new SaveFile<Example>(f,
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
		
		//Making a list to hold variable to write
		List<Example> toWrite = new ArrayList<Example>();
		//adding values to the list
		toWrite.add(new Example(1));toWrite.add(new Example(2));
		toWrite.add(new Example(3));toWrite.add(new Example(4));
		toWrite.add(new Example(5));toWrite.add(new Example(6));
		toWrite.add(new Example(7));
		//Writing toWrite to disk
		try{
			save.save(toWrite);
		} catch(IOException e) {
			e.printStackTrace();
		}
		//Creating a list to read to
		List<Example> read = new ArrayList<Example>();
		//Save.load returns a list which you can all add with the addAll method
		try{
			read.addAll(save.load());
		} catch(IOException e) {
			e.printStackTrace();
		}
		/*
		 * Save1, Save2, Save3 are the same only thing differs is there
		 * transformer
		 * 
		 * There is also a method with an integrated try and catch just the
		 * method succes behind it and the saveSucces returns true if the
		 * operation was a succes
		 */

	}
	
	
	
	

}