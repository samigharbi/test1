package com.mow_it_now;

import java.awt.Point;

public class Tondeuse {
	
private Point position;
private char orientation;
private char[]deplacements;

public Tondeuse(Point position, char orientation, char[] deplacements) {
	super();
	this.position = position;
	this.orientation = orientation;
	this.deplacements = deplacements;
}
public Point getPosition() {
	return position;
}
public void setPosition(Point position) {
	this.position = position;
}
public char getOrientation() {
	return orientation;
}
public void setOrientation(char orientation) {
	this.orientation = orientation;
}

public char[] getDeplacements() {
	return deplacements;
}
public void setDeplacements(char[] deplacements) {
	this.deplacements = deplacements;
}
@Override
public String toString() {
	return position.x+" "+position.y+" "+orientation;
}

}
