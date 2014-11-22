package musicApp;

import java.awt.image.BufferedImage;

public class Instrument
{
	private BufferedImage image;
	private Octave octave;
	private Settings settings;
	private String instrumentName;
	
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
