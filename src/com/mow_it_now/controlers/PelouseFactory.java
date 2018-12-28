package com.mow_it_now.controlers;

import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mow_it_now.models.Pelouse;
import com.mow_it_now.models.Tondeuse;
import com.mow_it_now.util.LinesLoader;
import com.mow_it_now.util.Mouvement;
import com.mow_it_now.util.Orientation;

public class PelouseFactory implements Loader {

  public static final int INDICE_X = 0;
  public static final int INDICE_Y = 1;
  public static final int INDICE_ORIENTATION = 2;

  private InputStream inputStream;

  public PelouseFactory(InputStream inputStream) {
    super();
    this.inputStream = inputStream;
  }


  public Pelouse createPelouse() throws IOException {
    LinesLoader loader = new LinesLoader(inputStream);
    List<String> lines = loader.getLines();
    Iterator<String> iterator = lines.iterator();
    Point p = getLimit(iterator.next());
    Pelouse pelouse = new Pelouse(p);
    while (iterator.hasNext()) {
      String lineTondeuse = iterator.next();
      String lineDeplacements = iterator.next();
      pelouse.add(getTondeuse(lineTondeuse, lineDeplacements));
    }
    return pelouse;
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
