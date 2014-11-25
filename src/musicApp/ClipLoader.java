package musicApp;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ClipLoader
{
	private ClipLoader()
	{
		
	}
	
	public static Clip loadClip(String soundFile)
	{
		try
		{
			AudioInputStream in = AudioSystem.getAudioInputStream(ClipLoader.class.getResource(soundFile));
			
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			
			return clip;
		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			System.out.println("ERROR: Loading clip failed!");
		}
		
		return null;
	}
}
