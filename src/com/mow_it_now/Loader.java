package com.mow_it_now;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Loader {
	private File file;
	private List<String>lines;
	private Pelouse pelouse;
	private Iterator<String>iterator;

	public Loader(File file) throws IOException {
		super();
		this.file = file;	
		FileParser fileParser=new FileParser(file);
		lines=fileParser.getLines();
		iterator=lines.iterator();
		Point p=getLimit(iterator.next());
		pelouse=new Pelouse(p);		
		while(iterator.hasNext()){
			String lineTondeuse=iterator.next();
			String lineDeplacements=iterator.next();
			pelouse.add(getTondeuse(lineTondeuse,lineDeplacements));
		}
	}
	public void deplacer()  {
		Monitor monitor=new Monitor(pelouse);
		for(Tondeuse tondeuse:this.pelouse.getTondeuses()){
			for(char d:tondeuse.getDeplacements()){
				monitor.deplacer(tondeuse, d);
			}
		}
	}

	private Point getLimit(String ligne) {
		String[] t = ligne.split(" ");
		// initialiser la pelouse
		int x = Integer.parseInt(t[0]);
		int y = Integer.parseInt(t[1]);
		return new Point(x, y);
	}

	private Tondeuse getTondeuse(String ligneTondeuse,String ligneDeplacement) {
		String[] t = ligneTondeuse.split(" ");
		int x = Integer.parseInt(t[0]);
		int y = Integer.parseInt(t[1]);
		char orientation = t[2].charAt(0);
		char[]deplacements=getDeplacements(ligneDeplacement);
		return new Tondeuse(new Point(x, y), orientation,deplacements);
	}

	private char[] getDeplacements(String ligne) {
		return ligne.toCharArray();
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Pelouse getPelouse() {
		return pelouse;
	}
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}

	
}
