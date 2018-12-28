package com.mow_it_now.controlers;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mow_it_now.models.Pelouse;
import com.mow_it_now.models.Tondeuse;
import com.mow_it_now.util.FileParser;
import com.mow_it_now.util.Mouvement;
import com.mow_it_now.util.Orientation;

public class Loader {

  public static final int INDICE_X = 0;
  public static final int INDICE_Y = 1;
  public static final int INDICE_ORIENTATION = 2;

  private File file;
  private List<String> lines;
  private Pelouse pelouse;
  private Iterator<String> iterator;

  public Loader(File file) throws IOException {
    super();
    this.file = file;
    FileParser fileParser = new FileParser(file);
    lines = fileParser.getLines();
    iterator = lines.iterator();
    Point p = getLimit(iterator.next());
    pelouse = new Pelouse(p);
    while (iterator.hasNext()) {
      String lineTondeuse = iterator.next();
      String lineDeplacements = iterator.next();
      pelouse.add(getTondeuse(lineTondeuse, lineDeplacements));
    }
  }

  public void deplacer() {
    Monitor monitor = new Monitor(pelouse);
    for (Tondeuse tondeuse : this.pelouse.getTondeuses()) {
      for (Mouvement d : tondeuse.getMouvements()) {
	monitor.deplacer(tondeuse, d);
      }
    }
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

  private static Point getLimit(String ligne) {
    String[] t = ligne.split(" ");
    // initialiser la pelouse
    int x = Integer.parseInt(t[0]);
    int y = Integer.parseInt(t[1]);
    return new Point(x, y);
  }

  private static Tondeuse getTondeuse(String ligneTondeuse,
      String ligneDeplacement) {
    String[] t = ligneTondeuse.split(" ");
    int x = Integer.parseInt(t[INDICE_X]);
    int y = Integer.parseInt(t[INDICE_Y]);
    Orientation orientation = Orientation.valueOf(t[INDICE_ORIENTATION]);
    List<Mouvement> deplacements = getDeplacements(ligneDeplacement);
    return new Tondeuse(new Point(x, y), orientation, deplacements);
  }

  private static List<Mouvement> getDeplacements(String ligne) {
    char[] deplacements = ligne.toCharArray();
    List<Mouvement> mouvements = new ArrayList<>();
    for (char d : deplacements) {
      mouvements.add(Mouvement.valueOf(Character.toString(d)));
    }
    return mouvements;
  }
}
