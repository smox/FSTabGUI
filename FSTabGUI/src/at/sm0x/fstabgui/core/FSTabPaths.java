package at.sm0x.fstabgui.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FSTabPaths{
	
	public static String fsTabPath = System.getProperty("user.home")+ "/Desktop/TestDir/fstab";
	public static File fileOrig;
	public static File fileBackUp;
	private RandomAccessFile fileWriter;
	public static String welcomeLine;

	
	public FSTabPaths(){
		
		fileOrig = new File("/home/michael/Desktop/TestDir/fstab");
		fileBackUp = new File(fileOrig.getAbsolutePath() +".1");
		
		try {
			fileWriter = new RandomAccessFile(fileOrig.getAbsolutePath(), "rw");
					
			System.out.println(fileWriter.readLine());
				welcomeLine = fileWriter.readLine();
			} catch (IOException e) {
				System.out.println("fstab konnte nicht gefunden werden unter " + 
						FSTabPaths.fsTabPath);
			}
		
	}

}
