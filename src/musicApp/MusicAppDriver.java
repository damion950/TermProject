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

public class MusicAppDriver
{
	public static void main(String args[]) throws IOException
	{
		Window window = new Window();
		window.displayInstrumentWindow();
	}
}
