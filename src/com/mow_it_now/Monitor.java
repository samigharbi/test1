package com.mow_it_now;

/**
 * Perform movements
 * @author sami
 *
 */
public class Monitor {
	Pelouse pelouse;

	public Monitor(Pelouse pelouse) {
		super();
		this.pelouse = pelouse;
	}

	public void deplacer(Tondeuse tondeuse, char direction) {
		switch (direction) {
		case 'A':
			avancer(tondeuse);
			break;
		case 'G':
			tournerGauche(tondeuse);
			break;
		case 'D':
			tournerDroite(tondeuse);
			break;

		default:
			break;
		}
	}

	private void tournerGauche(Tondeuse tondeuse) {
		switch (tondeuse.getOrientation()) {
		case 'E':
			tondeuse.setOrientation('N');
			break;
		case 'N':
			tondeuse.setOrientation('W');
			break;
		case 'W':
			tondeuse.setOrientation('S');
			break;
		case 'S':
			tondeuse.setOrientation('E');
			break;
		default:
			break;
		}
	}

	private void avancer(Tondeuse tondeuse) {
		switch (tondeuse.getOrientation()) {
		case 'E':
			if (tondeuse.getPosition().x < pelouse.getLimit().x) {
				tondeuse.getPosition().x += 1;
			}
			break;
		case 'N':
			if (tondeuse.getPosition().y < pelouse.getLimit().y) {
				tondeuse.getPosition().y += 1;
			}
			break;
		case 'W':
			if (tondeuse.getPosition().x > 0) {
				tondeuse.getPosition().x -= 1;
			}
			break;
		case 'S':
			if (tondeuse.getPosition().y > 0) {
				tondeuse.getPosition().y -= 1;
			}
			break;
		default:
			break;
		}
	}

	private void tournerDroite(Tondeuse tondeuse) {
		switch (tondeuse.getOrientation()) {
		case 'E':
			tondeuse.setOrientation('S');
			break;
		case 'N':
			tondeuse.setOrientation('E');
			break;
		case 'W':
			tondeuse.setOrientation('N');
			break;
		case 'S':
			tondeuse.setOrientation('W');
			break;
		default:
			break;
		}
	}

}
