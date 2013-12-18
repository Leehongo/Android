package com.game.bugattong.settings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
	

	private BufferedReader reader;
	private BufferedWriter writer;
	private File filePath;
	
	
	public FileGenerator() {
	}

	public String readFile(String path) {
		filePath = new File(path);
		String line = "";

		try {
			reader = new BufferedReader(new FileReader(filePath));
			line = reader.readLine();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return line;

	}

	public void writeFile(String path, String text) {
		
		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(text);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeFile(String path) {
		filePath = new File(path);
		filePath.delete();
		
	}

}
