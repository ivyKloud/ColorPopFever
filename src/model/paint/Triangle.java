package model.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 */

/**
 * @author maxime.loin
 *
 */
public class Triangle extends Formes{

	/**
	 *
	 */
	public Triangle(int x, int y, int taille, Color couleur) {
		// TODO Auto-generated constructor stub
		super(x,y,taille,couleur,"TRIANGLE");
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		int s1X = this.getX() + this.getTaille() / 2;
        int s1Y = this.getY();
        int s2X = this.getX() + this.getTaille();
        int s2Y = this.getY() + this.getTaille();
        int s3X = this.getX();
        int s3Y = this.getY() + this.getTaille();
        int[] ptsX = {s1X, s2X, s3X};
        int[] ptsY = {s1Y, s2Y, s3Y};
        g.fillPolygon(ptsX, ptsY, 3);
	}

	@Override
	public void perimetre(Graphics g) {
		// TODO Auto-generated method stub
		int s1X = this.getX() + this.getTaille() / 2;
        int s1Y = this.getY();
        int s2X = this.getX() + this.getTaille();
        int s2Y = this.getY() + this.getTaille();
        int s3X = this.getX();
        int s3Y = this.getY() + this.getTaille();
        int[] ptsX = {s1X, s2X, s3X};
        int[] ptsY = {s1Y, s2Y, s3Y};
        g.drawPolygon(ptsX, ptsY, 3);
	}

	@Override
	public boolean estDansPerimetre(int x,int y) {
		// TODO Auto-generated method stub
		boolean dedans = false;
			if(x>=this.getX() && y>=this.getY() && x<=(this.getX()+this.getTaille()) && y<=(this.getY()+this.getTaille())){
				dedans = true;
			}else
				dedans = false;
		return dedans;
	}



}
