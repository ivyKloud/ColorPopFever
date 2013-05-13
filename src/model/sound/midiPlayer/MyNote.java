package model.sound.midiPlayer;

public class MyNote {
	private String note;

	public MyNote(String value) {
		super();
		this.note = value;
	}

	public String getNote() {
		return this.note;
	}
	
	public String toString() {
		return this.getNote();
	}
}
