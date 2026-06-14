package Skillbuilders;

import java.io.Serializable;

public class StuName implements Serializable {

	private String firstName, lastName;
	
	public StuName(String fn, String ln) {
		
		firstName = fn;
		lastName = ln;
		
	}
	
	public String toString() {
		
		String stuName;
		
		stuName = firstName + " " + lastName;
		
		return stuName;
	}
	
}
