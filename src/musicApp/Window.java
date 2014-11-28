package musicApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	private KeyBoardPanel instrument;
	private OptionsPanel settings;
	
	public Window(int width, int height, String title)
	{
		this.setTitle(title);
		this.setSize(new Dimension(width, height));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.instrument = new KeyBoardPanel();
		this.settings = new OptionsPanel();
		this.setFocusable(true);
		this.addKeyListener(this.instrument);
		
		this.add(this.settings, BorderLayout.NORTH);
		this.add(this.instrument, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
