package com.mow_it_now.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.mow_it_now.util.Mouvement;
import com.mow_it_now.util.Orientation;

/**
 * 
 * @author sami gharbi (sami.gharbi@gmail.com)
 * 
 *         classse qui représente une tondeuse
 * 
 */
public class Tondeuse {

  private Point position;
  private Orientation orientation;
  private List<Mouvement> mouvements;

  public Tondeuse(Point position, Orientation orientation,
      List<Mouvement> mouvements) {
    super();
    this.position = position;
    this.orientation = orientation;
    this.mouvements = new ArrayList<>(mouvements);
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  public List<Mouvement> getMouvements() {
    return new ArrayList<>(mouvements);
  }

  public void setMouvements(List<Mouvement> mouvements) {
    this.mouvements = new ArrayList<>(mouvements);
  }

  @Override
  public String toString() {
    return position.x + " " + position.y + " " + orientation;
  }

}
