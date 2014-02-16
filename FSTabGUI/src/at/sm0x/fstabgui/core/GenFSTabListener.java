package at.sm0x.fstabgui.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import at.sm0x.fstabgui.core.FSTabPaths;
import at.sm0x.fstabgui.gui.FsEntryPanel;

public class GenFSTabListener implements ActionListener{
	
	private ArrayList<FsEntryPanel> arrayList;
	private File fsTabFile;
	private File fsTabBackup;
	
	
	public GenFSTabListener(ArrayList<FsEntryPanel> arrayList){
		
		this.arrayList = arrayList;
		fsTabFile = new File(FSTabPaths.fsTabPath);
		fsTabBackup = new File (FSTabPaths.fsTabPath + ".1");

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Files.copy(Paths.get(fsTabFile.getAbsolutePath()), Paths.get(fsTabBackup.getAbsolutePath()));
		}catch (FileAlreadyExistsException fAlreadyExistsEx){
			System.out.println("Eine Backup-Datei existiert bereits, diese wird gelöscht und durch eine neue ersetzt");
			deleteBackup();
			} catch (IOException e1) {
			// that should never been happen...
			System.out.println("Exception e1 in GenFSTabListener2 wurde geworfen...");
			System.out.println("Are you Root?");
			e1.printStackTrace();
		} 
		
		deleteFSTab();
		createNewFSTab();
		
	} // close ActionPerformed
	
	
		private void createNewFSTab() {
			
		try {
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fsTabFile));
			bufWriter.write("#### Automatic created FSTAB by FSTabGui ###\n");
			bufWriter.write("### For Bugs and Feedback send me an eMail to michaelbrunner88@gmail.com ###\n");
			
			for(int i = 0; i <= arrayList.size()-1; i++)
			{
				JTextField f = (JTextField)arrayList.get(i).getComponent(1);
				JTextField f1 = (JTextField)arrayList.get(i).getComponent(3);
				JTextField f2 = (JTextField)arrayList.get(i).getComponent(5);
				JCheckBox chkr = (JCheckBox)arrayList.get(i).getComponent(7);
				JCheckBox chkw = (JCheckBox)arrayList.get(i).getComponent(8);
				System.out.println("FSTab wurde geschrieben!");
				bufWriter.write(f.getText()+ "\t" + f1.getText()+ "\t" + f2.getText() + "\t" + getOptions(f1.getText(), chkr, chkw)+ "\n");
			}
		bufWriter.close();
		} catch (IOException e) {
			// this should not been happen
			System.out.println("Exception in bufWriter");
			e.printStackTrace();
		}
	}
		
		private String getOptions(String mountPoint, JCheckBox readPerm, JCheckBox writePerm){
			
			String options = null;
			String permissions = null;
			
			if(readPerm.isSelected() & writePerm.isSelected())
			{
				permissions = "rw,";
			} else if (readPerm.isSelected() & writePerm.isSelected() == false)
			{
				permissions = "r,";
			} else if (readPerm.isSelected() == false & writePerm.isSelected())
			{
				permissions = "w,";
			} else if (readPerm.isSelected() == false & writePerm.isSelected() == false)
			{
				permissions = "";
			} else
			{
				System.out.println("Strange...");
			}
			
			switch(mountPoint)
			{
				case "none":
					options = "defaults\t0\t0";
					break;
				case "/":
					options = "rw,relatime,data=ordered\t0\t1";
					break;
				default:
					options = permissions+"relatime,data=ordered\t0\t2";
			}
			return options;
			
		}


		private void deleteBackup(){
			try {
				Files.delete(Paths.get(fsTabBackup.getAbsolutePath()));
				Files.copy(Paths.get(fsTabFile.getAbsolutePath()), Paths.get(fsTabBackup.getAbsolutePath()));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	} //close deleteItem Method
		
		private void deleteFSTab(){
				try {
					Files.delete(Paths.get(fsTabFile.getAbsolutePath()));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} // close deleteFSTab
	
} // close Class
