package musicApp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestSoundsForNow implements ActionListener
{
	public TestSoundsForNow()
	{
		
		// This Test Driver is to test the files stored in the Sound array.
		JFrame myJFrame = new JFrame();
		
		myJFrame.setSize(700,500);
		JPanel myJPanel = new JPanel();
		
		
		
		JButton myButton = new JButton("Click MEEE");
		myButton.setPreferredSize(new Dimension(100,50));
		
		myJFrame.add(myJPanel);
		myJPanel.add(myButton);
		
		
		myButton.addActionListener(this);
		myButton.setVisible(true);		
		myJFrame.setVisible(true);
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new TestSoundsForNow();
	}
	
	public final void actionPerformed(ActionEvent e){
		Octave myOctave = new Octave();
		myOctave.playNote("Key C");
		//myNote.playNote("Key D");
		//myNote.playNote("Key A");
		//myNote.playNote("Key A");
	
	}

	
	
	
	
	
}
