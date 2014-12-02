package musicApp;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

public class TestMidi
{
	public static void main(String[] args) throws MidiUnavailableException, IOException, InvalidMidiDataException, InterruptedException
	{
		System.out.println(new File(".").getAbsolutePath());
		Sequencer seq = MidiSystem.getSequencer();
		Sequence s;
		Synthesizer synth = MidiSystem.getSynthesizer();
		seq.open();
		synth.open();
		MidiChannel channel = synth.getChannels()[0];
		MidiChannel[] mc = synth.getChannels();
		Transmitter trans = seq.getTransmitter();
		Receiver rcvr = synth.getReceiver();
		
		//InputStream is = new BufferedInputStream(new FileInputStream(new File("C:/Users/Damion/workspace/Term Project/res/Sound Assets/beethoven-fur_elise.mid")));
		s = MidiSystem.getSequence(new File("C:/Users/Damion/workspace/Term Project/res/Sound Assets/beethoven-fur_elise.mid"));
		//InputStream is = new BufferedInputStream(new FileInputStream(TestMidi.class.getResource("")));
		seq.setSequence(s);
		System.out.println("Tracks: " + s.getTracks().length);
		//seq.setTempoFactor((float) 0.5);
		//seq.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println("Test: " + synth.getLoadedInstruments().toString());
		/*
		int count = 0;
		for(Instrument i: synth.getLoadedInstruments())
		{
			System.out.println(count + "Instrument Name: " + i.getName());
			count++;
		}
		*/
		//synth.loadInstrument(synth.getLoadedInstruments()[40]);
		/*
		for(MidiChannel mch: synth.getChannels())
		{
			mch.programChange(0, synth.getLoadedInstruments()[40].getPatch().getProgram());
			//mch.programChange(synth.getLoadedInstruments()[40].getPatch().getProgram());
		}
		*/
		//mc[0].programChange(synth.getLoadedInstruments()[40].getPatch().getProgram());
		
		//Instrument i = synth.getLoadedInstruments()[3];
		//synth.loadInstrument(i);
		
		/*
		Soundbank sb = synth.getDefaultSoundbank();
		Instrument i[] = sb.getInstruments();
		System.out.println(i[1].getName());
		synth.loadAllInstruments(sb);
		//synth.loadInstrument(i[40]);
		int count = 0;
		for(Instrument instr: i)
		{
			System.out.println(count + "Name: " + instr.getName());
			count++;
		}
		
		
		System.out.println("TESTING@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		channel.noteOn(60, 200);
		channel.noteOff(60, 100);
		Thread.sleep(1000);
		System.out.println("Program: " + channel.getProgram());
		channel.programChange(i[40].getPatch().getProgram());
		System.out.println("Program after change: " + channel.getProgram());
		Thread.sleep(1000);
		System.out.println("Testing again");
		channel.noteOn(60, 200);
		//channel.noteOff(60, 100);
		*/
		
		//seq.start();
		
		/*
		Thread.sleep(3000);
		seq.stop();
		Thread.sleep(3000);
		seq.setMicrosecondPosition(0);
		seq.start();
		*/
		
		/*
		Transmitter seqTrans = seq.getTransmitter();
		Receiver synthRcvr = seq.getReceiver();
		
		seqTrans = seq.getTransmitter();
		synthRcvr = synth.getReceiver();
		seqTrans.setReceiver(synthRcvr);
		*/
		
		
		/*Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		MidiChannel channel = synth.getChannels()[0];
		channel.noteOn(60, 200);
		//Thread.sleep(3000);
		channel.noteOff(60, 100);
		*/
	}

}
