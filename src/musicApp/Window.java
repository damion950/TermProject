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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
		final BufferedImage img = instrument.getImage();
		
		JPanel instrumentPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	        	//System.out.println("Painting at: " + (winX / 10) + ", " + (winY / 10));
	            super.paintComponent(g);
	            g.drawImage(img, ((winX - img.getWidth()) / 2), ((winY - img.getHeight()) / 3), null);
	            //g.drawImage(img, 105, 200, null);
	        }
	    }; 
	    
	    
	   // this.repaint();
	   // this.revalidate();
	    FlowLayout layout = new FlowLayout();
        instrumentPanel.setLayout(layout);
        
        btn.setBounds(105,60,85,35);
        btn.setText("Button");
       // instrumentPanel.add(btn);
        
        btn1.setBounds(275, 60, 85, 35);
        btn1.setText("Button");
        //instrumentPanel.add(btn1);
        
        btn2.setBounds(445, 60, 85, 35);
        btn2.setText("Button");
      //  instrumentPanel.add(btn2);
        
        btn3.setBounds(615, 60, 85, 35);
        btn3.setText("Button");
       // instrumentPanel.add(btn3);
        
        btn4.setBounds(785, 60, 85, 35);
        btn4.setText("Button");
       // instrumentPanel.add(btn4);
        
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
        
		this.setTitle(instrument.getInstrumentName());
		this.add(instrumentPanel);
		
		//while(true)
		//{
			instrumentPanel.repaint();
			instrumentPanel.revalidate();
		//}
			
		currentPanel = instrumentPanel;
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
		this.winX = 1000;
		this.winY = 600;
		this.setSize(new Dimension(winX, winY));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
