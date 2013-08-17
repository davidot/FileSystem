package com.david.fileSystem.imageFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFileWriter {

	private File file;

	public ImageFileWriter(File f) {
		file = f;
	}

	public void write(BufferedImage img) throws IOException {
		ImageIO.write(img, ".png", file);
	}

}
