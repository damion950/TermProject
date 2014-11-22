package musicApp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window extends JFrame
{
	private Instrument instrument;
	private Settings settings;
	private JPanel currentPanel;
	int winX, winY;
	
	public Instrument getInstrument()
	{
		return instrument;
	}
	
	public void setInstrument(Instrument i)
	{
		instrument = i;
	}
	
	//Display the start up menu
	public void displayMenu()
	{
		final JPanel menuPanel = new JPanel();
		JLabel lblWelcome = new JLabel();
		JButton btnPiano = new JButton();
		
		menuPanel.setLayout(null);
		
		lblWelcome.setBounds(365, 60, 280, 25);
		lblWelcome.setText("Welcome! Please select an instrument below.");
		menuPanel.add(lblWelcome);
		
		btnPiano.setBounds(450, 400, 85, 35);
		btnPiano.setText("Piano");
		btnPiano.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				instrument.setInstrumentName("Piano");
				BufferedImage img = null;
			
				try {
					img = ImageIO.read(new File("Art Assets/piano.png"));
				} catch (IOException e1) {
					System.out.println("Error: Missing image asset. Please contact the administrator or " +
							"reinstall the application.");
					e1.printStackTrace();
				}
				instrument.setImage(img);
				
				remove(menuPanel);
				try {
						displayInstrument();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuPanel.add(btnPiano);
			
		this.setTitle("Welcome!");
		this.add(menuPanel);
		this.currentPanel = menuPanel;
		update();
	}
	
	//Display the window for this instrument
	public void displayInstrument() throws IOException
	{
		JLabel lblTempo = new JLabel();
		JLabel lblVolume = new JLabel();
		JLabel lblScales = new JLabel();
		JLabel lblChords = new JLabel();
		JLabel lblSongs = new JLabel();
		final JSlider sliderTempo = new JSlider(0, 100, 30);
		final JSlider sliderVolume = new JSlider(0, 100, 30);
		//Probably should be attached to instrument or something to be more generic
		String comboScalesItems[] = {"A Major", "B Major", "C Major", "D Major", "E Major", "F Major", "G Major"};
		JComboBox<String> comboScales = new JComboBox<String>(comboScalesItems);
		String comboChordsItems[] = {"C Chord", "D Chord"};
		JComboBox<String> comboChords = new JComboBox<String>(comboChordsItems);
		String comboSongsItems[] = {"Für Elise", "Greensleeves"};
		JComboBox<String> comboSongs = new JComboBox<String>(comboSongsItems);
		JButton btnPlayScales = new JButton();
		JButton btnPlayChords = new JButton();
		JButton btnPlaySongs = new JButton();
		final BufferedImage img = instrument.getImage();
		
		JPanel instrumentPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g)
	        {
	            super.paintComponent(g);
	            g.drawImage(img, ((winX - img.getWidth()) / 2), ((winY - img.getHeight()) / 3), null);
	        }
	    }; 
	    
	    sliderTempo.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e)
			{
				settings.setTempo(sliderTempo.getValue());
			}
	    });
	    
	    sliderVolume.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e)
			{
				settings.setVolume(sliderVolume.getValue());
			}
	    });
	    
	    FlowLayout layout = new FlowLayout();
        instrumentPanel.setLayout(layout);
        
        lblTempo.setBounds(125, 40, 60, 25);
		lblTempo.setText("Tempo");
		instrumentPanel.add(lblTempo);
        
        sliderTempo.setBounds(105, 60, 85, 35);
		instrumentPanel.add(sliderTempo);
		
		lblVolume.setBounds(270, 40, 60, 25);
		lblVolume.setText("Volume");
		instrumentPanel.add(lblVolume);
		
		sliderVolume.setBounds(250, 60, 85, 35);
		instrumentPanel.add(sliderVolume);		
		
		lblScales.setBounds(415, 40, 60, 25);
		lblScales.setText("Scales");
		instrumentPanel.add(lblScales);
		
		comboScales.setPreferredSize(new Dimension(100,25));
		instrumentPanel.add(comboScales);
		
		btnPlayScales.setPreferredSize(new Dimension(60,25));
		btnPlayScales.setText("Play");
		instrumentPanel.add(btnPlayScales);
		
		lblChords.setPreferredSize(new Dimension(50,25));
		lblChords.setText("Chords");
		instrumentPanel.add(lblChords);
		
		comboChords.setPreferredSize(new Dimension(100,25));
		instrumentPanel.add(comboChords);
		
		btnPlayChords.setPreferredSize(new Dimension(60,25));
		btnPlayChords.setText("Play");
		instrumentPanel.add(btnPlayChords);
		
		lblSongs.setPreferredSize(new Dimension(50,25));
		lblSongs.setText("Songs");
		instrumentPanel.add(lblSongs);
		
		comboSongs.setPreferredSize(new Dimension(100,25));
		instrumentPanel.add(comboSongs);
		
		btnPlaySongs.setPreferredSize(new Dimension(60,25));
		btnPlaySongs.setText("Play");
		instrumentPanel.add(btnPlaySongs);
        
		this.setTitle(instrument.getInstrumentName());
		this.add(instrumentPanel);
		
		instrumentPanel.repaint();
		instrumentPanel.revalidate();
			
		currentPanel = instrumentPanel;
		update();
	}
	
	//Update the current panel
	public void update()
	{
		currentPanel.repaint();
		currentPanel.revalidate();
	}
	
	//Update components when window is resized by overriding Container.validate()
	@Override
	public void validate()
	{
		super.validate();
		
		if(currentPanel == null)
			return;
		
		winX = this.getWidth();
		winY = this.getHeight();
		this.update();
	}
	
	public Window()
	{
		this.instrument = new Instrument();
		this.settings = new Settings();
		this.winX = 1000;
		this.winY = 600;
		this.setSize(new Dimension(winX, winY));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setVisible(true);
	}
}
