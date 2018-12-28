package com.mow_it_now.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.mow_it_now.models.Tondeuse;

/**
 * 
 * @author sami gharbi (sami.gharbi@gmail.com)
 * 
 *         Utilitaire qui parse les lignes et les interprétent
 */
public class LinesUtil {

  public static final int INDICE_X = 0;
  public static final int INDICE_Y = 1;
  public static final int INDICE_ORIENTATION = 2;

  private LinesUtil() {
    super();
  }

  /**
   * reourner le coordonnées haut droite de la pelouse.
   * 
   * @param ligne
   *          ligne de texte
   * @return le Point haut droite (la limite)
   */
  public static Point getLimit(String ligne) {
    String[] t = ligne.split(" ");
    // initialiser la pelouse
    int x = Integer.parseInt(t[0]);
    int y = Integer.parseInt(t[1]);
    return new Point(x, y);
  }

  /**
   * crée une tondeuse à partir des informations texte.
   * 
   * @param ligneTondeuse
   *          la ligne qui contient les informations sur l'état initial de la
   *          tondeuse
   * @param ligneDeplacement
   *          la ligne qui les mouvements à effectuer par la tondeuse
   * @return un objet tondeuse
   */
  public static Tondeuse getTondeuse(String ligneTondeuse,
      String ligneDeplacement) {
    String[] t = ligneTondeuse.split(" ");
    int x = Integer.parseInt(t[INDICE_X]);
    int y = Integer.parseInt(t[INDICE_Y]);
    Orientation orientation = Orientation.valueOf(t[INDICE_ORIENTATION]);
    List<Mouvement> deplacements = getDeplacements(ligneDeplacement);
    return new Tondeuse(new Point(x, y), orientation, deplacements);
  }

  /**
   * interpréte les caractères qui représentent les mouvements
   * 
   * @param ligne
   *          la ligne qui les mouvements à effectuer par la tondeuse
   * @return la liste de mouvements
   */
  public static List<Mouvement> getDeplacements(String ligne) {
    char[] deplacements = ligne.toCharArray();
    List<Mouvement> mouvements = new ArrayList<>();
    for (char d : deplacements) {
      mouvements.add(Mouvement.valueOf(Character.toString(d)));
    }
    return mouvements;
  }
}
