package backUpStuff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackUpDirectory {

	private File dirFrom;
	private File dirTo;
	
	public BackUpDirectory(File dirFrom, File dirTo) {
		this.dirFrom = dirFrom;
		this.dirTo = dirTo;
		if(!this.dirFrom.isDirectory()) {
			if(!this.dirTo.isDirectory())
				throw new IllegalArgumentException("Must both be a directory");
		}
	}

	public boolean backup() {
		if(!dirTo.exists()) {
			if(!dirTo.mkdir())
				return false;
		}
		File[] files = dirFrom.listFiles();
		for(File f : files) {
			try {
				Files.copy(f.toPath(), new File(dirTo, f.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
		
	}
	
}
