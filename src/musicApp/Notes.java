package musicApp;

import java.io.File;

public class Notes
{
	File soundFiles[];
	String octave;
	
	public File[] getSoundFiles()
	{
		return soundFiles;
	}
	
	public String getOctave()
	{
		return octave;
	}
	
	public void setSoundFiles(File sounds[])
	{
		soundFiles = sounds;
	}
	
	public void setOctave(String o)
	{
		octave = o;
	}
}
