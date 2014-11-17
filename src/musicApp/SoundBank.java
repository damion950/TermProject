package musicApp;

public class SoundBank
{
	//These arrays are parallel
	Notes soundFiles[];
	String soundTypes[];
	
	public Notes[] getSoundFiles()
	{
		return soundFiles;
	}
	
	public String[] getSoundTypes()
	{
		return soundTypes;
	}
	
	public void setSoundFiles(Notes sf[])
	{
		soundFiles = sf;
	}
	
	public void setSoundTypes(String st[])
	{
		soundTypes = st;
	}
}
