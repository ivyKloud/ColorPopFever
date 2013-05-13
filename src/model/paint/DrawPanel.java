package model.paint;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {

    //Couleur du pointeur
    private Color pointerColor = Color.black;
    //Forme du pointeur
    private String pointerType = "CIRCLE";
    //Position X du pointeur
    private int posX = -10, oldX = -10;
    //Position Y du pointeur
    private int posY = -10, oldY = -10;
    //Pour savoir si on doit dessiner ou non
    private boolean erasing = true;
    //Taille du pointeur
    private int pointerSize = 60;
    //Collection de points !
    private ArrayList<Formes> formes = new ArrayList<Formes>();
    //angle
    private int angle = 0;
    private int index;
    private boolean perrimetre;



	public DrawPanel() {

        this.addMouseListener(new MouseAdapter() {

        	public boolean estDansCadre(MouseEvent e){
            	return ((e.getX() - (getPointerSize() / 2))>=10 && (e.getY() - (getPointerSize()/2))>= 10  && (e.getX())<=(1044 - (getPointerSize()/2)) && (e.getY())<=(647 - (getPointerSize()/2)));
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	if(estDansCadre(e)){
            		switch(getIndex()){
            		case 1:
            			formes.add(new Square(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
            			break;
            		case 2:
                		formes.add(new Circle(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
                		break;
            		case 3:
                		formes.add(new Triangle(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
                		break;
            		case 4:
                		formes.add(new SemiCircle(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, angle));
                		break;
            		case 5:
                		formes.add(new Rectangle(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor,angle));
                		break;
            		case 6:
            			for(Formes f : formes){
                        	System.out.println(f.toString());
                        }
            			break;
            		case 7:
            			System.out.println("xsouris : " + (e.getX()) + "\tysouris : " + (e.getY()));
            			gommer(e.getX(), e.getY());
            			break;
                	default:
                		alerte();
                		break;
            		}
            	}
            	System.out.println("nb formes : " + formes.size());
                repaint();
            }
        });

        /* this.addMouseMotionListener(new MouseMotionListener(){
         public void mouseDragged(MouseEvent e) {
         //pour effectuer un tracer en un clique.
         //On récupère les coordonnées de la souris et on enlève la moitié de la taille du pointeur pour centrer le tracé
         points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
         repaint();
         }

         public void mouseMoved(MouseEvent e) {}
         });*/

    }

    // Vous la connaissez maintenant, celle-là
    @Override
    public void paintComponent(Graphics g) {
        couleurFond(g);
        g.fillRect(10, 10, this.getWidth()-60, this.getHeight()-60);
        System.out.println("w : " + this.getWidth() + "\t h : "+ this.getHeight());
        //Si on doit effacer, on ne passe pas dans le else => pas de dessin
        if (this.erasing) {
            this.erasing = false;
        } else {
            //On parcourt notre collection de points
            for (Formes f : this.formes) {

	                //On récupère la couleur
	                g.setColor(f.getCouleur());

	                //on dessine la forme
	                f.paint(g);
	                if(affichePerimetre()){
		                g.setColor(Color.red);
		                f.perimetre(g);
	                }

            }
            //setPerrimetre(false);
        }
    }
    //couleur de fond
    public void couleurFond(Graphics g){
    	g.setColor(this.getBackground());
    }

    public ArrayList<Formes> getFormes(){
    	return this.formes;
    }



    //Efface le contenu
    public void erase() {
        this.erasing = true;
        this.formes = new ArrayList<Formes>();
        repaint();
    }
    public int getPointerSize(){
        return this.pointerSize;
    }

    public void setPointerSize(int pointerSize){
    	this.pointerSize = pointerSize;
    }

    //Définit la couleur du pointeur
    public void setPointerColor(Color c) {
        this.pointerColor = c;
    }

    public Color getPointerColor(){
    	return this.pointerColor;
    }

    //Définit la forme du pointeur
    public void setPointerType(String str) {
        this.pointerType = str;
    }
    public String getPointerType(){
    	return this.pointerType;
    }
        public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
    /**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * @return the perrimetre
	 */
	public boolean isPerrimetre() {
		return perrimetre;
	}

	/**
	 * @param perrimetre the perrimetre to set
	 */
	public void setPerrimetre(boolean perrimetre) {
		this.perrimetre = perrimetre;
	}

	public boolean affichePerimetre(){
		return isPerrimetre();
	}
	public void gommer(int x, int y){
		for(Formes f : formes){
        	System.out.println(f.estDansPerimetre(x, y));
        	if(f.estDansPerimetre(x, y))
        	formes.remove(f);
        	repaint();
        }
	}

	public void alerte(){
		JFrame fen1 = new JFrame();
		fen1.setLocationRelativeTo(null);
		fen1.setSize(200,100);
		JLabel lab1 = new JLabel("Veuillez choisir une forme!!!");
		fen1.add(lab1);
		fen1.setVisible(true);
	}

}