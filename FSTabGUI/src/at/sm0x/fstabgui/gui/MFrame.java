package at.sm0x.fstabgui.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MFrame extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu mnuFile, mnuSettings, mnuHelp;
	private JMenuItem mnuItemClose, mnuItemSettings, mnuItemAbout;
	
	public MFrame()
	{
		
		setLocation(200, 100);
		setSize(600, 600);
		setTitle("Filesystem Table GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		createWidgets();
		addWidgets();
		
		getContentPane().add(menuBar,BorderLayout.PAGE_START);
		
		setVisible(true);
		
	}

	private void createWidgets() {
		menuBar = new JMenuBar();
		
		mnuFile = new JMenu("Datei");
		mnuSettings = new JMenu("Bearbeiten");
		mnuHelp = new JMenu("Hilfe");
		
		mnuItemClose = new JMenuItem("Beenden");
		mnuItemSettings = new JMenuItem("Einstellungen");
		mnuItemAbout = new JMenuItem("Über ...");
		
		
		
	}

	private void addWidgets() {
		
		menuBar.add(mnuFile);
		menuBar.add(mnuSettings);
		menuBar.add(mnuHelp);
		
		mnuFile.add(mnuItemClose);
		mnuSettings.add(mnuItemSettings);
		mnuHelp.add(mnuItemAbout);
		
		
	}

}
