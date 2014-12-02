package musicApp;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeySets
{
	public static void addOctave1(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_Q, "C Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 60));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_2, "C# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 61));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_W, "D Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 62));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_3, "D# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 63));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_E, "E Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 64));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_R, "F Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 65));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_5, "F# Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 66));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_T, "G Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 67));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_6, "Ad Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 68));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_Y, "A Key", "1", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 69));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_7, "Bd Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 70));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_U, "B Key", "1", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 71));
	}
	
	public static void addOctave2(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_I, "C Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 72));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_9, "C# Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 73));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_O, "D Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 74));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_0, "D# Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 75));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_P, "E Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 76));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.getExtendedKeyCodeForChar('['), "F Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 77));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.getExtendedKeyCodeForChar('='), "F# Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 78));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_Z, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 79));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_S, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 80));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_X, "A Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 81));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_D, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 82));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_C, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 83));
		}
	
	public static void addOctave3(ArrayList<Key> keys)
	{
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_V, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 84));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_G, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 85));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.VK_B, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 86));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_H, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 87));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.VK_N, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 88));
		keys.add(new Key(Key.KEY_LEFT, KeyEvent.VK_M, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 89));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_K, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 90));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.getExtendedKeyCodeForChar(','), "F Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 91));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.VK_L, "G Key", "2", ClipLoader.loadClip("/Sound Assets/Key B.wav"), 91));
		keys.add(new Key(Key.KEY_CENTER, KeyEvent.getExtendedKeyCodeForChar('.'), "F Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 92));
		keys.add(new Key(Key.KEY_BLACK, KeyEvent.getExtendedKeyCodeForChar(';'), "F Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 93));
		keys.add(new Key(Key.KEY_RIGHT, KeyEvent.getExtendedKeyCodeForChar('/'), "F Key", "2", ClipLoader.loadClip("/Sound Assets/Key A_edit.wav"), 94));
	}
	
}
