package Assignment;

public class StringAndArray {
	
	public void stringMethods() {
		
		String str = "Sample String";
		
//		Some of the String inbuilt methods
		
		int length = str.length(); // returns length of the string 
		
		char charAtIndex = str.charAt(3); // returns char at index 3
		
		boolean contains = str.contains("String"); // checks if str contains "String"
		
		String upperCasedStr = str.toUpperCase(); // returns str with all upper case characters
		
	}
	
	public void arrayBlock() {
		
//		Array storing ages of students (int array)
		int ages[] = {23,12,21};
		
		try {			
			int age_of_2nd_studnet = ages[1]; // accessing array element
		}catch(ArithmeticException e) {
			// Handle arithmetic Exception
		}
		
		
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		
		try {			
			cars[2] = "Audi"; // updating array element
		}catch(ArithmeticException e) {
			// Handle arithmetic Exception
		}
		

		
//		Multi-dimensional array for storing student wise marks
		
		int marks[][] = {{56,67,75},{78,87,54},{83,91,67}}; // ith index represents ith student's marks
		
	}
	
	public static void main(String arg[]) {
		
		StringAndArray object = new StringAndArray();
		
//		calling stringMethods method
		object.stringMethods();
		
//		calling arrayBlock method
		object.arrayBlock();
		
	}
	

}
