package Skillbuilders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Roster {

	public static void main(String[] args) {
		
		File stuNameFile;
		Scanner userinput = new Scanner(System.in);
		
		String fileName, firstName, lastName;
		int numStudents;
		
		//Get the file name and # of students from user
		System.out.println("Enter the file name for student roster: ");
		fileName = userinput.nextLine();
		
		stuNameFile = new File(fileName);
		
		System.out.println("How many students? ");
		numStudents = userinput.nextInt();
		
		try {
			
			//write Objects to the file
			
			FileOutputStream out = new FileOutputStream(stuNameFile);
			ObjectOutputStream writeStu = new ObjectOutputStream(out);
			
			for(int i = 0; i < numStudents; i++) {
				
				System.out.println("Enter student first name: ");
				firstName = userinput.next();
				
				System.out.println("Enter student last name: ");
				lastName = userinput.next();
				
				writeStu.writeObject(new StuName(firstName, lastName));
			}
			
			writeStu.close();
			System.out.println("Data has been written to the file.");
			
			//Read and display objects from the file
			FileInputStream in = new  FileInputStream(stuNameFile);
			ObjectInputStream readStuName = new ObjectInputStream(in);
			
			for(int i = 0; i < numStudents; i++) {
				System.out.println((StuName)readStuName.readObject());
			}
			
		readStuName.close();
		
		}
		
		catch(FileNotFoundException e) {
			
			System.out.println("File could not be found.");
			System.err.println("FileNotFoundException: "+ e.getMessage());
		}
		
		catch(IOException e) {
			
			System.out.println("Problem reading file.");
			System.err.println("IOException: "+ e.getMessage());
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("Class could not be used to cast ");
			System.err.println("ClassNotFoudException: " + e.getMessage());
		}

	}

}
