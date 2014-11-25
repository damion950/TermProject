package musicApp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener
{
	private final String comboSongsItems[] = { "Fur Elise", "Greensleeves" };
	private final String comboTonesItems[] = { "Piano", "Guitar" };
	private final String comboChordsItems[] = { "C Chord", "D Chord" };
	private final String comboScalesItems[] = { "A Major", "B Major", "C Major", "D Major", "E Major", "F Major", "G Major" };
	
	private JComboBox<String> comboScales;
	private JComboBox<String> comboChords;
	private JComboBox<String> comboSongs;
	private JComboBox<String> comboTones;
	
	private JSlider sliderTempo;
	private JSlider sliderVolume;
	
	private JButton btnPlayScales;
	private JButton btnPlayChords;
	private JButton btnPlaySongs;
	private JButton btnSetTones;
	
	private JLabel lblTempo;
	private JLabel lblVolume;
	private JLabel lblScales;
	private JLabel lblChords;
	private JLabel lblSongs;
	private JLabel lblTones;
	
	public OptionsPanel()
	{
		this.setLayout(new WrapLayout());
		
		this.comboScales = new JComboBox<String>(this.comboScalesItems);
		this.comboChords = new JComboBox<String>(this.comboChordsItems);
		this.comboSongs = new JComboBox<String>(this.comboSongsItems);
		this.comboTones = new JComboBox<String>(this.comboTonesItems);
		 
		this.sliderTempo = new JSlider(0, 100, 30);
		this.sliderVolume = new JSlider(0, 100, 30);
			
		this.btnPlayScales = new JButton();
		this.btnPlayChords = new JButton();
		this.btnPlaySongs = new JButton();
		this.btnSetTones = new JButton();
		
		this.lblTempo = new JLabel();
		this.lblVolume = new JLabel();
		this.lblScales = new JLabel();
		this.lblChords = new JLabel();
		this.lblSongs = new JLabel();
		this.lblTones = new JLabel();
		
		this.init();
	}
	
	public void init()
	{
		this.comboScales.setPreferredSize(new Dimension(100, 25));
		this.add(comboScales);
		
		this.btnPlayScales.setPreferredSize(new Dimension(60, 25));
		this.btnPlayScales.setText("Play");
		this.add(btnPlayScales);
		
		this.lblChords.setPreferredSize(new Dimension(50, 25));
		this.lblChords.setText("Chords");
		this.add(lblChords);
		
		this.comboChords.setPreferredSize(new Dimension(100, 25));
		this.add(comboChords);
		
		this.btnPlayChords.setPreferredSize(new Dimension(60, 25));
		this.btnPlayChords.setText("Play");
		this.add(btnPlayChords);
		
		this.lblSongs.setPreferredSize(new Dimension(50, 25));
		this.lblSongs.setText("Songs");
		this.add(lblSongs);
		
		this.comboSongs.setPreferredSize(new Dimension(100, 25));
		this.add(comboSongs);
		
		this.btnPlaySongs.setPreferredSize(new Dimension(60, 25));
		this.btnPlaySongs.setText("Play");
		this.add(btnPlaySongs);
		
		this.lblTones.setPreferredSize(new Dimension(50, 25));
		this.lblTones.setText("Tones");
		this.add(lblTones);
		
		this.comboTones.setPreferredSize(new Dimension(100, 25));
		this.add(comboTones);
		
		this.btnSetTones.setPreferredSize(new Dimension(60, 25));
		this.btnSetTones.setText("Set");
		this.add(btnSetTones);
		
		this.lblTempo.setBounds(125, 40, 60, 25);
		this.lblTempo.setText("Tempo");
		this.add(lblTempo);
		
		this.sliderTempo.setBounds(105, 60, 85, 35);
		this.add(sliderTempo);
		
		this.lblVolume.setBounds(270, 40, 60, 25);
		this.lblVolume.setText("Volume");
		this.add(lblVolume);
		
		this.sliderVolume.setBounds(250, 60, 85, 35);
		this.add(sliderVolume);
		
		this.lblScales.setBounds(415, 40, 60, 25);
		this.lblScales.setText("Scales");
		this.add(lblScales);
	}

	public void actionPerformed(ActionEvent e)
	{
		//if(e.getSource == this.someObject) {do stuff}
	}
}
