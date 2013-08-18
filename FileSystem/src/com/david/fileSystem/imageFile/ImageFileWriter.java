package com.david.fileSystem.imageFile;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFileWriter {

	private File file;

	public ImageFileWriter(File f) {
		file = f;
	}

	public void write(Image img) throws IOException {
		ImageIO.write((RenderedImage) img, ".png", file);
	}

}
