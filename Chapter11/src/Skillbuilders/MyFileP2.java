package Skillbuilders;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFileP2 {
	

	public static void main(String[] args) {
		
		File textFile;
		Scanner input = new Scanner(System.in);
		String response;
		
		//create a file
		textFile = new File("..\\Users\\sophi\\git\\CS20P2F2024\\Chapter11\\src\\Skillbuilders\\zzz.txt");
		

		if(textFile.exists())
		
		{
			System.out.println("zzz.txt file exists.");
		}
		
		else {
			
			try {
				textFile.createNewFile();
				System.out.println("zzz.text file created.");
			}
			
			catch(IOException e) {
				System.out.println("File could not be created.");
				System.err.println("IOException: "+ e.getMessage());
			}
		}
			
			//Delete if user chooses
			
			System.out.println("Would you like to (K)eep or (D)elete the file? ");
			response = input.next();
			
			if (response.equalsIgnoreCase("D")) {
				
				if(textFile.delete()) {
					System.out.println("zzz.text file deleted. ");
				}}
				
			else {
					System.out.println("zzz.text is kept. ");
				
			}
		}
		
	}

