package com.david.fileSystem;

import java.io.IOException;

public class SaveFile{

	TextFile textFile;
	
		
	public SaveFile(TextFile file){
		textFile = file;
	}
	
	public void save(IWriteable[] data) throws IOException{
		String save = "";
		for(IWriteable w : data){
			save +=w.toWrite();
		}
		textFile.override(save);
	}
	
	public void load(IWriteable[] load, int x) throws IOException {
		String[] lines = textFile.getLines();
		if(lines.length>load.length) return;
		for (int i = 0; i < lines.length; i++) {
			load[i].fromRead(lines[i]);
		}
	}
	
	
	
}
