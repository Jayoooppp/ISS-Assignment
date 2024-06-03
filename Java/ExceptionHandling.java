package Assignment;

public class ExceptionHandling {
	
	public void tryCatchBlock() {
//		Simple try-catch block 
		
		try {
			int ans = 100 / 0;
		}catch(ArithmeticException e) {
			// Handle arithmetic Exception 
		}
	}
	
	public void nestedTryCatchBlock() {
//		Nested try-catch block
		
		try {
			try {
				String s = null;
				int length = s.length();
			}catch(NullPointerException e) {
				// Handle null pointer Exception
			}
			
			try {
				int arr[] = new int[5];
				arr[10] = 24;
			}catch(IndexOutOfBoundsException e) {
				// Handle out of bound Exception
			}
			
		}catch(Exception e) {
				// Handle Exception
		}
	}
	
	public void tryCatchFinallyBlock() {
//		try-catch with finally 
		try {
			String str = "Hello World";
			int i = Integer.parseInt(str);
		}catch(NumberFormatException e) {
			// Handle number format Exception
		}finally {
			// Finally block will get executed irrespective of error occurs or not
		}
	}
	
	public void throwExceptionBlock(int number) {
//		if number is less than 0 throw Exception 
		if(number < 0) {
			throw new ArithmeticException("\n Number is less than 0");
		}
	}
	
//	throws Exception Block 
	public int divideNumbers(int number1,int number2) throws ArithmeticException{
		int ans = number1 / number2;
		return ans;
	}
	
	
	
	
	public static void main(String arg[]) {

		ExceptionHandling eh = new ExceptionHandling();
		
		eh.tryCatchBlock(); // try-catch block
		eh.nestedTryCatchBlock(); //nested try-catch block
		eh.tryCatchFinallyBlock(); // try-catch-finally block
		eh.throwExceptionBlock(-1); // throw Exception
		try {
			int answer = eh.divideNumbers(120, 0); //throws Exception
		}catch(ArithmeticException e) {
			// Handle arithmetic Exception
		}
	}

}
