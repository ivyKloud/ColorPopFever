package model.paint;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {

	final static int X = 1100;
	final static int Y = 800;

    //LE MENU
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("Fichier"),
            edition = new JMenu("Edition"),
            forme = new JMenu("Forme du pointeur"),
            couleur = new JMenu("Couleur du pointeur");
    private JMenuItem nouveau = new JMenuItem("Effacer"),
            quitter = new JMenuItem("Quitter"),
            rond = new JMenuItem("Rond"),
            triangle = new JMenuItem("Triangle"),
            demi_cercle = new JMenuItem("Demi-Cercle"),
            rectangle = new JMenuItem("Rectangle"),
            carre = new JMenuItem("CarrÃ©");
    /*     bleu = new JMenuItem("Bleu"),
     rouge = new JMenuItem("Rouge"),
     vert = new JMenuItem("Vert"),
     blanc = new JMenuItem("Blanc")*/
    //LA BARRE D'OUTILS
    private JToolBar toolBar = new JToolBar();
    private JToolBar toolBar1 = new JToolBar();
    private JButton square = new JButton("CA"),
            circle = new JButton("RO"),
            triangle1 = new JButton("TR"),
            semicircle = new JButton("DC"),
            rectangle1 = new JButton("RE"),
            rouge1 = new JButton(),
            rouge2 = new JButton(),
            vert1 = new JButton(),
            vert2 = new JButton(),
            bleu1 = new JButton(),
            bleu2 = new JButton(),
            rose1 = new JButton(),
            rose2 = new JButton(),
            violet1 = new JButton(),
            violet2 = new JButton(),
            lavande1 = new JButton(),
            lavande2 = new JButton(),
            orange1 = new JButton(),
            orange2 = new JButton(),
            jaune1 = new JButton(),
            jaune2 = new JButton(),
            jaune_vert1 = new JButton(),
            jaune_vert2 = new JButton(),
            vert_bleu1 = new JButton(),
            vert_bleu2 = new JButton(),
            bleu_vert1 = new JButton(),
            bleu_vert2 = new JButton(),
            bleuf1 = new JButton(),
            bleuf2 = new JButton(),
            blanc = new JButton(),
            noir = new JButton(),
            taille1 = new JButton("P"),
            taille2 = new JButton("M"),
            taille3 = new JButton("G"),
            taille4 = new JButton("E"),
            font = new JButton("F"),
            angle1 = new JButton("0°"),
            angle2 = new JButton("90°"),
            angle3 = new JButton("180°"),
            angle4 = new JButton("270°"),
    		perimetre = new JButton("Perimetre"),
		    gomme = new JButton("Gomme");
    //LES Ã‰COUTEURS
    private FormeListener fListener = new FormeListener();
    private CouleurListener cListener = new CouleurListener();
    private SizePointerListener spListener = new SizePointerListener();
    private FontListener fontListener = new FontListener();
    private AngleListener aListener = new AngleListener();
    private PerimetreListener pListener = new PerimetreListener();
    private GommeListener gListener = new GommeListener();

    //Notre zone de dessin
    private DrawPanel drawPanel = new DrawPanel();



    public Fenetre() {
        this.setSize(X, Y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //On initialise le menu
        this.initMenu();

        //Idem pour la barre d'outils
        this.initToolBar();

        //Couleur des boutons
        this.couleurBouton();

        //On positionne notre zone de dessin
        this.drawPanel.setBackground(Color.white);
        this.getContentPane().add(drawPanel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);




    }

    public void couleurBouton(){

    	rose1.setBackground(new Color(255, 145, 153));
        rose2.setBackground(new Color(221, 0, 17));
        rouge1.setBackground(new Color(255, 112, 91));
        rouge2.setBackground(new Color(217, 28, 0));
        orange1.setBackground(new Color(255, 190, 119));
        orange2.setBackground(new Color(249, 131, 0));
        jaune1.setBackground(new Color(255, 252, 106));
        jaune2.setBackground(new Color(251, 244, 0));
        jaune_vert1.setBackground(new Color(206, 255, 60));
        jaune_vert2.setBackground(new Color(131, 174, 0));
        vert1.setBackground(new Color(121, 255, 106));
        vert2.setBackground(new Color(11, 102, 0));
        vert_bleu1.setBackground(new Color(106, 255, 151));
        vert_bleu2.setBackground(new Color(0, 130, 39));
        bleu_vert1.setBackground(new Color(106, 255, 255));
        bleu_vert2.setBackground(new Color(0, 102, 102));
        bleuf1.setBackground(new Color(94, 174, 255));
        bleuf2.setBackground(new Color(0, 63, 125));
        bleu1.setBackground(new Color(143, 106, 255));
        bleu2.setBackground(new Color(26, 0, 102));
        lavande1.setBackground(new Color(255, 130, 255));
        lavande2.setBackground(new Color(102, 0, 102));
        violet1.setBackground(new Color(155, 162, 210));
        violet2.setBackground(new Color(170, 0, 89));
        blanc.setBackground(Color.white);
        noir.setBackground(Color.black);
    }

    //Initialise le menu
    private void initMenu() {
        nouveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                drawPanel.erase();
            }
        });

        nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));

        fichier.add(nouveau);
        fichier.addSeparator();
        fichier.add(quitter);
        fichier.setMnemonic('F');

        carre.addActionListener(fListener);
        rond.addActionListener(fListener);
        triangle.addActionListener(fListener);
        demi_cercle.addActionListener(fListener);
        rectangle.addActionListener(fListener);
        forme.add(rond);
        forme.add(carre);
        forme.add(triangle);
        forme.add(demi_cercle);
        forme.add(rectangle);


        edition.setMnemonic('E');
        edition.add(forme);
        edition.addSeparator();
        edition.add(couleur);

        menuBar.add(fichier);
        menuBar.add(edition);

        this.setJMenuBar(menuBar);
    }

    //Initialise la barre d'outils
    @SuppressWarnings("empty-statement")
    private void initToolBar() {

        JPanel panneau = new JPanel();
        square.addActionListener(fListener);
        circle.addActionListener(fListener);
        triangle1.addActionListener(fListener);
        semicircle.addActionListener(fListener);
        rectangle1.addActionListener(fListener);
        rose1.addActionListener(cListener);
        rose2.addActionListener(cListener);
        rouge1.addActionListener(cListener);
        rouge2.addActionListener(cListener);
        orange1.addActionListener(cListener);
        orange2.addActionListener(cListener);
        jaune1.addActionListener(cListener);
        jaune2.addActionListener(cListener);
        jaune_vert1.addActionListener(cListener);
        jaune_vert2.addActionListener(cListener);
        vert1.addActionListener(cListener);
        vert2.addActionListener(cListener);
        vert_bleu1.addActionListener(cListener);
        vert_bleu2.addActionListener(cListener);
        bleu_vert1.addActionListener(cListener);
        bleu_vert2.addActionListener(cListener);
        bleuf1.addActionListener(cListener);
        bleuf2.addActionListener(cListener);
        bleu1.addActionListener(cListener);
        bleu2.addActionListener(cListener);
        lavande1.addActionListener(cListener);
        lavande2.addActionListener(cListener);
        violet1.addActionListener(cListener);
        violet2.addActionListener(cListener);
        blanc.addActionListener(cListener);
        noir.addActionListener(cListener);
        taille1.addActionListener(spListener);
        taille2.addActionListener(spListener);
        taille3.addActionListener(spListener);
        taille4.addActionListener(spListener);
        font.addActionListener(fontListener);
        angle1.addActionListener(aListener);
        angle2.addActionListener(aListener);
        angle3.addActionListener(aListener);
        angle4.addActionListener(aListener);
        perimetre.addActionListener(pListener);
        gomme.addActionListener(gListener);

        toolBar1.add(square);
        toolBar1.add(circle);
        toolBar1.add(triangle1);
        toolBar1.add(semicircle);
        toolBar1.add(rectangle1);
        toolBar1.addSeparator();
        toolBar1.add(taille1);
        toolBar1.add(taille2);
        toolBar1.add(taille3);
        toolBar1.add(taille4);
        toolBar1.addSeparator();
        toolBar1.add(font);
        toolBar1.addSeparator();
        toolBar1.add(angle1);
        toolBar1.add(angle2);
        toolBar1.add(angle3);
        toolBar1.add(angle4);
        toolBar1.addSeparator();
        toolBar1.add(perimetre);
        toolBar1.addSeparator();
        toolBar1.add(gomme);

        toolBar.add(rose1);
        toolBar.add(rouge1);
        toolBar.add(orange1);
        toolBar.add(jaune1);
        toolBar.add(jaune_vert1);
        toolBar.add(vert1);
        toolBar.add(vert_bleu1);
        toolBar.add(bleu_vert1);
        toolBar.add(bleuf1);
        toolBar.add(bleu1);
        toolBar.add(lavande1);
        toolBar.add(violet1);
        toolBar.add(blanc);

        toolBar.add(noir);
        toolBar.add(violet2);
        toolBar.add(lavande2);
        toolBar.add(bleu2);
        toolBar.add(bleuf2);
        toolBar.add(bleu_vert2);
        toolBar.add(vert2);
        toolBar.add(vert_bleu2);
        toolBar.add(jaune_vert2);
        toolBar.add(jaune2);
        toolBar.add(orange2);
        toolBar.add(rouge2);
        toolBar.add(rose2);



        this.getContentPane().add(toolBar1, BorderLayout.NORTH);
        this.getContentPane().add(toolBar, BorderLayout.SOUTH);

    }

    class GommeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==gomme){
				drawPanel.setIndex(7);
				drawPanel.repaint();
			}
		}

    }

    class PerimetreListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==perimetre){
    			drawPanel.setIndex(6);
    			drawPanel.setPerrimetre(true);
    			drawPanel.repaint();
    		}
    	}
    }

    class AngleListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == angle2){
                drawPanel.setAngle(90);
            }else if(e.getSource()==angle3){
                drawPanel.setAngle(180);
            }else if(e.getSource()==angle4){
                drawPanel.setAngle(270);
            }else
                drawPanel.setAngle(0);
        }
    }

    class FontListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()== font){
                    drawPanel.setBackground(drawPanel.getPointerColor());
    		}
    	}
    }

    class SizePointerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == taille2){
				drawPanel.setPointerSize(120);
			}else if(e.getSource() == taille3){
				drawPanel.setPointerSize(180);
			}else if(e.getSource() == taille4){
				drawPanel.setPointerSize(240);
			}else{
				drawPanel.setPointerSize(60);
			}

		}
    }

    //Ã‰COUTEUR POUR LE CHANGEMENT DE FORME
    class FormeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	drawPanel.setPerrimetre(false);
        	if (e.getSource() == square) {
            	drawPanel.setIndex(1);
            	boutonAngleInvisible();
                drawPanel.setPointerType("SQUARE");
            } else if (e.getSource() == circle) {
            	drawPanel.setIndex(2);
            	boutonAngleInvisible();
                drawPanel.setPointerType("CIRCLE");
            } else if (e.getSource() == triangle1) {
            	drawPanel.setIndex(3);
            	boutonAngleInvisible();
                drawPanel.setPointerType("TRIANGLE");
            } else if (e.getSource() == semicircle) {
            	drawPanel.setIndex(4);
            	drawPanel.setAngle(0);
            	boutonAngleVisible();
                drawPanel.setPointerType("SEMICIRCLE");
            } else {
            	drawPanel.setIndex(5);
            	drawPanel.setAngle(0);
            	angle1.setEnabled(true);
            	angle2.setEnabled(true);
            	angle3.setEnabled(false);
            	angle4.setEnabled(false);
                drawPanel.setPointerType("RECTANGLE");
            }
        }
    }

    //Ã‰COUTEUR POUR LE CHANGEMENT DE COULEUR
    class CouleurListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == rose1) {
                drawPanel.setPointerColor(new Color(255, 145, 153));
            } else if (e.getSource() == rose2) {
                drawPanel.setPointerColor(new Color(221, 0, 17));
            } else if (e.getSource() == rouge1) {
                drawPanel.setPointerColor(new Color(255, 112, 91));
            } else if (e.getSource() == rouge2) {
                drawPanel.setPointerColor(new Color(217, 28, 0));
            } else if (e.getSource() == orange1) {
                drawPanel.setPointerColor(new Color(255, 190, 119));
            } else if (e.getSource() == orange2) {
                drawPanel.setPointerColor(new Color(249, 131, 0));
            } else if (e.getSource() == jaune1) {
                drawPanel.setPointerColor(new Color(255, 252, 106));
            } else if (e.getSource() == jaune2) {
                drawPanel.setPointerColor(new Color(251, 244, 0));
            } else if (e.getSource() == jaune_vert1) {
                drawPanel.setPointerColor(new Color(206, 255, 60));
            } else if (e.getSource() == jaune_vert2) {
                drawPanel.setPointerColor(new Color(131, 174, 0));
            } else if (e.getSource() == vert1) {
                drawPanel.setPointerColor(new Color(121, 255, 106));
            } else if (e.getSource() == vert2) {
                drawPanel.setPointerColor(new Color(11, 102, 0));
            } else if (e.getSource() == vert_bleu1) {
                drawPanel.setPointerColor(new Color(106, 255, 151));
            } else if (e.getSource() == vert_bleu2) {
                drawPanel.setPointerColor(new Color(0, 130, 39));
            } else if (e.getSource() == bleu_vert1) {
                drawPanel.setPointerColor(new Color(106, 255, 255));
            } else if (e.getSource() == bleu_vert2) {
                drawPanel.setPointerColor(new Color(0, 102, 102));
            } else if (e.getSource() == bleuf1) {
                drawPanel.setPointerColor(new Color(94, 174, 255));
            } else if (e.getSource() == bleuf2) {
                drawPanel.setPointerColor(new Color(0, 63, 125));
            } else if (e.getSource() == bleu1) {
                drawPanel.setPointerColor(new Color(143, 106, 255));
            } else if (e.getSource() == bleu2) {
                drawPanel.setPointerColor(new Color(26, 0, 102));
            } else if (e.getSource() == lavande1) {
                drawPanel.setPointerColor(new Color(255, 130, 255));
            } else if (e.getSource() == lavande2) {
                drawPanel.setPointerColor(new Color(102, 0, 102));
            } else if (e.getSource() == violet1) {
                drawPanel.setPointerColor(new Color(155, 162, 210));
            } else if (e.getSource() == violet2) {
                drawPanel.setPointerColor(new Color(170, 0, 89));
            } else if (e.getSource() == blanc) {
                drawPanel.setPointerColor(Color.white);
            } else {
                drawPanel.setPointerColor(Color.black);
            }
            // }
        }
    }


    public void boutonAngleInvisible(){
    	angle1.setEnabled(false);
    	angle2.setEnabled(false);
    	angle3.setEnabled(false);
    	angle4.setEnabled(false);
    }
    public void boutonAngleVisible(){
    	angle1.setEnabled(true);
    	angle2.setEnabled(true);
    	angle3.setEnabled(true);
    	angle4.setEnabled(true);
    }

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
    }
}