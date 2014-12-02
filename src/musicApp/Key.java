package musicApp;

import javax.sound.sampled.Clip;

public class Key
{
	public static final int KEY_LEFT = 0;
	public static final int KEY_CENTER = 1;
	public static final int KEY_RIGHT = 2;
	public static final int KEY_BLACK = 3;
	
	public static final int KEY_WHITE_OFFSET = 38;
	public static final int KEY_BLACK_OFFSET = -12;
	
	private int type;
	private int assignedKey;	
	private int midiNote;
	
	private String name;
	private String octave;
	
	private Clip note;
	
	private boolean paintFlag = false;
	
	public Key(int type, int assignedKey, String name, String octave, Clip note, int midiNote)
	{
		this.type = type;
		this.name = name;
		this.octave = octave;
		this.note = note;
		this.assignedKey = assignedKey;
		this.midiNote = midiNote;
	}
	
	public boolean isFlagged()
	{
		return this.paintFlag;
	}
	
	public void flag()
	{
		this.paintFlag = true;
	}
	
	public void unflag()
	{
		this.paintFlag = false;
	}
	
	public boolean getFlag()
	{
		return this.paintFlag;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getAssignedKey()
	{
		return assignedKey;
	}

	public void setAssignedKey(int assignedKey)
	{
		this.assignedKey = assignedKey;
	}
	
	public int getMidiNote()
	{
		return midiNote;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOctave()
	{
		return octave;
	}

	public void setOctave(String octave)
	{
		this.octave = octave;
	}

	public Clip getNote()
	{
		return note;
	}

	public void setNote(Clip note)
	{
		this.note = note;
	}
}
