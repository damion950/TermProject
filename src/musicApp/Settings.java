package musicApp;

public class Settings
{
	private int tempo, volume;
	private SoundBank soundBank;
	
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
}
