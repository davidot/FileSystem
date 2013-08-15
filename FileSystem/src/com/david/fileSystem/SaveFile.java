package com.david.fileSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveFile<E>{

	TextFile textFile;
	TextTransformer<E> transformer;
	
	public SaveFile(File f, TextTransformer<E> transformer) {
		this(new TextFile(f));
		this.transformer = transformer;
	}
	
		
	public SaveFile(TextFile file) {
		textFile = file;
	}
	
	public void save(List<E> data) throws IOException {
		String save = "";
		for(E w : data){
			save += transformer.toWrite(w) + "\n";
		}
		textFile.override(save);
	}
	
	public List<E> load() throws IOException {
		System.out.println(textFile.readText());
		String[] lines = textFile.getLines();
		System.out.println(lines.length);
		List<E> data = new ArrayList<E>();
		for (int i = 0; i < lines.length; i++) {
			data.add(transformer.fromRead(lines[i]));
			System.out.println(lines[i]);
		}
		return data;
	}
	
	
}
