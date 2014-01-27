package at.sm0x.fstabgui.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import at.sm0x.fstabgui.gui.FsEntryPanel;
import at.sm0x.fstabgui.core.FstabReader;

public class MFrame extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu mnuFile, mnuSettings, mnuHelp;
	private JMenuItem mnuItemClose, mnuItemSettings, mnuItemAbout;
	private JPanel contentPnl;
	private JProgressBar progBar;
	
	public MFrame()
	{
		FstabReader fsread = new FstabReader();
		setLocation(200, 100);
		setSize(800, 600);
		setTitle("Filesystem Table GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		System.out.println("DEBUG: LayoutManager loaded...");
		
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
		
		System.out.println("LookAndFeel loaded..."); 
		
		createWidgets();
		System.out.println("DEBUG: Objekte sind im Speicher");
		addWidgets();
		System.out.println("DEBUG: Objekte wurden geaddet");
		
		getContentPane().add(menuBar,BorderLayout.PAGE_START);
		
		for(int i = 0; i <= fsread.getFSCount(); i++)
		{
			contentPnl.add(new FsEntryPanel(fsread.getFSArray(i, 0), fsread.getFSArray(i, 1)));
			System.out.println("DEBUG: Schleife wurde "+ i + " mal durchgelaufen");
		}
		
		getContentPane().add(contentPnl, BorderLayout.CENTER);
		getContentPane().add(progBar, BorderLayout.PAGE_END);
		
		setVisible(true);
		
	}

	private void createWidgets() {
		menuBar = new JMenuBar();
		
		System.out.println("DEBUG: Menubar loaded...");
		
		mnuFile = new JMenu("Datei");
		mnuSettings = new JMenu("Bearbeiten");
		mnuHelp = new JMenu("Hilfe");
		
		System.out.println("DEBUG: Menus loaded...");

		
		mnuItemClose = new JMenuItem("Beenden");
		mnuItemSettings = new JMenuItem("Einstellungen");
		mnuItemAbout = new JMenuItem("Über ...");
		
		System.out.println("DEBUG: MenuItems loaded...");
		
		contentPnl = new JPanel();
		contentPnl.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		contentPnl.setAutoscrolls(true);
		
		progBar = new JProgressBar(0, 100);
		
		
		
/*		FsEntryPanel newPnl1 = new FsEntryPanel("/dev/sda1", "/");
		FsEntryPanel newPnl2 = new FsEntryPanel("/dev/sda2", "/home");
		FsEntryPanel newPnl3 = new FsEntryPanel("/dev/sda3", "/media/michael/Daten");


		contentPnl.add(newPnl1);
		contentPnl.add(newPnl2);
		contentPnl.add(newPnl3); 
		*/
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
