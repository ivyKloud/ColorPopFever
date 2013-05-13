package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.sound.midiPlayer.MidiPlayer;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton letterButton;
	private JButton paintButton;
	private JButton soundButton;

	public MainWindow() {

		this.letterButton = new JButton("Letters");
		this.paintButton = new JButton("Paint");
		this.soundButton = new JButton("Sound");
		

		this.setTitle("Color Pop Fever");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 100);
		this.setLocation(250, 350);
		this.setLayout(new GridLayout());
		

		this.letterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Nice one !\nYou just used a useless button.", "Stop",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		this.paintButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Nice one !\nYou just used a useless button.", "Stop",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		this.soundButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Nice one !\nYou just used a useless button.", "Stop",JOptionPane.ERROR_MESSAGE);
			}
		});

		this.add(this.letterButton);
		this.add(this.paintButton);
		this.add(this.soundButton);
	}
}
