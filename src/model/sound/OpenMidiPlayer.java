package model.sound;

import view.sound.MidiPlayerWindow;
import model.sound.midiPlayer.MidiPlayer;

public class OpenMidiPlayer {
	public static void main(String[] args) {
		MidiPlayerWindow w = new MidiPlayerWindow(new MidiPlayer());
	}
}
