package com.david.fileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TextFileWriter {

	File file;
	private boolean direc;
	
	public TextFileWriter(File f){
		file = f;
		direc = file.isDirectory();
	}
	
	public void write(byte[] b) throws IOException{
		tryFile();
		if(direc) throw new IOException("This is a directory");
		OutputStream out = new FileOutputStream(file);
		out.write(b);
		out.close();
	}
	
	public void tryFile() throws IOException {
		if(!file.exists()&&!direc){
			file.createNewFile();
		}
	}

	public void write(String s) throws IOException{
		write(s.getBytes());
	}
	
}