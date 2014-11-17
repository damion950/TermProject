package musicApp;

public class Settings
{
	int tempo, volume;
	SoundBank soundBank;
	String octave;
	
	public int getTempo()
	{
		return tempo;
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	public SoundBank getSoundBank()
	{
		return soundBank;
	}
	
	public String getOctave()
	{
		return octave;
	}
	
	public void setTempo(int t)
	{
		tempo = t;
	}
	
	public void setVolume(int v)
	{
		volume = v;
	}
	
	public void setSoundBank(SoundBank sb)
	{
		soundBank = sb;
	}
	
	public void setOctave(String o)
	{
		octave = o;
	}
}
