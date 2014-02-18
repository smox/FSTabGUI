package at.sm0x.fstabgui.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

public class FstabReader{
	
	private int fsCount = 0;
	
	String[][] fsArray = new String[100][6];
	
	public int getFSCount()
	{
		return fsCount - 1;
	}
	
	public String getFSArray(int i1, int i2){
		return fsArray[i1][i2];
	}
	
	public FstabReader(){
		
		String[] fileSystems = new String[100];
		int si = 0;
		String welcomeLine;
	
		try {
			RandomAccessFile fileRead = new RandomAccessFile(new File (FSTabPaths.fsTabPath), "r");
	
			
			try {
		/*		System.out.println(fileRead.readLine());
				welcomeLine = fileRead.readLine();
				System.out.println(welcomeLine);
				System.out.println(fileRead.readLine());
				System.out.println(fileRead.readLine()); */
				boolean eof = false;
				while(eof == false)
				{	
					String newStr = fileRead.readLine();
						if(newStr != null)
						{
							
							
													
							System.out.println(newStr);
							//TODO Readline
							try{
								if(newStr.charAt(0) == '#'){
									//TODO Handle Comments
									System.out.println(newStr);
									continue;
								}
								else {
									fileSystems[si] = newStr;
									si++;
									fsCount++;
								} 
							} catch (StringIndexOutOfBoundsException se)
							{
								// if the fstab beginning with a emptyLine, skip it and continue the while-loop
								continue;
							}
							
							
							
						} else {
							// TODO EOF!
							eof = true;
						} 
					
					
					
				/*	String newStr = fileRead.readLine();
						if (newStr != null){
							System.out.println("DEBUG: CharAT: "+ newStr.charAt(0));
							if(newStr.charAt(0) == '#')
							{
								System.out.println(newStr);
							}else{
							fileSystems[si] = newStr;
							System.out.println(newStr.charAt(0));
							si++;
							fsCount++;
							}} else{
							eof = true;
						} */
				}	
				
			} catch (IOException e) {
				System.out.println("DEBUG: IOException #1 wurde ausgelöst");
				e.printStackTrace();
			}
			try {
				fileRead.close();
			} catch (IOException e) {
				System.out.println("DEBUG: fileRead.Close Exception wurde ausgelöst...");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DEBUG: FSTab nicht gefunden!");
			System.out.println("DEBUG: FSTAB Path: " + FSTabPaths.fsTabPath);
		}
		
	
		boolean fsSysEnd = false;
		int i2 = 0;
		
		while(fsSysEnd == false)
		{
			if(fileSystems[i2] != null)
			{
				fsArray[i2] = fileSystems[i2].split("\t| +");
			} else {
				fsSysEnd = true;
			}
		i2++;
		}

		System.out.println("DEBUG: Festplattenanzahl: " + getFSCount());
		
		
	
	}
	
}

