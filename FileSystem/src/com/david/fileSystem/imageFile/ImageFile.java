package com.david.fileSystem.imageFile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {

	private ImageFileReader reader;
	private ImageFileWriter writer;
	
	
	public ImageFile(File file) {
	
	
	}

	public int[] getPixels() throws IOException {
		BufferedImage temp = reader.getBufferedImage();
		int width = temp.getWidth(null);
		int height = temp.getHeight(null);
		int[] data = new int[width * height];
		for(int x = 0; x < width; x++ ){
			for(int y = 0; y < height; y++ ){
				data[x + (y * width)] = temp.getRGB(x,y);
			}
		}
		return data;
	}

	public void override(Image img) throws IOException {
		writer.write(img);
	}

}