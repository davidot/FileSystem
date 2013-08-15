package com.david.fileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TextFileWriter {

	File file;
	private boolean direc;
	private boolean create;
	
	public TextFileWriter(File f, boolean create){
		file = f;
		direc = file.isDirectory();
		this.create = create;
	}
	
	public void write(byte[] b) throws IOException {
		tryFile();
		if(direc) throw new IOException("This is a directory");
		OutputStream out = new FileOutputStream(file);
		out.write(b);
		out.close();
	}
	
	public void write(String s) throws IOException {
		write(s.getBytes());
	}

	public void tryFile() throws IOException {
		if(!file.exists()&&!direc&&create){
			file.createNewFile();
		}
	}

	
}