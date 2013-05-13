package model.sound;

import view.sound.Window;
import model.sound.midiPlayer.MidiPlayer;

public class Main {
	public static void main(String[] args) {
		Window w = new Window(new MidiPlayer());
	}
}
