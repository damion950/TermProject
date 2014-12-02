package musicApp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class TestMidi {

	
public TestMidi() throws IOException, InvalidMidiDataException
	{
	
		Sequencer mySequence;
		try {
			mySequence = MidiSystem.getSequencer();
			mySequence.open();
			
				InputStream is;
				try {
						is = new BufferedInputStream(new FileInputStream(new File(TestMidi.class.getResource("/Sound Assets/PianoSound.mid").toURI())));
						mySequence.setSequence(is);
						
						mySequence.start();
					} 
				catch (FileNotFoundException e) 
					{
		
					e.printStackTrace();
					}
			catch (URISyntaxException e) {
		
				e.printStackTrace();
			}
			

		
		} catch (MidiUnavailableException e) {

			e.printStackTrace();
		}
		
		

	}
	
}


