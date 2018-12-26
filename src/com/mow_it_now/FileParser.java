package com.mow_it_now;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Loads File into String lines
 * @author sami
 *
 */
public class FileParser {
	File file;

	public FileParser(File file) {
		super();
		this.file = file;			
	}
	public List<String>getLines() throws  IOException{
		List<String>lines=new ArrayList<>();
		try (BufferedReader b = new BufferedReader(new FileReader(file));) {
			String line;
			while((line=b.readLine())!=null){
				lines.add(line);
			}
		}
		return lines;
	}
}
