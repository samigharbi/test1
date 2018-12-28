package com.mow_it_now.util;

/**
 * 
 * @author sami gharbi (sami.gharbi@gmail.com)
 * 
 *         énumération des orientations (NORTH,SOUTH,EAST,WEST)
 */
public enum Orientation {
  N("N"), S("S"), E("E"), W("W");
  private String strOrientation;

  Orientation(String strOrientation) {
    this.strOrientation = strOrientation;
  }

  public String getOrientation() {
    return this.strOrientation;
  }

}
