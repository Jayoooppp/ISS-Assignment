package Assignment;

import java.text.DecimalFormat;

public class LoopsAndDM {
	
	public void decisionMaking() {
		
//		if-else statement
		
		int number = 10;
		
		if(number % 2 == 0) {
			// Even Number			
		}else {
			// Odd Number
		}
		
//		if-else if statement
		
		int marks = 65;
		if(marks <= 35) {
			// Bad Marks
		}else if(marks > 35 && marks <= 65) {
			// Average Marks
		}else {
			// Good Marks
		}	
	}
	
	public void forLoop() {
		
//		Loop for adding first N natural numbers 
		int N = 200;
		int total = 0;
		for(int i = 0;i <= N;i++) {
			total += i;
		}	
	}
	
	public void whileLoop() {
		
//		Adding 1 into current number while it is less than N
		
		int curr_number = 10;
		int N = 100;
		
		while(curr_number < N) {
			curr_number++;
		}
		
	}
	
	public void switchBlock() {
		int day = 4;
		String dayName = "";
		
		switch(day) {
			
		case 1:
			dayName = "Monday";
		
		case 2:
			dayName = "Tuesday";
		
		case 3:
			dayName = "Wednesday";
			
		case 4:
			dayName = "Thursday";
			
		case 5:
			dayName = "Friday";
		
		case 6:
			dayName = "Saturday";
			
		case 7:
			dayName = "Sunday";
			
		default:
			dayName = "Not valid number";
			
		}
		
	}
	
	public static void main(String arg[]) {
		
		LoopsAndDM object = new LoopsAndDM();
		
//		Decision making method
		object.decisionMaking();
		
//		For loops method
		object.forLoop();
		
//		While loops method
		object.whileLoop();
		
//		Switch statement method
		object.switchBlock();
					
	}
	
}
