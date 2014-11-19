package musicApp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	//Display the window for this instrument
	public void displayInstrumentWindow() throws IOException
	{
		JButton btn = new JButton();
		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		JButton btn3 = new JButton();
		JButton btn4 = new JButton();
		final BufferedImage img = ImageIO.read(new File("Art Assets/piano.png"));
		
		JPanel instrumentPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 105, 200, null);
	        }
	    }; 
	    
        instrumentPanel.setLayout(null);
        
        btn.setBounds(105,60,85,35);
       // btn.setSize(30,30);
        //btn.setPreferredSize(new Dimension(30,30));
        btn.setText("Button");
        instrumentPanel.add(btn);
        
        btn1.setBounds(275, 60, 85, 35);
        btn1.setText("Button");
        instrumentPanel.add(btn1);
        
        btn2.setBounds(445, 60, 85, 35);
        btn2.setText("Button");
        instrumentPanel.add(btn2);
        
        btn3.setBounds(615, 60, 85, 35);
        btn3.setText("Button");
        instrumentPanel.add(btn3);
        
        btn4.setBounds(785, 60, 85, 35);
        btn4.setText("Button");
        instrumentPanel.add(btn4);
		
		window = new JFrame("Instrument Page");
		window.setSize(new Dimension(1000, 600));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(instrumentPanel);
		window.setVisible(true);
	}
}
