package musicApp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Instrument instrument;
	private Settings settings;
	private JPanel currentPanels[] = new JPanel[3];
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
		
		this.setMinimumSize(new Dimension(550,475));
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
		lblWelcome.setBounds(365, 60, 280, 25);
		lblWelcome.setText("Welcome! Please select an instrument below.");
		lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuPanel.add(lblWelcome);
		
		menuPanel.add(Box.createRigidArea(new Dimension(0,350)));
		
		btnPiano.setBounds(450, 400, 85, 35);
		btnPiano.setText("Piano");
		btnPiano.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPiano.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				instrument.setInstrumentName("Piano");
				BufferedImage img = null;
			
				try {
					img = ImageIO.read(new File("res/Art Assets/Piano/piano.png"));
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
		this.currentPanels[0] = menuPanel;
		update(1);
	}
	
	//Display the window for this instrument
	public void displayInstrument() throws IOException
	{
		JLabel lblTempo = new JLabel();
		JLabel lblVolume = new JLabel();
		JLabel lblScales = new JLabel();
		JLabel lblChords = new JLabel();
		JLabel lblSongs = new JLabel();
		JLabel lblTones = new JLabel();
		final JSlider sliderTempo = new JSlider(0, 100, 30);
		final JSlider sliderVolume = new JSlider(0, 100, 30);
		//Probably should be attached to instrument or something to be more generic
		String comboScalesItems[] = {"A Major", "B Major", "C Major", "D Major", "E Major", "F Major", "G Major"};
		JComboBox<String> comboScales = new JComboBox<String>(comboScalesItems);
		String comboChordsItems[] = {"C Chord", "D Chord"};
		JComboBox<String> comboChords = new JComboBox<String>(comboChordsItems);
		String comboSongsItems[] = {"Fur Elise", "Greensleeves"};
		JComboBox<String> comboSongs = new JComboBox<String>(comboSongsItems);
		String comboTonesItems[] = {"Piano", "Guitar"};
		JComboBox<String> comboTones = new JComboBox<String>(comboTonesItems);
		JButton btnPlayScales = new JButton();
		JButton btnPlayChords = new JButton();
		JButton btnPlaySongs = new JButton();
		JButton btnSetTones = new JButton();
		final BufferedImage img = instrument.getImage();
		OptionsPanel optionsPanel = new OptionsPanel(), optionsPanel1 = new OptionsPanel();
		JPanel instrumentPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g)
	        {
	            super.paintComponent(g);
	            g.drawImage(img, ((winX - img.getWidth()) / 2), ((winY - img.getHeight()) / 3), null);
	        }
	    }; 
	    
	    //Keep all components on screen and visible
	    this.setMinimumSize(new Dimension(905,410));
	    
	    FlowLayout layout = new FlowLayout();
	    optionsPanel.setLayout(layout);
	    optionsPanel1.setLayout(layout);
	    instrumentPanel.setLayout(layout);
	    optionsPanel.setPreferredSize(new Dimension(200,80));
	    
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
        
        lblTempo.setBounds(125, 40, 60, 25);
		lblTempo.setText("Tempo");
		optionsPanel1.add(lblTempo);
        
        sliderTempo.setBounds(105, 60, 85, 35);
		optionsPanel1.add(sliderTempo);
		
		lblVolume.setBounds(270, 40, 60, 25);
		lblVolume.setText("Volume");
		optionsPanel1.add(lblVolume);
		
		sliderVolume.setBounds(250, 60, 85, 35);
		optionsPanel1.add(sliderVolume);		
		
		lblScales.setBounds(415, 40, 60, 25);
		lblScales.setText("Scales");
		optionsPanel.add(lblScales);
		
		comboScales.setPreferredSize(new Dimension(100,25));
		optionsPanel.add(comboScales);
		
		btnPlayScales.setPreferredSize(new Dimension(60,25));
		btnPlayScales.setText("Play");
		optionsPanel.add(btnPlayScales);
		
		lblChords.setPreferredSize(new Dimension(50,25));
		lblChords.setText("Chords");
		optionsPanel.add(lblChords);
		
		comboChords.setPreferredSize(new Dimension(100,25));
		optionsPanel.add(comboChords);
		
		btnPlayChords.setPreferredSize(new Dimension(60,25));
		btnPlayChords.setText("Play");
		optionsPanel.add(btnPlayChords);
		
		lblSongs.setPreferredSize(new Dimension(50,25));
		lblSongs.setText("Songs");
		optionsPanel.add(lblSongs);
		
		comboSongs.setPreferredSize(new Dimension(100,25));
		optionsPanel.add(comboSongs);
		
		btnPlaySongs.setPreferredSize(new Dimension(60,25));
		btnPlaySongs.setText("Play");
		optionsPanel.add(btnPlaySongs);
		
		lblTones.setPreferredSize(new Dimension(50,25));
		lblTones.setText("Tones");
		optionsPanel.add(lblTones);
		
		comboTones.setPreferredSize(new Dimension(100,25));
		optionsPanel.add(comboTones);
		
		btnSetTones.setPreferredSize(new Dimension(60,25));
		btnSetTones.setText("Set");
		optionsPanel.add(btnSetTones);
        
		this.setTitle(instrument.getInstrumentName());
		this.add(optionsPanel);
		this.add(optionsPanel1);
		this.add(instrumentPanel);
			
		currentPanels[0] = optionsPanel;
		currentPanels[1] = optionsPanel1;
		currentPanels[2] = instrumentPanel;
		update(3);
	}
	
	//Update the specified number of current panels
	public void update(int panels)
	{
		for(int i = 0; i < panels; i++)
		{
			currentPanels[i].repaint();
			currentPanels[i].revalidate();
		}
	}
	
	//Update instrument image position when window is resized by overriding Container.validate()
	@Override
	public void validate()
	{
		super.validate();
		
		for(int i = 0; i < 3; i++)
		{
			if(currentPanels[i] == null)
				return;
		}
	
		winX = this.getWidth();
		winY = this.getHeight();
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
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setFocusable(true);
		this.setVisible(true);
	}
}
