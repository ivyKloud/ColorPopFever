package model.sound.midiPlayer;

import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

import model.sound.midiPlayer.exceptions.NonStartedMusic;
import model.sound.midiPlayer.exceptions.NullSequencerException;
import model.sound.midiPlayer.exceptions.NullSynthesizerException;

import org.jfugue.Player;



public class MidiPlayer {
	
	private Sequencer sequencer;
	private Synthesizer synthesizer;
	private Player player;
	private String music;
	private File f;
	
	public MidiPlayer(){
		super();
		this.player = new Player();
		this.music = null;
	}
	
	//Load and start the music for the first time
	public void start(File f) throws Exception{
		this.f = f;
		this.sequencer = MidiSystem.getSequencer();
		this.sequencer.open();

		this.synthesizer = MidiSystem.getSynthesizer();
		this.synthesizer.open();

		this.sequencer.setSequence(MidiSystem.getSequence(this.f));
		this.sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());
		this.sequencer.start();
		this.music = this.player.loadMidi(this.f).getMusicString();
	}
	
	//Stop the music
	public void stop() throws NonStartedMusic{
		if (sequencer != null && synthesizer != null){
			sequencer.close();
			synthesizer.close();
		}else {
			throw new NonStartedMusic();
		}
	}
	
	//Pause the music
	public void pause() {
		this.sequencer.stop();
	}
	
	//Start the music, or continue it where it was stopped
	public void play(){
		this.sequencer.start();
	}
	
	//@return a list containing all the notes of the playing song  
	public ArrayList<MyNote> transform() throws NullSequencerException, NullSynthesizerException{
		if (this.sequencer != null && this.synthesizer != null){
			ArrayList<MyNote> notes = new ArrayList<>();
			boolean added;
			String value = null;

			//Running through the String representing the music, if the character is a note or a blank (ABCDEFG or R)
			//A new MyNote is instantiated, containing the value of the read character, plus a # or a b if necessary
			for (int i = 0 ; i < this.music.length() ; i++){
				added = true;
				switch (this.music.charAt(i)){
				case 'A':
					value = "A";
					break;
				case 'B':
					value = "B";
					break;
				case 'C':
					value = "C";
					break;
				case 'D':
					value = "D";
					break;
				case 'E':
					value = "E";
					break;
				case 'F':
					value = "F";
					break;
				case 'G':
					value = "G";
					break;
				case 'R':
					value = "R";
					break;
					default:
						added = false;
				}
				if (added){
					switch (this.music.charAt(i + 1)){
					case '#':
						value += "#";
						break;
					case 'b':
						value += "b";
						break;
					}
					notes.add(new MyNote(value));
				}
			}
			return notes;
		}else{
			if (this.sequencer == null)
				throw new NullSequencerException();
			if (this.synthesizer == null)
				throw new NullSynthesizerException();
			return null;
		}
	}
}
