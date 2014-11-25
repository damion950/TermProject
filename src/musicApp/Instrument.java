package musicApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Instrument
{
	private int highlightOffset = 0;
	private BufferedImage image, currentHighlightedKey, highlightedKeys[] = new BufferedImage[4];
	private String keyType;
	private final static int keyWidth = 38;
	private Octave octave;
	private Settings settings;
	private String instrumentName;
	
	public BufferedImage getHighlightedKey()
	{
		return currentHighlightedKey;
	}
	
	public int getHighlightOffset()
	{
		return highlightOffset;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	
	public Octave getOctave()
	{
		return octave;
	}
	
	public Settings getSettings()
	{
		return settings;
	}
	
	public String getInstrumentName()
	{
		return instrumentName;
	}
	
	public void setImage(BufferedImage i)
	{
		image = i;
	}
	
	public void setOctave(Octave o)
	{
		octave = o;
	}
	
	public void setSettings(Settings s)
	{
		settings = s;
	}
	
	public void setInstrumentName(String name)
	{
		instrumentName = name;
	}
	
	public void highlight(String keyName, JPanel instrumentPanel)
	{
		//Offset from beginning of image that the current octave is at, in pixels
		int offsetWhite = (7 * (octave.getOctaveNum() + 1) * keyWidth) + 1;
		int offsetBlack = offsetWhite + 28;
		
		switch(keyName)
		{
			case "C":
				offsetWhite += keyWidth;
				keyType = "left";
				break;
			case "C#":
			case "Dd":
				keyType = "black";
				break;
			case "D":
				offsetWhite += (keyWidth * 2);
				keyType = "middle";
				break;
			case "D#":
			case "Ed":
				offsetBlack += keyWidth;
				keyType = "black";
				break;
			case "E":
				offsetWhite += (keyWidth * 3);	
				keyType = "right";
				break;
			case "F":
				offsetWhite += (keyWidth * 4);
				keyType = "left";
				break;
			case "F#":
			case "Gd":
				offsetBlack += (keyWidth * 3);
				keyType = "black";
				break;
			case "G":
				offsetWhite += (keyWidth * 5);
				keyType = "middle";
				break;
			case "G#":
			case "Ad":
				offsetBlack += (keyWidth * 4);
				keyType = "black";
				break;
			case "A":
				offsetWhite += (keyWidth * 6);
				keyType = "middle";
				break;
			case "A#":
			case "Bd":
				offsetBlack += (keyWidth * 5);
				keyType = "black";
				break;
			case "B":
				offsetWhite += (keyWidth * 7);
				keyType = "right";
				break;
			default:
				System.out.println("Error: key mismatch while highlighting. Contact an administrator.");
		}
		
		switch(keyType)
		{
			case "left":
				currentHighlightedKey = highlightedKeys[0];
				highlightOffset = offsetWhite;
				break;
			case "middle":
				currentHighlightedKey = highlightedKeys[1];
				highlightOffset = offsetWhite;
				break;
			case "right":
				currentHighlightedKey = highlightedKeys[2];
				highlightOffset = offsetWhite;
				break;
			case "black":
				currentHighlightedKey = highlightedKeys[3];
				highlightOffset = offsetBlack;
				break;
			default:
				System.out.println("Error: key type mismatch while highlighting. Contact an administrator.");
		}
		
		instrumentPanel.repaint();
	}
	
	public void loadImages()
	{
		try
		{
			//imgKey = ImageIO.read(Window.class.getResourceAsStream("testkey.png"));
			image = ImageIO.read(new File("res/Art Assets/Piano/piano.png"));
			highlightedKeys[0] = ImageIO.read(new File("res/Art Assets/Piano/highlightLeft.png"));
			highlightedKeys[1] = ImageIO.read(new File("res/Art Assets/Piano/highlightMiddle.png"));
			highlightedKeys[2] = ImageIO.read(new File("res/Art Assets/Piano/highlightRight.png"));
			highlightedKeys[3] = ImageIO.read(new File("res/Art Assets/Piano/highlightblack.png"));
		}
		catch (IOException e1)
		{
			System.out.println("Error: Missing image asset. Please contact the administrator or " +
					"reinstall the application.");
			e1.printStackTrace();
		}
	}
	
	/*
	 * We should probably have a method that highlights a particular key specified, and one that reverts
	 * the highlight. This could be done by specifying black or white, and naming like method(black, 3)
	 * for the 3rd black key from the left. We could highlight that one by measuring the keys and distance
	 * between them with something like (keyDist + keyWidth) * 3, and start highlighting there.
	 */
	
	public Instrument()
	{
		this.image = null;
		this.settings = null;
		this.octave = new Octave();
		this.instrumentName = "";
	}
	
	public Instrument(BufferedImage image, Octave octave, Settings settings, String name)
	{
		this.image = image;
		this.octave = octave;
		this.settings = settings;
		this.instrumentName = name;
	}
}
