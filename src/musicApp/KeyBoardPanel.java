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
	
	public KeyBoardPanel() throws MidiUnavailableException
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
		
		synth = MidiSystem.getSynthesizer();
		synth.open();
		channel = synth.getChannels()[0];
		
		this.init();
		repaint();
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
		InputStream is;
		Sequencer sequencer = MidiSystem.getSequencer();
		
		sequencer.open();
		
		switch(item)
		{
			case "Fur Elise":
				is = new BufferedInputStream(new FileInputStream(new File("C:/Users/Damion/workspace/Term Project/res/Sound Assets/beethoven-fur_elise.mid")));
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
}
