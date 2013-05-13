package view.sound;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import model.sound.midiPlayer.MidiPlayer;
import model.sound.midiPlayer.MyNote;
import model.sound.midiPlayer.exceptions.NonStartedMusic;
import model.sound.midiPlayer.exceptions.NullSequencerException;
import model.sound.midiPlayer.exceptions.NullSynthesizerException;

import org.jfugue.Player;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MidiPlayer player;
	private JButton startPauseButton;
	private JButton stopButton;
	private JButton transformButton;
	private boolean isOnAir;
	private boolean hasBegun;
	private File f;
	/*****Tests*****/
	private JButton playTransformButton;
	private ArrayList<MyNote> musicNotes;

	public Window(MidiPlayer p) {

		this.player = p;
		this.startPauseButton = new JButton("Start/Pause");
		this.stopButton = new JButton("Stop");
		this.transformButton = new JButton("Transform");
		this.playTransformButton = new JButton("Play Transform File");
		this.isOnAir = false;
		this.hasBegun = false;
		this.f = null;
		
		this.musicNotes = null; 

		this.setTitle("Midi Player");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 100);
		this.setLocation(250, 350);
		this.setLayout(new GridLayout());
		
		this.stopButton.setEnabled(false);
		this.transformButton.setEnabled(false);
		this.playTransformButton.setEnabled(false);

		this.startPauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!isOnAir) {
					if (!hasBegun) {
						JFileChooser fc = new JFileChooser();
						
						//Filter files to accept only .mid extension
						fc.setFileFilter(new FileFilter() {
                            public boolean accept(File file) {
                                if(file.getName().endsWith(".mid")) {
                                    return true;
                                }
                                return false;
                            }

							@Override
							public String getDescription() {
								// TODO Auto-generated method stub
								return "Midi files ; .mid";
							}
                        });
						
						fc.setDialogTitle("Load");
						fc.setApproveButtonText("Load");
						int returnval = fc.showOpenDialog(null);
						if (returnval == JFileChooser.APPROVE_OPTION) {
							Window.this.f = fc.getSelectedFile();
							try {
								Window.this.player.start(Window.this.f);
								Window.this.hasBegun = true;
								Window.this.isOnAir = true;
								Window.this.stopButton.setEnabled(true);
								Window.this.transformButton.setEnabled(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null,"File not found.", "Information",JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						Window.this.player.play();
						Window.this.isOnAir = true;
					}
				} else {
					Window.this.player.pause();
					Window.this.isOnAir = false;
				}
			}
		});
		
		this.stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Window.this.player.stop();
					Window.this.stopButton.setEnabled(false);
					Window.this.transformButton.setEnabled(false);
				} catch (NonStartedMusic nsm) {
					JOptionPane.showMessageDialog(null,"Non started music.", "Information",JOptionPane.INFORMATION_MESSAGE);
				}
				Window.this.hasBegun = false;
				Window.this.isOnAir = false;
			}
		});
		
		this.transformButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Window.this.f != null){
						try {
							Window.this.musicNotes = Window.this.player.transform();
							Window.this.playTransformButton.setEnabled(true);
						} catch (NullSequencerException se) {
							System.out.println("Null Sequencer !");
							JOptionPane.showMessageDialog(null,"No loaded file.", "Information",JOptionPane.INFORMATION_MESSAGE);
						}catch(NullSynthesizerException se){
							System.out.println("Null Synthesizer !");
							JOptionPane.showMessageDialog(null,"No loaded file.", "Information",JOptionPane.INFORMATION_MESSAGE);
						}
				}else{
					JOptionPane.showMessageDialog(null,"No loaded file.", "Information",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		this.playTransformButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Window.this.musicNotes != null){
					String musicString = "";
					Player play = new Player();
					
					for(MyNote note : Window.this.musicNotes){
						musicString += note.getNote()+ " ";
					}
					try {
						Window.this.player.stop();
						Window.this.stopButton.setEnabled(false);
						Window.this.transformButton.setEnabled(false);
					} catch (NonStartedMusic nsm) {
						JOptionPane.showMessageDialog(null,"Non started music.", "Information",JOptionPane.INFORMATION_MESSAGE);
					}
					play.play(musicString);
				}else{
					JOptionPane.showMessageDialog(null,"No transform file.", "Information",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});

		this.add(this.startPauseButton);
		this.add(this.stopButton);
		this.add(this.transformButton);
		this.add(this.playTransformButton);
	}
}
