package at.sm0x.fstabgui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import at.sm0x.fstabgui.core.FstabReader;
import at.sm0x.fstabgui.core.GenFSTabListener;

public class MFrame extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu mnuFile, mnuSettings, mnuHelp;
	private JMenuItem mnuItemClose, mnuItemSettings, mnuItemAbout;
	private JPanel contentPnl, buttonPnl, fsPnl;
	private JScrollPane fsScrollPane;
	private JButton btnGenFSTab, btnNewEntry, btnRemEntry;
	private JScrollPane scrollPane;
	private JProgressBar progBar;
	private int elementCount;
	
	
	public ArrayList<FsEntryPanel> fsPnlList = new ArrayList<FsEntryPanel>();
	
	
	public void addEmptyFSPanel()
	{
		fsScrollPane.add(new FsEntryPanel("", "", ""));
	}
	
	public MFrame()
	{
		FstabReader fsread = new FstabReader();
		setLocation(200, 100);
//		setSize(900, 600);
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
		
/*		for(int i = 0; i <= fsread.getFSCount(); i++)
		{
			fsPnl.add(new FsEntryPanel(fsread.getFSArray(i, 0), fsread.getFSArray(i, 1),
					fsread.getFSArray(i, 2)));
			System.out.println("DEBUG: Schleife wurde "+ i + " mal durchgelaufen");
		}
		*/
		
		for(int i = 0; i <= fsread.getFSCount(); i++)
		{
			fsPnlList.add(new FsEntryPanel(fsread.getFSArray(i, 0), fsread.getFSArray(i, 1), 
					fsread.getFSArray(i, 2)));
		}
		
		for(int i = 0; i <= (fsPnlList.size() - 1); i++)
		{
			fsPnl.add(fsPnlList.get(i));
			elementCount++;
			
		}
		
	
		
		
		contentPnl.add(scrollPane);
	//	fsPnl.setPreferredSize(new Dimension(900, 400));
		contentPnl.add(Box.createVerticalGlue());
		contentPnl.add(buttonPnl);
		contentPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(contentPnl, BorderLayout.CENTER);
		getContentPane().add(progBar, BorderLayout.PAGE_END);
		
		setVisible(true);
		
		pack();
		
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
		contentPnl.setLayout(new BoxLayout(contentPnl, BoxLayout.PAGE_AXIS));
		
		fsPnl = new JPanel();
		fsPnl.setLayout(new BoxLayout(fsPnl, BoxLayout.PAGE_AXIS));
		fsPnl.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		
		
		buttonPnl = new JPanel();
		buttonPnl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		buttonPnl.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		
		btnNewEntry = new JButton("New Entry");
		btnGenFSTab = new JButton("Generate new FS Table..");
		btnRemEntry = new JButton("Remove Entry");
		
		scrollPane = new JScrollPane(fsPnl, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
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
		
		
		buttonPnl.add(btnRemEntry);
		buttonPnl.add(btnNewEntry);
		buttonPnl.add(btnGenFSTab);
		buttonPnl.setMaximumSize(new Dimension(buttonPnl.getPreferredSize()));		
		
		btnNewEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fsPnlList.add(new FsEntryPanel("", "", ""));
				fsPnl.add(fsPnlList.get(fsPnlList.size()-1));
				fsPnl.validate();
				scrollPane.getViewport().setView(fsPnl);
			}
		});
		
		btnRemEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fsPnl.remove(fsPnlList.size()-1);
				fsPnlList.remove(fsPnlList.size()-1);
				fsPnl.validate();
				scrollPane.getViewport().setView(fsPnl);
				
			}
		});
		
		btnGenFSTab.addActionListener(new GenFSTabListener(fsPnlList));
		
	}

}
