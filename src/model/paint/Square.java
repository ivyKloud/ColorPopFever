package model.paint;

import java.awt.Color;
import java.awt.Graphics;


/**
 * @author maxime.loin
 *
 */
public class Square extends Formes{

	/**
	 *
	 */
	public Square(int x,int y, int taille, Color couleur) {
		// TODO Auto-generated constructor stub
		super(x,y,taille,couleur,"SQUARE");
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(this.getX(), this.getY(), this.getTaille(), this.getTaille());
	}

	@Override
	public void perimetre(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(this.getX(), this.getY(), this.getTaille(), this.getTaille());
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
