package musicApp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import javax.sound.midi.MidiUnavailableException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener
{
	private final String comboSongsItems[] = { "Fur Elise", "Greensleeves" };
	private final String comboTonesItems[] = { "Accordion", "Cello", "Flute", "Harp", "Organ", "Piano", "Trumpet",
			"Vibraphone", "Violin"};
	private static final int PIANO = 0, VIBRAPHONE = 11, ORGAN = 16, ACCORDION = 21, VIOLIN = 40,
			 CELLO = 42, HARP = 46, TRUMPET = 56, FLUTE = 73;
	private final String comboChordsItems[] = { "C Chord", "D Chord" };
	private final String comboScalesItems[] = { "A Major", "B Major", "C Major", "D Major", "E Major", "F Major", "G Major" };
	
	private JComboBox<String> comboScales;
	private JComboBox<String> comboChords;
	private JComboBox<String> comboSongs;
	private JComboBox<String> comboTones;
	
	private JButton btnPlayScales;
	private JButton btnPlayChords;
	private JButton btnPlaySongs;
	
	private JLabel lblScales;
	private JLabel lblChords;
	private JLabel lblSongs;
	private JLabel lblTones;
	
	String item;
	
	public OptionsPanel()
	{
		this.setLayout(new WrapLayout());
		
		this.comboScales = new JComboBox<String>(this.comboScalesItems);
		this.comboChords = new JComboBox<String>(this.comboChordsItems);
		this.comboSongs = new JComboBox<String>(this.comboSongsItems);
		this.comboTones = new JComboBox<String>(this.comboTonesItems);
			
		this.btnPlayScales = new JButton();
		this.btnPlayChords = new JButton();
		this.btnPlaySongs = new JButton();
		
		this.lblScales = new JLabel();
		this.lblChords = new JLabel();
		this.lblSongs = new JLabel();
		this.lblTones = new JLabel();
		
		this.init();
	}
	
	public void init()
	{
		this.lblScales.setBounds(415, 40, 60, 25);
		this.lblScales.setText("Scales");
		this.add(lblScales);
		
		this.comboScales.setPreferredSize(new Dimension(100, 25));
		this.add(comboScales);
		comboScales.setFocusable(false);
		
		this.btnPlayScales.setPreferredSize(new Dimension(60, 25));
		this.btnPlayScales.setText("Play");
		this.add(btnPlayScales);
		btnPlayScales.setFocusable(false);
		btnPlayScales.addActionListener(this);
		
		this.lblChords.setPreferredSize(new Dimension(50, 25));
		this.lblChords.setText("Chords");
		this.add(lblChords);
		
		this.comboChords.setPreferredSize(new Dimension(100, 25));
		this.add(comboChords);
		comboChords.setFocusable(false);
		
		this.btnPlayChords.setPreferredSize(new Dimension(60, 25));
		this.btnPlayChords.setText("Play");
		this.add(btnPlayChords);
		btnPlayChords.setFocusable(false);
		btnPlayChords.addActionListener(this);
		
		this.lblSongs.setPreferredSize(new Dimension(50, 25));
		this.lblSongs.setText("Songs");
		this.add(lblSongs);
		
		this.comboSongs.setPreferredSize(new Dimension(100, 25));
		this.add(comboSongs);
		comboSongs.setFocusable(false);
		
		this.btnPlaySongs.setPreferredSize(new Dimension(60, 25));
		this.btnPlaySongs.setText("Play");
		this.add(btnPlaySongs);
 
		this.btnPlaySongs.addActionListener(this);
		
		
		

		btnPlaySongs.setFocusable(false);
		btnPlaySongs.addActionListener(this);

		
		this.lblTones.setPreferredSize(new Dimension(50, 25));
		this.lblTones.setText("Tones");
		this.add(lblTones);
		
		this.comboTones.setPreferredSize(new Dimension(100, 25));
		this.add(comboTones);
		comboTones.setSelectedIndex(5);
		comboTones.setFocusable(false);
		comboTones.addActionListener(this);
		
		this.setFocusable(false);
	}

	public void actionPerformed(ActionEvent e)
	{

		System.out.println("Button pressed");
		//if(e.getSource == this.someObject) {do stuff}

		new TestMidi();
		System.out.println("Hellloo in actionPerformed");

		if(e.getSource() == this.btnPlaySongs)
		{
			//This needs to go in a "Stop" button later, along with stopping of midi synthesizer
			if(KeyBoardPanel.isFlagged())
			{
				KeyBoardPanel.unflag();
				return;
			}
			
			KeyBoardPanel.flag();
			item = (String) this.comboSongs.getSelectedItem();
			try {
				KeyBoardPanel.play(item);
			} catch (MidiUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidMidiDataException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if(e.getSource() == this.comboTones)
		{
			int instrumentNumber = 0;
			
			switch((String) this.comboTones.getSelectedItem())
			{
				case "Accordion":
					instrumentNumber = ACCORDION;
					break;
				case "Cello":
					instrumentNumber = CELLO;
					break;
				case "Flute":
					instrumentNumber = FLUTE;
					break;
				case "Harp":
					instrumentNumber = HARP;
					break;
				case "Organ":
					instrumentNumber = ORGAN;
					break;
				case "Piano":
					instrumentNumber = PIANO;
					break;
				case "Trumpet":
					instrumentNumber = TRUMPET;
					break;
				case "Vibraphone":
					instrumentNumber = VIBRAPHONE;
					break;
				case "Violin":
					instrumentNumber = VIOLIN;
					break;
				default:
					System.err.println("Error: Invalid tone. Reverting to piano.");
					instrumentNumber = PIANO;
			}
			
			KeyBoardPanel.setTone(instrumentNumber);
		}

	}
	

}
