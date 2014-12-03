package musicApp;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class KeyBoardPanel extends InstrumentPanel implements KeyListener, ActionListener
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
	Timer myTimer = new Timer(1000, this);
	
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
	
	public static float getTempo()
	{
		return tempo;
	}
	
	@Override
	public void init()
	{
		
		KeySets.addOctave1(super.keys);
		KeySets.addOctave2(super.keys);
		KeySets.addOctave3(super.keys);
		
		//This is for tones, and does not work correctly
		for(int i = 0; i < synth.getLoadedInstruments().length; i++)
		{
			//System.out.println(i +  synth.getLoadedInstruments()[i].getName());
			//System.out.println("count: " + i + "  Name: " + synth.getLoadedInstruments()[i].getName());
			switch(synth.getLoadedInstruments()[i].getName())
			{
				case "Piano":
					System.out.println("count: " + i + "  Piano found");
					OptionsPanel.setInstrument("Piano", i);
					break;
				case "Accordion":
					System.out.println("count: " + i + "  Accordion found");
					OptionsPanel.setInstrument("Accordion", i);
					break;
					
				case "Cello":
					System.out.println("count: " + i + "  Cello found");
					OptionsPanel.setInstrument("Cello", i);
					break;
					
				case "Flute":
					System.out.println("count: " + i + "  Flute found");
					OptionsPanel.setInstrument("Flute", i);
					break;
				case "Trumpet":
					System.out.println("count: " + i + "  Trumpet found");
					OptionsPanel.setInstrument("Trumpet", i);
					break;
				case "Vibraphone":
					System.out.println("count: " + i + "  Vibraphone found");
					OptionsPanel.setInstrument("Vibraphone", i);
					break;
				case "Violin":
					System.out.println("count: " + i + "  Violin found");
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
	public static void play(String item, float tempo) throws MidiUnavailableException, IOException, InvalidMidiDataException
	{
		InputStream is = null;
		Sequencer sequencer = MidiSystem.getSequencer();
		
		sequencer.open();
		sequencer.setTempoFactor(tempo);
		
		switch(item)
		{
			case "Fur Elise":
			try {
				is = new BufferedInputStream(new FileInputStream(new File(KeyBoardPanel.class.getResource("/Sound Assets/beethoven-fur_elise.mid").toURI())));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
				sequencer.setSequence(is);
				sequencer.start();
				break;
			default:
				System.err.println("Invalid combo box choice; contact an administrator.");
		}
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
				if(k.isFlagged())
				{
					return;
				}
				channel.noteOn(k.getMidiNote(), volume);
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
				channel.noteOff(k.getMidiNote(), volume);
				k.unflag();
				repaint();
			}
		}
	}

	public void keyTyped(KeyEvent e)
	{
		
	}	

	public void playChord(String chord) throws InterruptedException{
		
		switch(chord)
		{
			case "C":
				channel.noteOn(keys.get(12).getMidiNote(), volume);
				channel.noteOn(keys.get(16).getMidiNote(), volume);
				channel.noteOn(keys.get(19).getMidiNote(), volume);

				keys.get(12).flag();
				keys.get(16).flag();
				keys.get(19).flag();
				this.revalidate();
				this.repaint();
			
			myTimer.start();
				break;
			case "D":
				channel.noteOn(keys.get(14).getMidiNote(), volume);
				channel.noteOn(keys.get(18).getMidiNote(), volume);
				channel.noteOn(keys.get(21).getMidiNote(), volume);
				keys.get(14).flag();
				keys.get(18).flag();
				keys.get(21).flag();
				myTimer.start();
				break;
			case "E":
				channel.noteOn(keys.get(17).getMidiNote(), volume);
				channel.noteOn(keys.get(21).getMidiNote(), volume);
				channel.noteOn(keys.get(24).getMidiNote(), volume);
				keys.get(16).flag();
				keys.get(20).flag();
				keys.get(23).flag();
				myTimer.start();
				break;		
		}
		
		repaint();
	}

	public void removedPlayedChord(){		
		keys.get(12).unflag();
		keys.get(16).unflag();
		keys.get(19).unflag();

		repaint();
		System.out.println(keys.get(16).getFlag());
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.myTimer)
		{
			myTimer.stop();
			keys.get(12).unflag();
			keys.get(16).unflag();
			keys.get(19).unflag();
			keys.get(14).unflag();
			keys.get(18).unflag();
			keys.get(21).unflag();
			keys.get(16).unflag();
			keys.get(20).unflag();
			keys.get(23).unflag();
			this.repaint();
		}
	}	
}
