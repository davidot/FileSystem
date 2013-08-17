package com.david.fileSystem.imageFile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFileReader {

	private File file;

	public ImageFileReader(File f) {
		file = f;
	}

	public Image getImage() throws IOException {
		return ImageIO.read(file);
	}

	public BufferedImage getBufferedImage() throws IOException {
		return (BufferedImage) getImage();
	}

}