package musicApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	private KeyBoardPanel instrument;
	private OptionsPanel options;
	private SliderPanel settings;
	
	public Window(int width, int height, String title) throws MidiUnavailableException
	{
		this.setTitle(title);
		this.setSize(new Dimension(width, height));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
			
		this.instrument = new KeyBoardPanel();
		this.options = new OptionsPanel();
		this.settings = new SliderPanel();
		this.setFocusable(true);
		this.addKeyListener(this.instrument);
		
		/*options.setBackground(Color.GREEN);
		instrument.setBackground(Color.YELLOW);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.add(this.options);
		this.add(this.instrument);*/
		this.add(this.options, BorderLayout.NORTH);
		this.add(this.instrument, BorderLayout.CENTER);
		this.add(this.settings, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
