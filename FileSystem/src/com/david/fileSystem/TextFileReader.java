package com.david.fileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TextFileReader {

	private File file;
	private boolean fileExist;
	
	public TextFileReader(URL path){
		this(new File(path.getFile()));
	}
	
	public TextFileReader(String path){
		this(new File(path));
	}
	
	public TextFileReader(File f){
		file = f;
		tryFile();
	}
	
	public String getData() throws IOException{
		if(!fileExist) throw new IOException("Missing file or error by david");
		InputStream in = new FileInputStream(file);
		int length = in.available();
		byte[] b = new byte[length];
		if(in.read(b)!=length){
			System.out.println("Did not read everything");
		}
		in.close();
		return new String(b);
	}
	
	public String[] getLines() throws IOException{
		String data = getData();
		data = data.replaceAll(" ", "").replaceAll("\r\n", "\n");
		return data.split("\n");
	}
		
	public void tryFile(){
		fileExist = file.exists();
	}
	
}