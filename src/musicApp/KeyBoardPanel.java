package musicApp;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class KeyBoardPanel extends InstrumentPanel implements KeyListener
{
	private static BufferedImage KEY_LEFT_IMAGE;
	private static BufferedImage KEY_CENTER_IMAGE;
	private static BufferedImage KEY_RIGHT_IMAGE;
	private static BufferedImage KEY_BLACK_IMAGE;
	
	public KeyBoardPanel()
	{
		try
		{
			super.instrument =  ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/piano.png"));
			
			KeyBoardPanel.KEY_LEFT_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightLeft.png"));
			KeyBoardPanel.KEY_CENTER_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightMiddle.png"));
			KeyBoardPanel.KEY_RIGHT_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightRight.png"));
			KeyBoardPanel.KEY_BLACK_IMAGE = ImageIO.read(KeyBoardPanel.class.getResourceAsStream("/Art Assets/Piano/highlightBlack.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		super.keys = new ArrayList<Key>();
		
		this.init();
		repaint();
	}

	@Override
	public void init()
	{
		KeySets.addOctave1(super.keys);
		KeySets.addOctave2(super.keys);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		g.drawImage(super.instrument, (this.getWidth() / 2) - (super.instrument.getWidth() / 2), this.getY() + 20, null);
		
		int drawingOffset = (this.getWidth() / 2) - (super.instrument.getWidth() / 2) + 1;
		
		for(Key k : super.keys)
		{
			switch(k.getType())
			{
				case Key.KEY_LEFT:
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_LEFT_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset += Key.KEY_WHITE_OFFSET;
					break;
				case Key.KEY_CENTER:
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_CENTER_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset += Key.KEY_WHITE_OFFSET;
					break;
				case Key.KEY_RIGHT:
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_RIGHT_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset += Key.KEY_WHITE_OFFSET;
					break;
				case Key.KEY_BLACK:
					drawingOffset += Key.KEY_BLACK_OFFSET;
					if(k.isFlagged())
						g.drawImage(KeyBoardPanel.KEY_BLACK_IMAGE, drawingOffset, this.getY() + 20, null);
					drawingOffset -= Key.KEY_BLACK_OFFSET;
					break;
			}
		}
	}

	public void keyPressed(KeyEvent e)
	{
		for(Key k : super.keys)
		{
			if(k.getAssignedKey() == e.getKeyCode())
			{
				System.out.println("You pressed key " + k.getName() + " in octave " + k.getOctave());
				k.getNote().loop(Clip.LOOP_CONTINUOUSLY);
				k.flag();
				repaint();
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		for(Key k : super.keys)
		{
			if(k.getAssignedKey() == e.getKeyCode())
			{
				System.out.println("You released key " + k.getName() + " in octave " + k.getOctave());
				k.getNote().stop();
				k.unflag();
				repaint();
			}
		}
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
}
