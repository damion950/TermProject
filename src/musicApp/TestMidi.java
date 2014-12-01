package musicApp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

public class TestMidi
{
	public static void main(String[] args) throws MidiUnavailableException, IOException, InvalidMidiDataException, InterruptedException
	{
		System.out.println(new File(".").getAbsolutePath());
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		InputStream is = new BufferedInputStream(new FileInputStream(new File("C:/Users/Damion/workspace/Term Project/res/Sound Assets/beethoven-fur_elise.mid")));
		//InputStream is = new BufferedInputStream(new FileInputStream(TestMidi.class.getResource("")));
		sequencer.setSequence(is);
		/*
		sequencer.start();
		Thread.sleep(3000);
		sequencer.stop();
		Thread.sleep(3000);
		sequencer.setMicrosecondPosition(0);
		sequencer.start();
		*/
		
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		MidiChannel channel = synth.getChannels()[0];
		channel.noteOn(60, 200);
		//Thread.sleep(3000);
		channel.noteOff(60, 100);
	}

}
