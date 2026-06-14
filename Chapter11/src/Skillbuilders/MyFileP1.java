package Skillbuilders;

import java.io.File;
import java.util.Scanner;

public class MyFileP1 {

	public static void main(String[] args) {
		
		File textFile;
		Scanner input = new Scanner(System.in);
		String fileName;
		//obtain file name from user
		System.out.println("Enter The File Name: ");
		fileName = input.nextLine();
		
		//Determine if file exist or not
		textFile = new File(fileName);
		
		if(textFile.exists()) {
			System.out.println("File Exists.");
		}
		else {
			System.out.println("File Doesn't Exists.");
		}
		
	}

}
