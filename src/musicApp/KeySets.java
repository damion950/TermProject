package musicApp;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeySets
{
	public static void addOctave1(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_A, "C Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 60));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_W, "C# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 61));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_S, "D Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 62));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_E, "D# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 63));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_D, "E Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 64));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_F, "F Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 65));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_T, "F# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 66));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_G, "G Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 67));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_Y, "Ad Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 68));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_H, "A Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 69));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_U, "Bd Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 70));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_J, "B Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 71));
	}
	
	public static void addOctave2(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_K, "C Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 72));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_O, "C# Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 73));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_L, "D Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 74));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_P, "D# Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 75));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.getExtendedKeyCodeForChar(';'), "E Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 76));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_QUOTE, "F Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 77));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.getExtendedKeyCodeForChar(']'), "F# Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 78));		
	}
	
}
