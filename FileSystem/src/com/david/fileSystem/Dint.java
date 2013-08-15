package com.david.fileSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dint{

	

	private int value;
	
	public Dint(int x) {
		value = x;
		if (value == 0) {
			value++;
		}
	}
	
	public static void main(String[] args){
		DintTransformer transformer = new DintTransformer();
		List<Dint> collection = new ArrayList<Dint>();
		collection.add(new Dint(1));
		collection.add(new Dint(2));
		collection.add(new Dint(3));
		collection.add(new Dint(4));
		collection.add(new Dint(5));
		collection.add(new Dint(6));
		collection.add(new Dint(7));
		prCol(collection.toArray(new Dint[0]));
		SaveFile<Dint> save = new SaveFile<Dint>(new File("test.txt"),
				transformer);
		prCol(collection.toArray(new Dint[0]));
		try {
			save.save(collection);
		} catch (IOException e) {
			System.out.println("Save");
			e.printStackTrace();
		}
		List<Dint> pull = null;
		try {
			pull = save.load();
		} catch (IOException e) {
			System.out.println("Load");
			e.printStackTrace();
		}
		prCol(pull.toArray(new Dint[0]));
	}
	
	public static <E> void prCol(E[] c){
		System.out.print(c.length+" : ");
		for(E a:c ){
			System.out.print(a.toString()+"  ");
		}		
		System.out.println();
	}
	
}
