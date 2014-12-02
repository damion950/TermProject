package musicApp;

import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

public class MusicAppDriver
{
	public static void main(String args[]) throws IOException, InterruptedException, MidiUnavailableException
	{
		new Window(950, 450, "Music Window");
	}
}
