package Skillbuilders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class Stat1 {

	public static void main(String[] args) {
		
		File dataFile = new File("..\\Users\\sophi\\git\\CS20P2F2024\\Chapter11\\Test2.txt");
		FileReader in;
		BufferedReader readFile;
		
		NumberFormat percent = NumberFormat.getPercentInstance();		
		String stuName, score;
		double scoreValue;
		double lowScore = 100;
		double highScore = 0;
		double avgScore;
		double totalScore= 0;
		int numScores = 0;
		
		try {
			
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
			
			while((stuName = readFile.readLine()) != null) {
				
				score = readFile.readLine();
				System.out.println(stuName + " " + score);
				
				numScores += 1;
				scoreValue = Double.parseDouble(score);
				totalScore += scoreValue;
				
				if(scoreValue < lowScore) {
					
					lowScore = scoreValue;
					
				}
				
				if (scoreValue > highScore) {
					
					highScore = scoreValue;
				}
				
				
				
			}
			
				avgScore = totalScore / numScores;
				System.out.println("Low score = " + percent.format(lowScore/100));
				System.out.println("High score = " + percent.format(highScore));
				System.out.println("Average = " + percent.format(avgScore));
				
				readFile.close();
				in.close();
		}
		
		catch(FileNotFoundException e) {
			
			System.out.println("File could not be found.");
			System.err.println("FileNotFoundException: "+ e.getMessage());
		}
		
		catch(IOException e) {
			
			System.out.println("Problem reading file.");
			System.err.println("IOException: "+ e.getMessage());
		}

	}

}
