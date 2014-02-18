package at.sm0x.fstabgui.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import at.sm0x.fstabgui.gui.MFrame;

public class FsTabGui {
	
/*	private static JLabel lblWelcome;
	private static JProgressBar progWelcome;
	private static int progressValue; */

	public static void main(String[] args) {
		
	/*	JFrame loadProgram = new JFrame();
		loadProgram.setTitle("Loading Program...");
		loadProgram.setLayout(new BorderLayout());
		lblWelcome = new JLabel("Loading FSTabGUI Alpha!");
		progWelcome = new JProgressBar(JProgressBar.HORIZONTAL, 1, 10);
		
		loadProgram.getContentPane().add(BorderLayout.CENTER,lblWelcome);
		loadProgram.getContentPane().add(BorderLayout.PAGE_END, progWelcome);
		
		loadProgram.pack();
		*/

		if(new File(FSTabPaths.fsTabPath).exists() == false)
		{
			
			System.out.println("FSTab not Found, pls Typ in the Location");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			try {
				String input = in.readLine();
				FSTabPaths.setFSTabPath(input);
			} catch (IOException e1) {
				// TODO Automatisch generierter Erfassungsblock
				e1.printStackTrace();
			}
			
		}
		MFrame mf = new MFrame();
	}

}
