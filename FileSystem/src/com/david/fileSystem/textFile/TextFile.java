package com.david.fileSystem.textFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TextFile {

	File file;
	private TextFileWriter writer;
	private TextFileReader reader;
	private byte[] initData;
	
	public TextFile(String s) {
		this(new File(s),true);
	}
	
	public TextFile(URL s) {
		this(new File(s.getFile()),true);
	}
	
	public TextFile(String s, boolean c) {
		this(new File(s),c);
	}
	
	public TextFile(URL s,boolean c) {
		this(new File(s.getFile()),c);
	}
	
	public TextFile(File f){
		this(f,true);
	}
	
	
	public TextFile(File f, boolean cr) {
		file = f;
		writer = new TextFileWriter(file,cr);
		reader = new TextFileReader(file);
	}
	
	private void getBytes() throws IOException {
		initData = reader.getData();
	}
	
	public void addWrite(byte[] newData) throws IOException {
		getBytes();
		int totalL = newData.length+initData.length;
		byte[] b = new byte[totalL];
		for (int i = 0; i < initData.length; i++) {
			b[i] = initData[i];
		}
		for (int i = initData.length; i < totalL; i++) {
			b[i] = newData[i];
		}
		writer.write(b);
	}

	public void addWrite(String s) throws IOException {
		addWrite(s.getBytes());		
	}
	
	public void override(byte[] b) throws IOException {
		writer.write(b);
	}
	
	public void override(String s) throws IOException {
		writer.write(s);
	}
	
	public byte[] readData() throws IOException {
		return reader.getData();
	}
	
	public String readText() throws IOException {
		return reader.getDataString();
	}
	
	public String[] readLines() throws IOException {
		return reader.getLines();
	}
	
	public String getLine(int x) throws IOException {
		return reader.getLines()[x-1];
	}
		
	/**
	 * @return the writer
	 */
	public TextFileWriter getWriter() {
		return writer;
	}

	/**
	 * @return the reader
	 */
	public TextFileReader getReader() {
		return reader;
	}

	public boolean getExists() {
		return reader.getExists();
	}
	
}