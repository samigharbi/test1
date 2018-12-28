package com.mow_it_now.controlers;

import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.mow_it_now.models.Pelouse;
import com.mow_it_now.util.LinesLoader;
import com.mow_it_now.util.LinesUtil;

public class PelouseFactory implements Loader {

  private InputStream inputStream;

  public PelouseFactory(InputStream inputStream) {
    super();
    this.inputStream = inputStream;
  }

  public Pelouse createPelouse() throws IOException {
    LinesLoader loader = new LinesLoader(inputStream);
    List<String> lines = loader.getLines();
    Iterator<String> iterator = lines.iterator();
    Point p = LinesUtil.getLimit(iterator.next());
    Pelouse pelouse = new Pelouse(p);
    while (iterator.hasNext()) {
      String lineTondeuse = iterator.next();
      String lineDeplacements = iterator.next();
      pelouse.add(LinesUtil.getTondeuse(lineTondeuse, lineDeplacements));
    }
    return pelouse;
  }

}
