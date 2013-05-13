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
public class SemiCircle extends FormesOrientes{

	/**
	 *
	 */
	public SemiCircle(int x, int y, int taille, Color couleur, int angle) {
		// TODO Auto-generated constructor stub
		super(x,y,taille,couleur,"SEMICIRCLE",angle);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		switch(this.getAngle()){
		case 0:
			g.fillArc(this.getX(), this.getY()+(this.getTaille()/4), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		case 90:
			g.fillArc(this.getX()+(this.getTaille()/4), this.getY(), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		case 180:
			g.fillArc(this.getX(), this.getY()-(this.getTaille()/4), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		case 270:
			g.fillArc(this.getX()-(this.getTaille()/4), this.getY(), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		}
	}

	@Override
	public void perimetre(Graphics g) {
		// TODO Auto-generated method stub
		switch(this.getAngle()){
		case 0:
			g.drawArc(this.getX(), this.getY()+(this.getTaille()/4), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		case 90:
			g.drawArc(this.getX()+(this.getTaille()/4), this.getY(), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		case 180:
			g.drawArc(this.getX(), this.getY()-(this.getTaille()/4), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		case 270:
			g.drawArc(this.getX()-(this.getTaille()/4), this.getY(), this.getTaille(), this.getTaille(), this.getAngle(), 180);
			break;
		}
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
