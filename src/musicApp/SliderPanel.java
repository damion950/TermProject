package musicApp;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SliderPanel extends JPanel
{
	private JSlider sliderTempo, sliderVolume;
	private JLabel lblTempo, lblVolume;
	
	public SliderPanel()
	{
		this.setLayout(new WrapLayout());
		
		this.lblTempo = new JLabel();
		this.lblVolume = new JLabel();
		
		this.sliderTempo = new JSlider(0, 100, 30);
		this.sliderVolume = new JSlider(0, 100, 30);
		
		this.init();
	}
	
	public void init()
	{
		this.lblTempo.setBounds(125, 40, 60, 25);
		this.lblTempo.setText("Tempo");
		this.add(lblTempo);
		
		this.sliderTempo.setBounds(105, 60, 85, 35);
		this.add(sliderTempo);
		sliderTempo.setValue(50);
		sliderTempo.setFocusable(false);
		
		this.lblVolume.setBounds(270, 40, 60, 25);
		this.lblVolume.setText("Volume");
		this.add(lblVolume);
		
		this.sliderVolume.setBounds(250, 60, 85, 35);
		this.add(sliderVolume);
		sliderVolume.setValue(50);
		sliderVolume.setFocusable(false);
		
		sliderTempo.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e)
			{
				KeyBoardPanel.setTempo((float)(sliderTempo.getValue()/50.0));
			}
	    });
	    
	    sliderVolume.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e)
			{
				KeyBoardPanel.setVolume(sliderVolume.getValue());
			}
	    });
		
		this.setFocusable(false);
	}
}
