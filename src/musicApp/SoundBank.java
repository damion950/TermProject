package musicApp;

import java.io.File;
import java.net.URISyntaxException;

public class SoundBank {
	// These arrays are parallel
	Octave octaveList[];
	String soundTypes[];

	public SoundBank() {

		/****************************************************
		 * In here i'd like to store the sounds in an array.
		 ****************************************************/

		octaveList = new Octave[6];
		
		for (char i = 'A'; i < 'G'; i++) {
			
			octaveList[((int) i) - 65] = new Octave();

			try {
				octaveList[((int) i) - 65].loadSound("Key " + i, new File(Octave.class
						.getResource("/Key " + i + ".wav").toURI()));
			} catch (URISyntaxException e) {

				e.printStackTrace();
			}
		}

	}

	public Octave[] getOctave() {
		return octaveList;
	}

	public String[] getSoundTypes() {
		return soundTypes;
	}

	public void setOctive(Octave sf[]) {
		octaveList = sf;
	}

	public void setSoundTypes(String st[]) {
		soundTypes = st;
	}
}