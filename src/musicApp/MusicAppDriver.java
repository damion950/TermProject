package musicApp;

import java.awt.Dimension;
import java.io.IOException;

public class MusicAppDriver
{
	public static void main(String args[]) throws IOException, InterruptedException
	{
		Window window = new Window();
		
		window.displayMenu();
	}
}
