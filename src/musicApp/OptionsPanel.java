package musicApp;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel
{
	@Override
	public Dimension getMinimumSize()
	{
		Dimension size = super.getMinimumSize();
		size.height = 45;
		return size;
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		Dimension size = super.getPreferredSize();
		size.height = 45;
		return size;
	}
	
	@Override
	public Dimension getMaximumSize()
	{
		Dimension size = super.getMaximumSize();
		size.height = 45;
		return size;
	}
	
	public OptionsPanel()
	{
		super();
	}
}
