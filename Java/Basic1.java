package Assignment;

// Calculator Class
class Calculator{
	
	
//	Class attributes
	public int numberOne;
	public int numberTwo;
	
	
//	Class Methods
//	Setting the value of two numbers
	public void setNumbers(int num1,int num2) {
		this.numberOne = num1;
		this.numberTwo = num2;
	}
	
//	Addition Method
	public int addition() {
		return numberOne + numberTwo;
	}
	
//	Subtraction Method
	public int subtraction() {
		return numberOne - numberTwo;
	}
	
}



public class Basic1 {
	
	public static void main(String arg[]) {
		
//		 Calculator class Object Initialization
		Calculator calObj = new Calculator();
		
		calObj.setNumbers(70, 30);
		
//		Calling addition method
		int addResult = calObj.addition();
		
//		Calling subtraction method
		int subResult = calObj.subtraction();
		
		
		
	}
	
	
}
