package at.sm0x.fstabgui.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GenFSTabListener implements ActionListener{
	
	
	private RandomAccessFile fileWriter;
	private File fileHandler;
	
    File fSrc = new File("/home/michael/Desktop/TestDir/fstab"); // Quelldatei 
    File fDes = new File("/home/michael/Desktop/TestDir/fstab2"); // Zieldatei
	
	
	public GenFSTabListener(ArrayList ar) {
		
		fileHandler = new File("/home/michael/Desktop/TestDir/fstab");
		
		
		
		try {
			fileWriter = new RandomAccessFile(new File("/home/michael/Desktop/TestDir/newFSTab"), "rw");
		} catch (FileNotFoundException e) {
			System.out.println("Die Datei wurde nicht gefunden!");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void copy(File fSrc, File fDes)
	{
		
		  try {
	      final FileInputStream fis;
			fis = new FileInputStream(fSrc);  //Stream fuer Quelldatei
			
	      FileOutputStream fos;
	      fos = new FileOutputStream(fDes); //Stream fuer Zieldatei

	      byte buf[] = new byte[1024]; // Buffer für gelesene Daten
			while ( fis.read(buf) != -1 ) { // solange lesen, bis EOF
		  fos.write(buf); // Inhalt schreiben
			}
	      fis.close();
	      fos.flush();
	      fos.close();
	      
		  } catch (FileNotFoundException e) {
				System.out.println("DEBUG: File nicht gefunden!");
				e.printStackTrace();
		  } catch (IOException e)
		  {
			System.out.println("DEBUG: IO Exception #2 wurde geworfen");
			e.printStackTrace();
		  }
	} 

}
