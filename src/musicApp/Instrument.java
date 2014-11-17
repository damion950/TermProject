package musicApp;

import java.awt.Image;

public class Instrument
{
	//private Image image;
	private Notes notes;
	private Settings settings;
	private String instrumentName;
	
	public Image getImage()
	{
		return image;
	}
	
	public Notes getNotes()
	{
		return notes;
	}
	
	public Settings getSettings()
	{
		return settings;
	}
	
	public String getInstrumentName()
	{
		return instrumentName;
	}
	
	public void setImage(Image i)
	{
		image = i;
	}
	
	public void setNotes(Notes n)
	{
		notes = n;
	}
	
	public void setSettings(Settings s)
	{
		settings = s;
	}
	
	public void setInstrumentName(String name)
	{
		instrumentName = name;
	}
}
