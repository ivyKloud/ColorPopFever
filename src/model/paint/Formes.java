package model.paint;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Formes {

	protected int x, y = -10;
	protected int taille = 10;
	protected Color couleur = Color.black;
	protected String type;
	protected int index;


	public Formes(int x, int y, int taille, Color couleur, String type) {
		this.x = x;
		this.y = y;
		this.taille = taille;
		this.couleur = couleur;
		this.type = type;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Formes [ x = " + x + ", y = " + y + ", taille = " + taille
				+ ", couleur = " + couleur + ", type = " + type + " ]";
	}
	public abstract void paint(Graphics g);
	public abstract void perimetre(Graphics g);
	public abstract boolean estDansPerimetre(int x, int y);



}
