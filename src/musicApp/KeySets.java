package musicApp;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeySets
{
	public static void addOctave1(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_A, "C Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_W, "C# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_S, "D Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_E, "D# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_D, "E Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_F, "F Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_T, "F# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_G, "G Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_Y, "Ad Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
	}
	
	public static void addOctave2(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_H, "A Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_U, "Bd Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_J, "B Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_K, "C Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_O, "C# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_L, "D Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_P, "D# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.getExtendedKeyCodeForChar(';'), "E Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav")));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_QUOTE, "F Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.getExtendedKeyCodeForChar(']'), "F# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav")));
		
	}
	
}
