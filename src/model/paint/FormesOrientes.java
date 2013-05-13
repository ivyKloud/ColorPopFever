package model.paint;

import java.awt.Color;

/**
 *
 */

/**
 * @author maxime.loin
 *
 */
public abstract class FormesOrientes extends Formes{

	/**
	 *
	 */
	protected int angle;


	public FormesOrientes(int x, int y, int taille, Color couleur,String type, int angle) {
		// TODO Auto-generated constructor stub
		super(x,y,taille,couleur,type);
		this.angle = angle;
	}

	/**
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * @param angle the angle to set
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FormesOrientes [ x = " + x + ", y = " + y
				+ ", taille = " + taille + ", couleur = " + couleur + ", type = "
				+ type + ", angle = " + angle + " ]";
	}

}
