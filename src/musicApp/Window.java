package musicApp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Window extends JFrame
{
	private Instrument instrument;
	private Settings settings;
	private JFrame window;
	
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
	}
	
	//Display the window for this instrument
	public void displayInstrument() throws IOException
	{
		JButton btn = new JButton();
		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		JButton btn3 = new JButton();
		JButton btn4 = new JButton();
		JLabel lblTempo = new JLabel();
		JLabel lblVolume = new JLabel();
		JSlider sliderTempo = new JSlider();
		JSlider sliderVolume = new JSlider();
		final BufferedImage img = ImageIO.read(new File("Art Assets/piano.png"));
		
		JPanel instrumentPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 105, 200, null);
	        }
	    }; 
	    
	   // this.repaint();
	   // this.revalidate();
        instrumentPanel.setLayout(null);
        
        btn.setBounds(105,60,85,35);
        btn.setText("Button");
       // instrumentPanel.add(btn);
        
        btn1.setBounds(275, 60, 85, 35);
        btn1.setText("Button");
        //instrumentPanel.add(btn1);
        
        btn2.setBounds(445, 60, 85, 35);
        btn2.setText("Button");
        instrumentPanel.add(btn2);
        
        btn3.setBounds(615, 60, 85, 35);
        btn3.setText("Button");
        instrumentPanel.add(btn3);
        
        btn4.setBounds(785, 60, 85, 35);
        btn4.setText("Button");
       // instrumentPanel.add(btn4);
        
        sliderTempo.setBounds(105, 60, 85, 35);
		instrumentPanel.add(sliderTempo);
		
		lblTempo.setBounds(125, 40, 60, 25);
		lblTempo.setText("Tempo");
		instrumentPanel.add(lblTempo);
		
		sliderVolume.setBounds(250, 60, 85, 35);
		instrumentPanel.add(sliderVolume);
		
		lblVolume.setBounds(270, 40, 60, 25);
		lblVolume.setText("Volume");
		instrumentPanel.add(lblVolume);
        
		this.setTitle("Instrument Page");
		this.add(instrumentPanel);
		
		instrumentPanel.repaint();
		instrumentPanel.revalidate();
	}
	
	public Window()
	{
		this.setSize(new Dimension(1000, 600));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
