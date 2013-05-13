package model.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author maxime.loin
 *
 */
public class Rectangle extends FormesOrientes{

	/**
	 *
	 */
	public Rectangle(int x, int y, int taille, Color couleur, int angle) {
		// TODO Auto-generated constructor stub
		super(x,y,taille,couleur,"RECTANGLE",angle);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		switch(this.getAngle()){
		case 0 :
			g.fillRect(this.getX()+(this.getTaille()/4), this.getY(), this.getTaille()/2, this.getTaille());
			break;
		case 90:
			g.fillRect(this.getX(), this.getY()+(this.getTaille()/4), this.getTaille(), this.getTaille()/2);
			break;
		}
	}

	@Override
	public void perimetre(Graphics g) {
		// TODO Auto-generated method stub
		switch(this.getAngle()){
		case 0 :
			g.drawRect(this.getX()+(this.getTaille()/4), this.getY(), this.getTaille()/2, this.getTaille());
			break;
		case 90:
			g.drawRect(this.getX(), this.getY()+(this.getTaille()/4), this.getTaille(), this.getTaille()/2);
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
