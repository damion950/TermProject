
package musicApp;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Octave
{
	//The current octave you are on; 0 = mid, -1 left, 1 right
	int octaveNum;
	int totalSfiles;
	HashMap<String, Clip> sounds;
	
	public int getOctaveNum()
	{
		return octaveNum;
	}
	
	public void setOctaveNum(int o)
	{
		octaveNum = o;
	}
	
	public void loadSound(String soundName, File soundFile)
	{
		try 
		{
			this.sounds.put(soundName, AudioSystem.getClip()); //get clip gets a new clip from the system
			this.sounds.get(soundName).open(AudioSystem.getAudioInputStream(soundFile)); //opens the sound file with the clip class
		} 
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) 
		{
			//error loading sound
			e.printStackTrace();
		}
		
	}
	
	/*public void play(MIDI soundFile) { }
	 * 
	 *  Play the sound file and call highlight(String keyName) in sync with notes being played
	 */
	
	public void playNote(String soundName)
	{
		try
		{
			this.sounds.get(soundName).start();
		}
		catch(Exception e)
		{
			//file does not exist
			e.printStackTrace();
		}
	}
	
	public Octave()
	{
		this.octaveNum = 0;
		this.totalSfiles = 0;
		this.sounds = new HashMap<String, Clip>();
		
		try 
		{
			/*this.loadSound("Key A", new File(Octave.class.getResource("res/Sound Assets/Key A.wav").toURI()));
			this.loadSound("Key B", new File(Octave.class.getResource("res/Sound Assets/Key B.wav").toURI()));
			this.loadSound("Key C", new File(Octave.class.getResource("res/Sound Assets/Key C.wav").toURI()));
			this.loadSound("Key D", new File(Octave.class.getResource("res/Sound Assets/Key D.wav").toURI()));
			this.loadSound("Key E", new File(Octave.class.getResource("res/Sound Assets/Key E.wav").toURI()));
			this.loadSound("Key F", new File(Octave.class.getResource("res/Sound Assets/Key F.wav").toURI()));
			this.loadSound("Key G", new File(Octave.class.getResource("res/Sound Assets/Key G.wav").toURI()));*/
			System.out.println("Constructor");
			this.loadSound("Key A", new File(Octave.class.getResource("/Key A.wav").toURI()));
			this.loadSound("Key B", new File(Octave.class.getResource("/Key B.wav").toURI()));
			this.loadSound("Key C", new File(Octave.class.getResource("/Key C.wav").toURI()));
			this.loadSound("Key D", new File(Octave.class.getResource("/Key D.wav").toURI()));
			this.loadSound("Key E", new File(Octave.class.getResource("/Key E.wav").toURI()));
			this.loadSound("Key F", new File(Octave.class.getResource("/Key F.wav").toURI()));
			this.loadSound("Key G", new File(Octave.class.getResource("/Key G.wav").toURI()));
		} 
		catch (URISyntaxException | NullPointerException e) 
		{
			//Unable to load sounds
			e.printStackTrace();
		}
		
		//Create an audiostream from the inputstream
	
	}
}
	
	