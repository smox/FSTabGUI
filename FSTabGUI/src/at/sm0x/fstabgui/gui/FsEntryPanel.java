package at.sm0x.fstabgui.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class FsEntryPanel extends JPanel{
	
	private JLabel lblHdd, lblMountPoint, lblFilesys, lblPriv;
	private JTextField txtHdd, txtMountPoint, txtFilesys;
	private JCheckBox chkPrivR, chkPrivW, chkPrivX;
	
	
	public FsEntryPanel(String hdName, String mountPoint, String fsys){
		
		setName("Festplatten eintrag:");
		setSize(300, 100);
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		System.out.println("DEBUG: Step 1");
		
		createWidgets(hdName, mountPoint, fsys);
		
		System.out.println("DEBUG: Step 2");
		
		
		
		addWidgets();
		
		System.out.println("DEBUG: Step 3");
		
		
		
		setVisible(true);
		
		
		System.out.println("Code geladen...");
		
		
		
		
	}


	private void createWidgets(String newHdName, String newMountPoint, String fsys) {
		lblHdd = new JLabel("HDD: ");
		lblMountPoint = new JLabel("Mountpoint: ");
		lblFilesys = new JLabel("Filesystem: ");
		lblPriv = new JLabel("Rechte: ");
		
		txtHdd = new JTextField(newHdName);
		txtHdd.setPreferredSize(new Dimension(200,txtHdd.getMinimumSize().height));
		txtMountPoint = new JTextField(newMountPoint);
		txtMountPoint.setPreferredSize(new Dimension(200,txtMountPoint.getMinimumSize().height));
		txtFilesys = new JTextField(fsys);
		txtFilesys.setPreferredSize(new Dimension(50,txtFilesys.getMinimumSize().height));
		txtFilesys.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent arg0) {
				if (txtFilesys.getText().equals("swap")){
					txtMountPoint.setText("none");
					txtMountPoint.setEditable(false);
				} else {
					txtMountPoint.setEditable(true);
				}
				
			}
		});
		chkPrivR = new JCheckBox("Read");
		chkPrivW = new JCheckBox("Write");
		chkPrivX = new JCheckBox("Execute");
	}


	private void addWidgets() {
		add(lblHdd);
		add(txtHdd);
		add(lblMountPoint);
		add(txtMountPoint);
		add(lblFilesys);
		add(txtFilesys);
		add(lblPriv);
		add(chkPrivR);
		add(chkPrivW);
		add(chkPrivX);
	}
}
