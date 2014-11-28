package musicApp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public abstract class InstrumentPanel extends JPanel
{
	protected BufferedImage instrument;
	protected ArrayList<Key> keys;
	
	public abstract void init();
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
