package com.mow_it_now.util;

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
