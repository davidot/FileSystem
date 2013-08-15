package com.david.fileSystem;

import java.io.IOException;
import java.util.List;

public class SaveFile{

	TextFile textFile;
	
		
	public SaveFile(TextFile file){
		textFile = file;
	}
	
	public void save(List<IWriteable> data) throws IOException{
		String save = "";
		for(IWriteable w : data){
			save +=w.toWrite();
		}
		textFile.override(save);
	}
	
	public void load(List<IWriteable> empty) throws IOException {
		String[] lines = textFile.getLines();
		for (int i = 0; i < (lines.length>empty.size() ? empty.size() : lines.length ); i++) {
			empty.get(i).fromRead(lines[i]);
		}
	}
	
}
