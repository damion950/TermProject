package musicApp;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

public class KeyBoardPanel extends InstrumentPanel implements KeyListener
{
	private static BufferedImage KEY_LEFT_IMAGE;
	private static BufferedImage KEY_CENTER_IMAGE;
	private static BufferedImage KEY_RIGHT_IMAGE;
	private static BufferedImage KEY_BLACK_IMAGE;
	private static int volume = 30;
	private static float tempo = (float) 1.0;
	private static Synthesizer synth;
	private static MidiChannel channel;
	//True if the synthesizer is playing a song
	private static boolean playingFlag = false;
	
	private static KeyBoardPanel instance = new KeyBoardPanel();
	
	private KeyBoardPanel()
	{
		try
		{
			super.instrument =  ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/piano.png"));
			
			KeyBoardPanel.KEY_LEFT_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightLeft.png"));
			KeyBoardPanel.KEY_CENTER_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightMiddle.png"));
			KeyBoardPanel.KEY_RIGHT_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightRight.png"));
			KeyBoardPanel.KEY_BLACK_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightBlack.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		super.keys = new ArrayList<Key>();
		
		try 
		{
			synth = MidiSystem.getSynthesizer();
			synth.open();
			channel = synth.getChannels()[0];
		} 
		catch (MidiUnavailableException e) 
		{
			e.printStackTrace();
		}
		
		this.init();
		repaint();
	}
	
	public static KeyBoardPanel getInstance()
	{
		return instance;
	}
	
	public static void flag()
	{
		playingFlag = true;
	}
	
	public static void unflag()
	{
		playingFlag = false;
	}

	public static boolean isFlagged()
	{
		return playingFlag;
	}
	
	@Override
	public void init()
	{
		
		KeySets.addOctave1(super.keys);
		KeySets.addOctave2(super.keys);
		KeySets.addOctave3(super.keys);
		
		
		for(int i = 0; i < synth.getLoadedInstruments().length; i++)
		{
			
			switch(synth.getLoadedInstruments()[i].getName())
			{
				case "Piano":
					System.out.println(i);
					OptionsPanel.setInstrument("Piano", i);
					break;
				case "Accordion":
					System.out.println(i);
					OptionsPanel.setInstrument("Accordion", i);
					break;
					
				case "Cello":
					//System.out.println(i);
					OptionsPanel.setInstrument("Cello", i);
					break;
					
				case "Flute":
					//System.out.println(i);
					OptionsPanel.setInstrument("Flute", i);
					break;
				case "Harp":
					//System.out.println(i);
					OptionsPanel.setInstrument("Harp", i);
					break;
				case "Trumpet":
					//System.out.println(i);
					OptionsPanel.setInstrument("Trumpet", i);
					break;
				case "Organ":
					//System.out.println(i);
					OptionsPanel.setInstrument("Organ", i);
					break;
				case "Vibraphone":
					//System.out.println(i);
					OptionsPanel.setInstrument("Vibraphone", i);
					break;
				case "Violin":
					//System.out.println(i);
					OptionsPanel.setInstrument("Violin", i);
					break;
					
			}
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(super.instrument, (this.getWidth() / 2) - (super.instrument.getWidth() / 2), this.getY() + 20, null);
		
		int drawingOffset = (this.getWidth() / 2) - (super.instrument.getWidth() / 2) + 1;
		
		for(Key k : super.keys)
		{
			switch(k.getType())
			{
				case Key.KEY_LEFT:
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_LEFT_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset += Key.KEY_WHITE_OFFSET;
					break;
				case Key.KEY_CENTER:
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_CENTER_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset += Key.KEY_WHITE_OFFSET;
					break;
 				case Key.KEY_RIGHT:
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_RIGHT_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset += Key.KEY_WHITE_OFFSET;
					break;
				case Key.KEY_BLACK:
					drawingOffset += Key.KEY_BLACK_OFFSET;
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_BLACK_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset -= Key.KEY_BLACK_OFFSET;
					break;
			}
		}
	}
	
	//Play requested item sent from event in OptionsPanel - we may want to break this up into
	//smaller functions later; this is just to get something working
	public static void play(String item) throws MidiUnavailableException, IOException, InvalidMidiDataException
	{
		InputStream is = null;
		Sequencer sequencer = MidiSystem.getSequencer();
		
		sequencer.open();
		
		switch(item)
		{
			case "Fur Elise":
			try {
				is = new BufferedInputStream(new FileInputStream(new File(KeyBoardPanel.class.getResource("/Sound Assets/beethoven-fur_elise.mid").toURI())));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				sequencer.setSequence(is);
				sequencer.start();
				break;
			default:
				System.err.println("Invalid combo box choice; contact an administrator.");
		}
		Transmitter t = sequencer.getTransmitter();
		Receiver r = sequencer.getReceiver();
		
		/*This can stop all keyboard interaction until the song is done, but would be removed if highlighting
		 * is happening instead
		 * 
		 * while(sequencer.isRunning())
		 * {
		 * 		Thread.sleep(1000);
		 * }
		 * 
		 * unflag();
		 */
	}
	
	public static void setTempo(float tempo)
	{
		KeyBoardPanel.tempo = tempo;
	}
	
	public static void setTone(int instrumentNumber)
	{
		
		channel.programChange(synth.getLoadedInstruments()[instrumentNumber].getPatch().getProgram());
	}
	
	public static void setVolume(int volume)
	{
		KeyBoardPanel.volume = volume;
	}

	public void keyPressed(KeyEvent e)
	{
		if(playingFlag)
			return;
		
		for(Key k : super.keys)
		{
			if(k.getAssignedKey() == e.getKeyCode())
			{
				//System.out.println("You pressed key " + k.getName() + " in octave " + k.getOctave());
				if(k.isFlagged())
				{
					return;
				}
				//k.getNote().setMicrosecondPosition(0);
				//k.getNote().start();
				channel.noteOn(k.getMidiNote(), volume);
				//channel.noteOn(k.getMidiNote(), (OptionsPanel.getVolume()) * 2);
				k.flag();
				repaint();
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		if(playingFlag)
			return;
		
		for(Key k : super.keys)
		{
			if(k.getAssignedKey() == e.getKeyCode())
			{
				//System.out.println("You released key " + k.getName() + " in octave " + k.getOctave());
				//k.getNote().stop();
				channel.noteOff(k.getMidiNote(), volume);
				k.unflag();
				repaint();
			}
		}
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public void playChordA(){
		//this.keys.get(Key.KEY_LEFT, "A key");
		keys.get(9).flag();
		keys.get(12).flag();
		keys.get(16).flag();
		repaint();
		
		/*for(Key k : super.keys)
		{
			if(k.getAssignedKey() == e.getKeyCode())
			{
				k.flag();
			}
		}*/
	
	
	}
	
	public void playChordC(){
		//this.keys.get(Key.KEY_LEFT, "A key");
		keys.get(12).flag();
		keys.get(16).flag();
		keys.get(19).flag();
		repaint();
		
		
		System.out.println(keys.get(16).getFlag());
		
	
		
		
	}
	
	
	public void removedPlayedChord(){
		keys.get(12).unflag();
		keys.get(16).unflag();
		keys.get(19).unflag();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		repaint();
		System.out.println(keys.get(16).getFlag());
	}

	
	public void playChordD(){
		//this.keys.get(Key.KEY_LEFT, "A key");
		keys.get(14).flag();
		keys.get(18).flag();
		keys.get(21).flag();
		repaint();
	}
	
	
}
