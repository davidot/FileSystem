package com.david.fileSystem.textFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TextFileReader {

	private File file;
	
	public TextFileReader(URL path) {
		this(new File(path.getFile()));
	}
	
	public TextFileReader(String path) {
		this(new File(path));
	}
	
	public TextFileReader(File f) {
		file = f;
	}
	
	public byte[] getData() throws IOException {
		if (!file.exists())
			throw new IOException("Missing file or error by david");
		InputStream in = new FileInputStream(file);
		int length = in.available();
		byte[] b = new byte[length];
		if(in.read(b)!=length){
			System.out.println("Did not read everything");
		}
		in.close();
		return b;
	}
	
	public String getDataString() throws IOException {
		return new String(getData());
	}
	
	public String[] getLines() throws IOException {
		String data = getDataString();
		data = data.replaceAll(" ", "").replaceAll("\r\n", "\n");
		return data.split("\n");
	}

	public boolean getExists() {
		return file.exists();
	}
	
}