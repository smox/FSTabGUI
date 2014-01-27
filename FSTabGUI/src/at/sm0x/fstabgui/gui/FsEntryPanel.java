package at.sm0x.fstabgui.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FsEntryPanel extends JPanel{
	
	private JLabel lblHdd, lblMountPoint, lblPriv;
	private JTextField txtHdd, txtMountPoint;
	private JButton btnGenFSTab, btnNextEntry;
	private JCheckBox chkPrivR, chkPrivW, chkPrivX;
	
	
	public FsEntryPanel(String hdName, String mountPoint){
		
		setName("Festplatten eintrag:");
		setSize(300, 100);
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		System.out.println("DEBUG: Step 1");
		
		createWidgets(hdName, mountPoint);
		
		System.out.println("DEBUG: Step 2");
		
		addWidgets();
		
		System.out.println("DEBUG: Step 3");
		setVisible(true);
		
		
		System.out.println("Code geladen...");
		
		
		
		
	}


	private void createWidgets(String newHdName, String newMountPoint) {
		lblHdd = new JLabel("HDD: ");
		lblMountPoint = new JLabel("Mountpoint: ");
		lblPriv = new JLabel("Rechte: ");
		
		txtHdd = new JTextField(newHdName);
		txtHdd.setPreferredSize(new Dimension(80, 25));
		txtMountPoint = new JTextField(newMountPoint);
		txtMountPoint.setPreferredSize(new Dimension(100, 25));
		chkPrivR = new JCheckBox("Read");
		chkPrivW = new JCheckBox("Write");
		chkPrivX = new JCheckBox("Execute");
	}


	private void addWidgets() {
		add(lblHdd);
		add(txtHdd);
		add(lblMountPoint);
		add(txtMountPoint);
		add(lblPriv);
		add(chkPrivR);
		add(chkPrivW);
		add(chkPrivX);
	}
}
