package com.david.fileSystem.textFile;

public interface TextTransformer<E> {

	public abstract String toWrite(E value);
	
	public abstract E fromRead(String s);
	
}