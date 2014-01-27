package at.sm0x.fstabgui.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class FstabReader{
	
	private int fsCount = 0;
	
	String[][] fsArray = new String[100][6];
	
	public int getFSCount()
	{
		return fsCount;
	}
	
	public String getFSArray(int i1, int i2){
		return fsArray[i1][i2];
	}
	
	public FstabReader(){
		
		String[] fileSystems = new String[100];
		int si = 0;
		String welcomeLine;
	
		try {
			RandomAccessFile fileRead = new RandomAccessFile(new File ("/home/michael/Desktop/TestDir/fstab"), "r");
			
			try {
				System.out.println(fileRead.readLine());
				welcomeLine = fileRead.readLine();
				System.out.println(welcomeLine);
				System.out.println(fileRead.readLine());
				System.out.println(fileRead.readLine());
				boolean eof = false;
				while(eof == false)
				{
					String newStr = fileRead.readLine();
										
					if (newStr != null)
					{
						fileSystems[si] = newStr;
						si++;
						fsCount++;
					} else {
						eof = true;
					}
				}				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DEBUG: FSTab nicht gefunden!");
		}
		
	
		boolean fsSysEnd = false;
		int i2 = 0;
		
		while(fsSysEnd == false)
		{
			if(fileSystems[i2] != null)
			{
				fsArray[i2] = fileSystems[i2].split("\t");
			} else {
				fsSysEnd = true;
			}
		i2++;
		}
	

		
		
		System.out.println(fsArray[0][0]);
		System.out.println(fsArray[1][0]);
		System.out.println("DEBUG: Festplattenanzahl: " + getFSCount());
	
	
	}
	
}

