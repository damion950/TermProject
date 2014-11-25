package musicApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
