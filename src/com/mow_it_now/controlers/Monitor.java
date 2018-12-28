package com.mow_it_now.controlers;

import com.mow_it_now.models.Pelouse;
import com.mow_it_now.models.Tondeuse;
import com.mow_it_now.util.Mouvement;
import com.mow_it_now.util.Orientation;

/**
 * classe qui gère les déplacements
 * 
 * @author sami
 * 
 */
public class Monitor {
  private Pelouse pelouse;

  public Monitor(Pelouse pelouse) {
    super();
    this.pelouse = pelouse;
  }

  public void deplacer() {
    for (Tondeuse tondeuse : this.pelouse.getTondeuses()) {
      for (Mouvement d : tondeuse.getMouvements()) {
	this.deplacer(tondeuse, d);
      }
    }
  }
  /**
   * 
   * @param tondeuse
   *          la tondeuse à déplacer
   * @param mouvement
   *          le mouvement à effectuer(avant, droite, gauche)
   */
  public void deplacer(Tondeuse tondeuse, Mouvement mouvement) {
    switch (mouvement.getMouvement()) {
      case "A":
	avancer(tondeuse);
	break;
      case "G":
	tournerGauche(tondeuse);
	break;
      case "D":
	tournerDroite(tondeuse);
	break;

      default:
	break;
    }
  }

  /**
   * tourner la tondeuse à gauche
   * 
   * @param tondeuse
   *          la tondeuse à tourner vers la gauche
   */
  private static void tournerGauche(Tondeuse tondeuse) {
    Orientation orientation = tondeuse.getOrientation();
    switch (orientation.getOrientation()) {
      case "N":
	tondeuse.setOrientation(Orientation.W);
	break;
      case "S":
	tondeuse.setOrientation(Orientation.E);
	break;
      case "E":
	tondeuse.setOrientation(Orientation.N);
	break;
      case "W":
	tondeuse.setOrientation(Orientation.S);
	break;

      default:
	break;
    }
  }

  /**
   * avancer la tondeuse
   * 
   * @param tondeuse
   *          la tondeuse à faire avancer.
   */
  private void avancer(Tondeuse tondeuse) {
    Orientation orientation = tondeuse.getOrientation();
    switch (orientation.getOrientation()) {

      case "N":
	if (tondeuse.getPosition().y < pelouse.getLimit().y) {
	  tondeuse.getPosition().y += 1;
	}
	break;
      case "S":
	if (tondeuse.getPosition().y > 0) {
	  tondeuse.getPosition().y -= 1;
	}
	break;
      case "E":
	if (tondeuse.getPosition().x < pelouse.getLimit().x) {
	  tondeuse.getPosition().x += 1;
	}
	break;
      case "W":
	if (tondeuse.getPosition().x > 0) {
	  tondeuse.getPosition().x -= 1;
	}
	break;

      default:
	break;
    }
  }

  /**
   * tourner la tondeuse à droite
   * 
   * @param tondeuse
   *          la tondeuse à tourner à droite
   */
  private static void tournerDroite(Tondeuse tondeuse) {
    Orientation orientation = tondeuse.getOrientation();
    switch (orientation.getOrientation()) {
      case "N":
	tondeuse.setOrientation(Orientation.E);
	break;
      case "S":
	tondeuse.setOrientation(Orientation.W);
	break;
      case "E":
	tondeuse.setOrientation(Orientation.S);
	break;

      case "W":
	tondeuse.setOrientation(Orientation.N);
	break;

      default:
	break;
    }
  }

  public Pelouse getPelouse() {
    return pelouse;
  }

  public void setPelouse(Pelouse pelouse) {
    this.pelouse = pelouse;
  }

}
