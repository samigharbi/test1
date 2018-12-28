package com.mow_it_now.util;

public enum Mouvement {
  A("A"), D("D"), G("G");
  private String strMouvement;

  public String getMouvement() {
    return this.strMouvement;
  }

  Mouvement(String strMouvement) {
    this.strMouvement = strMouvement;
  }
}
