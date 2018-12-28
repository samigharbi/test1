package com.mow_it_now.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sami gharbi (sami.gharbi@gmail.com)
 * 
 *         classe qui représente une pelouse
 */
public class Pelouse {
  private Point limit;

  private List<Tondeuse> tondeuses;

  public Pelouse(Point limit) {
    super();
    this.tondeuses = new ArrayList<>();
    this.limit = limit;
  }

  public void add(Tondeuse tondeuse) {
    this.tondeuses.add(tondeuse);
  }

  public Point getLimit() {
    return limit;
  }

  public void setLimit(Point limit) {
    this.limit = limit;
  }

  public List<Tondeuse> getTondeuses() {
    return new ArrayList<>(tondeuses);
  }

  public void setTondeuses(List<Tondeuse> tondeuses) {
    this.tondeuses = new ArrayList<>(tondeuses);
  }

}
